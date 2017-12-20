/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package mpdp.algorithm;

import com.google.common.collect.Lists;
import dataProcess.model.Adult2DGroup;
import dataProcess.model.Adult3DGroup;
import dataProcess.model.Adult4DGroup;
import dataProcess.model.Adult5DGroup;
import dataProcess.model.OriginAdult2D;
import dataProcess.model.OriginAdult3D;
import dataProcess.model.OriginAdult4D;
import dataProcess.model.OriginAdult5D;
import dataProcess.service.Adult2DGroupService;
import dataProcess.service.Adult3DGroupService;
import dataProcess.service.Adult4DGroupService;
import dataProcess.service.Adult5DGroupService;
import mpdp.base.Group;
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
 * @version $Id: CommonBG.java, v 0.1 2017年11月29日 21:14 Gonjan Exp $
 */
public class CommonBG {

    /**
     * 参数l，
     * 分组算法满足 l-diversity
     */
    private static Integer L_PARAM = 5;

    /**
     * 2维敏感属性算法，返回剩余元组
     * @param originAdult2DS
     * @param context
     * @return
     */
    public List<OriginAdult2D> commonBG2D(List<OriginAdult2D> originAdult2DS, ApplicationContext context) throws Exception {

        Adult2DGroupService adult2DGroupService = SpringUtil.getBean(context, Adult2DGroupService.class);

        //深克隆的元组，方便多次分组算法，重复计算，计平均值
        List<OriginAdult2D> cloneOriginTuple = cloneTuples(originAdult2DS);

        //记录每次算法的时间
        List<Long> timeList = Lists.newArrayList();

        //创建分组，保存每次得到的分组结果
        Group<OriginAdult2D> group = new Group<OriginAdult2D>(L_PARAM);

        //已经分好组的元组，最后插入数据库
        List<Adult2DGroup> hasInGroupTuples = Lists.newArrayList();

        //无法分组的剩余元组
        List<OriginAdult2D> surplusTuples = Lists.newArrayList();

        //每次分组中，已加入分组中的隐私属性
        Set<String> choosenAttrs = new HashSet<String>();

        //计时开始
        for(int i = 1; i <= 10; i++) {
            TimeKeepUtil.startTheTime();
            while(!originAdult2DS.isEmpty()) {
                Iterator<OriginAdult2D> originAdult2DIterator = originAdult2DS.iterator();
                while(originAdult2DIterator.hasNext()) {
                    OriginAdult2D originAdult2D = originAdult2DIterator.next();
                    List<String> sensitiveAttrs = originAdult2D.getSensitiveAttrs();

                    //当前元组能够加入分组
                    if(putinChoosens(sensitiveAttrs, choosenAttrs)) {
                        group.add(originAdult2D);
                        //删除当前元组
                        originAdult2DIterator.remove();
                        //当前分组已满,达到分组要求
                        if(group.isFull()) {
                            //保存分组
                            //int result = adult2DGroupService.insertByBatch(group);
                            //addTuplesToLastList(hasInGroupTuples,group);
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
                originAdult2DS.clear();
                hasInGroupTuples.clear();
                surplusTuples.clear();
                group.reset();
                choosenAttrs.clear();
                //复制，once again！
                originAdult2DS = cloneTuples(cloneOriginTuple);
            }
        }

        int avgTime = getavgTime(timeList);
        System.out.println("算法平均执行时间: " + avgTime);
        if(hasInGroupTuples.size() > 0) {
            adult2DGroupService.insertByBatch(hasInGroupTuples);
        }

        return surplusTuples;
    }


    /**
     * 3维敏感属性算法，返回剩余元组
     * @param originAdult3DS
     * @param context
     * @return
     */
    public List<OriginAdult3D> commonBG3D(List<OriginAdult3D> originAdult3DS, ApplicationContext context) throws Exception {

        Adult3DGroupService adult3DGroupService = SpringUtil.getBean(context, Adult3DGroupService.class);

        //深克隆的元组，方便多次分组算法，重复计算，计平均值
        List<OriginAdult3D> cloneOriginTuple = cloneTuples(originAdult3DS);

        //记录每次算法的时间
        List<Long> timeList = Lists.newArrayList();

        //创建分组，保存每次得到的分组结果
        Group<OriginAdult3D> group = new Group<OriginAdult3D>(L_PARAM);

        //已经分好组的元组，最后插入数据库
        List<Adult3DGroup> hasInGroupTuples = Lists.newArrayList();

        //无法分组的剩余元组
        List<OriginAdult3D> surplusTuples = Lists.newArrayList();

        //每次分组中，已加入分组中的隐私属性
        Set<String> choosenAttrs = new HashSet<String>();

        //计时开始
        for(int i = 1; i <= 10; i++) {
            TimeKeepUtil.startTheTime();
            while(!originAdult3DS.isEmpty()) {
                Iterator<OriginAdult3D> originAdult3DIterator = originAdult3DS.iterator();
                while(originAdult3DIterator.hasNext()) {
                    OriginAdult3D originAdult3D = originAdult3DIterator.next();
                    List<String> sensitiveAttrs = originAdult3D.getSensitiveAttrs();

                    //当前元组能够加入分组
                    if(putinChoosens(sensitiveAttrs, choosenAttrs)) {
                        group.add(originAdult3D);
                        //删除当前元组
                        originAdult3DIterator.remove();
                        //当前分组已满,达到分组要求
                        if(group.isFull()) {
                            //保存分组
                            //int result = adult2DGroupService.insertByBatch(group);
                            //addTuplesToLastList(hasInGroupTuples,group);
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
                originAdult3DS.clear();
                hasInGroupTuples.clear();
                surplusTuples.clear();
                group.reset();
                choosenAttrs.clear();
                //复制，once again！
                originAdult3DS = cloneTuples(cloneOriginTuple);
            }
        }

        int avgTime = getavgTime(timeList);
        System.out.println("算法平均执行时间: " + avgTime);
        if(hasInGroupTuples.size() > 0) {
            adult3DGroupService.insertByBatch(hasInGroupTuples);
        }

        return surplusTuples;
    }

    /**
     * 4维敏感属性算法，返回剩余元组
     * @param originAdult4DS
     * @param context
     * @return
     */
    public List<OriginAdult4D> commonBG4D(List<OriginAdult4D> originAdult4DS, ApplicationContext context) throws Exception {

        Adult4DGroupService adult4DGroupService = SpringUtil.getBean(context, Adult4DGroupService.class);

        //深克隆的元组，方便多次分组算法，重复计算，计平均值
        List<OriginAdult4D> cloneOriginTuple = cloneTuples(originAdult4DS);

        //记录每次算法的时间
        List<Long> timeList = Lists.newArrayList();

        //创建分组，保存每次得到的分组结果
        Group<OriginAdult4D> group = new Group<OriginAdult4D>(L_PARAM);

        //已经分好组的元组，最后插入数据库
        List<Adult4DGroup> hasInGroupTuples = Lists.newArrayList();

        //无法分组的剩余元组
        List<OriginAdult4D> surplusTuples = Lists.newArrayList();

        //每次分组中，已加入分组中的隐私属性
        Set<String> choosenAttrs = new HashSet<String>();

        //计时开始
        for(int i = 1; i <= 10; i++) {
            TimeKeepUtil.startTheTime();
            while(!originAdult4DS.isEmpty()) {
                Iterator<OriginAdult4D> originAdult4DIterator = originAdult4DS.iterator();
                while(originAdult4DIterator.hasNext()) {
                    OriginAdult4D originAdult4D = originAdult4DIterator.next();
                    List<String> sensitiveAttrs = originAdult4D.getSensitiveAttrs();

                    //当前元组能够加入分组
                    if(putinChoosens(sensitiveAttrs, choosenAttrs)) {
                        group.add(originAdult4D);
                        //删除当前元组
                        originAdult4DIterator.remove();
                        //当前分组已满,达到分组要求
                        if(group.isFull()) {
                            //保存分组
                            //int result = adult2DGroupService.insertByBatch(group);
                            //addTuplesToLastList(hasInGroupTuples,group);
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
                originAdult4DS.clear();
                hasInGroupTuples.clear();
                surplusTuples.clear();
                group.reset();
                choosenAttrs.clear();
                //复制，once again！
                originAdult4DS = cloneTuples(cloneOriginTuple);
            }
        }

        int avgTime = getavgTime(timeList);
        System.out.println("算法平均执行时间: " + avgTime);
        if(hasInGroupTuples.size() > 0) {
            adult4DGroupService.insertByBatch(hasInGroupTuples);
        }

        return surplusTuples;
    }

    /**
     * 五维
     * @param originAdult5DS
     * @param context
     * @return
     * @throws Exception
     */
    public List<OriginAdult5D> commonBG5D(List<OriginAdult5D> originAdult5DS, ApplicationContext context) throws Exception {

        Adult5DGroupService adult5DGroupService = SpringUtil.getBean(context, Adult5DGroupService.class);

        //深克隆的元组，方便多次分组算法，重复计算，计平均值
        List<OriginAdult5D> cloneOriginTuple = cloneTuples(originAdult5DS);

        //记录每次算法的时间
        List<Long> timeList = Lists.newArrayList();

        //创建分组，保存每次得到的分组结果
        Group<OriginAdult5D> group = new Group<OriginAdult5D>(L_PARAM);

        //已经分好组的元组，最后插入数据库
        List<Adult5DGroup> hasInGroupTuples = Lists.newArrayList();

        //无法分组的剩余元组
        List<OriginAdult5D> surplusTuples = Lists.newArrayList();

        //每次分组中，已加入分组中的隐私属性
        Set<String> choosenAttrs = new HashSet<>();

        //计时开始
        for(int i = 1; i <= 10; i++) {
            TimeKeepUtil.startTheTime();
            while(!originAdult5DS.isEmpty()) {
                Iterator<OriginAdult5D> originAdult5DIterator = originAdult5DS.iterator();
                while(originAdult5DIterator.hasNext()) {
                    OriginAdult5D originAdult5D = originAdult5DIterator.next();
                    List<String> sensitiveAttrs = originAdult5D.getSensitiveAttrs();

                    //当前元组能够加入分组
                    if(putinChoosens(sensitiveAttrs, choosenAttrs)) {
                        group.add(originAdult5D);
                        //删除当前元组
                        originAdult5DIterator.remove();
                        //当前分组已满,达到分组要求
                        if(group.isFull()) {
                            //保存分组
                            //int result = adult2DGroupService.insertByBatch(group);
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
                originAdult5DS.clear();
                hasInGroupTuples.clear();
                surplusTuples.clear();
                group.reset();
                choosenAttrs.clear();
                //复制，once again！
                originAdult5DS = cloneTuples(cloneOriginTuple);
            }
        }

        int avgTime = getavgTime(timeList);
        System.out.println("算法平均执行时间: " + avgTime);
        if(!hasInGroupTuples.isEmpty()) {
            adult5DGroupService.insertByBatch(hasInGroupTuples);
        }

        return surplusTuples;
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
            cloneList.add((T)BeanUtils.cloneBean(t));
        }
        return cloneList;
    }

    /**
     * 二维
     * @param hasInGroupTuples
     * @param group
     */
    //private void addTuplesToLastList(List<Adult2DGroup> hasInGroupTuples, Group<OriginAdult2D> group) {
    //    List<OriginAdult2D> originAdult2DS = group.getGroupContainer();
    //    for(OriginAdult2D originAdult2D : originAdult2DS) {
    //        Adult2DGroup adult2DGroup = new Adult2DGroup();
    //        adult2DGroup.setTupleId(originAdult2D.getId());
    //        adult2DGroup.setGroupId(group.getGroupId());
    //        adult2DGroup.setAge(originAdult2D.getAge());
    //        adult2DGroup.setSex(originAdult2D.getSex());
    //        adult2DGroup.setEducation(originAdult2D.getEducation());
    //        adult2DGroup.setNativeCountry(originAdult2D.getNativeCountry());
    //        adult2DGroup.setOccupation(originAdult2D.getOccupation());
    //        hasInGroupTuples.add(adult2DGroup);
    //    }
    //}

    /**
     * 三维
     * @param hasInGroupTuples
     * @param group
     */
    //private void addTuplesToLastList(List<Adult3DGroup> hasInGroupTuples, Group<OriginAdult3D> group) {
    //    List<OriginAdult3D> originAdult3DS = group.getGroupContainer();
    //    for(OriginAdult3D originAdult3D : originAdult3DS) {
    //        Adult3DGroup adult3DGroup = new Adult3DGroup();
    //        adult3DGroup.setTupleId(originAdult3D.getId());
    //        adult3DGroup.setGroupId(group.getGroupId());
    //        adult3DGroup.setAge(originAdult3D.getAge());
    //        adult3DGroup.setSex(originAdult3D.getSex());
    //        adult3DGroup.setEducation(originAdult3D.getEducation());
    //        adult3DGroup.setNativeCountry(originAdult3D.getNativeCountry());
    //        adult3DGroup.setOccupation(originAdult3D.getOccupation());
    //        adult3DGroup.setMaritalStatus(originAdult3D.getMaritalStatus());
    //        hasInGroupTuples.add(adult3DGroup);
    //    }
    //}

    /**
     * 四维
     * @param hasInGroupTuples
     * @param group
     */
    //private void addTuplesToLastList(List<Adult4DGroup> hasInGroupTuples, Group<OriginAdult4D> group) {
    //    List<OriginAdult4D> originAdult4DS = group.getGroupContainer();
    //    for(OriginAdult4D originAdult4D : originAdult4DS) {
    //        Adult4DGroup adult4DGroup = new Adult4DGroup();
    //        adult4DGroup.setTupleId(originAdult4D.getId());
    //        adult4DGroup.setGroupId(group.getGroupId());
    //        adult4DGroup.setAge(originAdult4D.getAge());
    //        adult4DGroup.setSex(originAdult4D.getSex());
    //        adult4DGroup.setEducation(originAdult4D.getEducation());
    //        adult4DGroup.setNativeCountry(originAdult4D.getNativeCountry());
    //        adult4DGroup.setOccupation(originAdult4D.getOccupation());
    //        adult4DGroup.setMaritalStatus(originAdult4D.getMaritalStatus());
    //        adult4DGroup.setWorkclass(originAdult4D.getWorkclass());
    //        hasInGroupTuples.add(adult4DGroup);
    //    }
    //}

    /**
     * 五维
     * @param hasInGroupTuples
     * @param group
     */
    private void addTuplesToLastList(List<Adult5DGroup> hasInGroupTuples, Group<OriginAdult5D> group) {
        List<OriginAdult5D> originAdult5DS = group.getGroupContainer();
        for(OriginAdult5D originAdult5D : originAdult5DS) {
            Adult5DGroup adult5DGroup = new Adult5DGroup();
            adult5DGroup.setTupleId(originAdult5D.getId());
            adult5DGroup.setGroupId(group.getGroupId());
            adult5DGroup.setAge(originAdult5D.getAge());
            adult5DGroup.setSex(originAdult5D.getSex());
            adult5DGroup.setEducation(originAdult5D.getEducation());
            adult5DGroup.setNativeCountry(originAdult5D.getNativeCountry());
            adult5DGroup.setOccupation(originAdult5D.getOccupation());
            adult5DGroup.setMaritalStatus(originAdult5D.getMaritalStatus());
            adult5DGroup.setWorkclass(originAdult5D.getWorkclass());
            adult5DGroup.setRace(originAdult5D.getRace());
            hasInGroupTuples.add(adult5DGroup);
        }
    }

    /**
     * （元组的隐私属性是否可在图中选取）元组的是否可被选取加入当前组
     * @param attrs 当前元组的所有隐私属性
     * @param choosenAttrs 当前分组中已有的隐私属性
     * @return true 可以选取该元组到当前组
     *          false 不能选取当前元组到当前组，违背l-diversity原则
     */
    private boolean putinChoosens(List<String> attrs, Set<String> choosenAttrs) {
        boolean result = true;

        //记录已经插入choosensAttrs的属性，一旦插入失败，需要将已经该元组插入的属性全部移除
        List<String> hasAddIn = new ArrayList<String>();

        for(String attr : attrs) {
            if(!choosenAttrs.add(attr)) { //插入失败
                choosenAttrs.removeAll(hasAddIn);
                result =  Boolean.FALSE;
                break;
            }
            hasAddIn.add(attr);
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

    public static void main(String[] args) throws Exception {
        OriginAdult2D originAdult2D = new OriginAdult2D.Builder().age(21).sex("nan").build();
        List<OriginAdult2D> sourceList = Lists.newArrayList();
        sourceList.add(originAdult2D);
        //List<OriginAdult2D> cloneList = cloneTuples(sourceList);
        //System.out.println(sourceList.get(0) == cloneList.get(0));
        //
        //originAdult2D.setAge(22);
        //System.out.println(sourceList.get(0).getAge());
        //System.out.println(cloneList.get(0).getAge());
    }


}