/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package mpdp.algorithm;

import com.google.common.collect.Lists;
import dataProcess.model.WeightAdult2DGroup;
import dataProcess.model.WeightOriginAdult2D;
import dataProcess.service.WeightAdult2DGroupService;
import mpdp.base.WeightGroup;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;
import util.SpringUtil;
import util.TimeKeepUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Gonjan
 * @version $Id: WeightBG.java, v 0.1 2017年11月29日 21:14 Gonjan Exp $
 */
public class WeightBG {

    /**
     * 参数l，
     * 分组算法满足 l-diversity
     */
    private static Integer L_PARAM = 5;

    /**
     * 2维敏感属性算法，返回剩余元组
     * @param weightOriginAdult2DS
     * @param context
     * @return
     */
    public List<WeightOriginAdult2D>  weightBG2D(List<WeightOriginAdult2D> weightOriginAdult2DS, ApplicationContext context) throws Exception {

        WeightAdult2DGroupService adult2DGroupService = SpringUtil.getBean(context, WeightAdult2DGroupService.class);



        //深克隆的元组，方便多次分组算法，重复计算，计平均值
        List<WeightOriginAdult2D> cloneOriginTuple = cloneTuples(weightOriginAdult2DS);

        //记录每次算法的时间
        List<Long> timeList = Lists.newArrayList();

        //创建分组，保存每次得到的分组结果
        WeightGroup<WeightOriginAdult2D> group = new WeightGroup<>(L_PARAM,3.0);

        //已经分好组的元组，最后插入数据库
        List<WeightAdult2DGroup> hasInGroupTuples = Lists.newArrayList();

        //无法分组的剩余元组
        List<WeightOriginAdult2D> surplusTuples = Lists.newArrayList();

        //每次分组中，已加入分组中的隐私属性
        Set<String> choosenAttrs = new HashSet<String>();

        //计时开始
        for(int i = 1; i <= 10; i++) {
            TimeKeepUtil.startTheTime();
            while(!weightOriginAdult2DS.isEmpty()) {
                Iterator<WeightOriginAdult2D> originAdult2DIterator = weightOriginAdult2DS.iterator();
                while(originAdult2DIterator.hasNext()) {
                    WeightOriginAdult2D weightOriginAdult2D = originAdult2DIterator.next();

                    //当前元组能够加入分组
                    if(putinChoosens(weightOriginAdult2D, choosenAttrs, group)) {
                        group.add(weightOriginAdult2D);
                        group.setGroupWeight(group.getGroupWeight() + weightOriginAdult2D.getWeight());
                        //删除当前元组
                        originAdult2DIterator.remove();
                        //当前分组已满,达到分组要求
                        if(group.isFull()) {
                            //保存分组
                            addTuplesToLastList(hasInGroupTuples,group);
                            clearChoosenAttrs(choosenAttrs);
                            group.clearWithIdIncrease();
                            //成功找到一个分组，跳出内层循环，从头开始找下一个分组
                            break;
                        }
                    }
                }

                //分组未完成
                if(!group.isEmpty() && !group.isFull()) {
                    surplusTuples.addAll(group.getGroupContainer());
                    group.clearWithoutIdIncrease();
                    clearChoosenAttrs(choosenAttrs);
                }
            }

            long durationTime = TimeKeepUtil.getLengthOfTime();
            System.out.println("第" + i + "次分组算法耗时：" + durationTime + "ms");
            timeList.add(durationTime);
            if(i != 10) { //不是最后一次
                weightOriginAdult2DS.clear();
                hasInGroupTuples.clear();
                surplusTuples.clear();
                group.reset();
                choosenAttrs.clear();
                //复制，once again！
                weightOriginAdult2DS = cloneTuples(cloneOriginTuple);
            }
        }

        int avgTime = getavgTime(timeList);
        System.out.println("算法平均执行时间: " + avgTime);
        if(hasInGroupTuples.size() > 0) {
            adult2DGroupService.insertByBatch(hasInGroupTuples);
        }

        return surplusTuples;
    }

    private void addTuplesToLastList(List<WeightAdult2DGroup> hasInGroupTuples, WeightGroup<WeightOriginAdult2D> group) {
        List<WeightOriginAdult2D> weightOriginAdult2DS = group.getGroupContainer();
        for(WeightOriginAdult2D weightOriginAdult2D : weightOriginAdult2DS) {
            WeightAdult2DGroup weightAdult2DGroup = new WeightAdult2DGroup();
            weightAdult2DGroup.setAge(weightOriginAdult2D.getAge());
            weightAdult2DGroup.setEducation(weightOriginAdult2D.getEducation());
            weightAdult2DGroup.setNativeCountry(weightOriginAdult2D.getNativeCountry());
            weightAdult2DGroup.setOccupation(weightOriginAdult2D.getOccupation());
            weightAdult2DGroup.setSex(weightOriginAdult2D.getSex());
            weightAdult2DGroup.setGroupId(group.getGroupId());
            weightAdult2DGroup.setTupleId(weightOriginAdult2D.getId());
            weightAdult2DGroup.setWeight(weightOriginAdult2D.getWeight());
            hasInGroupTuples.add(weightAdult2DGroup);
        }
    }

    /**
     *深克隆数组中的数据
     * @param tuple
     * @param <T>
     * @return
     * @throws Exception
     */
    private <T> List<T> cloneTuples(List<T> tuple) throws Exception {
        List<T> cloneList = Lists.newArrayList();
        for(T t : tuple) {
            cloneList.add((T) BeanUtils.cloneBean(t));
        }
        return cloneList;
    }



    /**
     * （元组的隐私属性是否可在图中选取）元组的是否可被选取加入当前组
     * @param weightOriginAdult2D 当前元组的所有隐私属性
     * @param choosenAttrs 当前分组中已有的隐私属性
     * @param group
     * @return true 可以选取该元组到当前组
     *         false 不能选取当前元组到当前组，违背l-diversity原则
     */
    private boolean putinChoosens(WeightOriginAdult2D weightOriginAdult2D, Set<String> choosenAttrs,
                                  WeightGroup<WeightOriginAdult2D> group) {

        boolean result = true;
        List<String> attrs = weightOriginAdult2D.getSensitiveAttrs();

        //记录已经插入choosensAttrs的属性，一旦插入失败，需要将已经该元组插入的属性全部移除
        List<String> hasAddIn = new ArrayList<String>();

        for(String attr : attrs) {
            if(!choosenAttrs.add(attr)) { //插入失败
                choosenAttrs.removeAll(hasAddIn);
                result =  false;
                break;
            }
            hasAddIn.add(attr);
        }

        //插入元组后，权值分组权值大于预设最大权值，则不能插入
        if(group.getGroupWeight() + weightOriginAdult2D.getWeight() > group.getMaxGroupWeight()) {
            choosenAttrs.removeAll(hasAddIn);
            result = false;
        }

        hasAddIn.clear();
        return result;
    }

    private void clearChoosenAttrs(Set<String> choosenAttrs) {
        choosenAttrs.clear();
    }

    /**
     * 获取平均时间
     * @param timeList
     * @return
     */
    private int getavgTime(List<Long> timeList) {
        Collections.sort(timeList, (Long o1, Long o2) -> {
            if(o1.longValue() > o2.longValue()) {
                return 1;
            }
            else if(o1.equals(o2)) {
                return 0;
            }
            else {
                return -1;
            }
        });

        int size = timeList.size();
        int sum = 0;
        for(int i = 0; i < size; i++) {
            if(i != 0 && i != size - 1) {
                sum += timeList.get(i);
            }
        }

        return sum / (size - 2);
    }


}