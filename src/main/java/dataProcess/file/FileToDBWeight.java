/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package dataProcess.file;

import com.google.common.collect.Lists;
import dataProcess.model.WeightOriginAdult2D;
import dataProcess.model.WeightOriginAdult3D;
import dataProcess.model.WeightOriginAdult3D.Builder;
import dataProcess.service.WeightOriginAdult2DService;
import dataProcess.service.WeightOriginAdult3DService;
import dataProcess.service.weightProcess.WeightContainer;
import dataProcess.service.weightProcess.WeightProcessService;
import org.springframework.context.ApplicationContext;
import util.FileHandler;
import util.SpringUtil;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: FileToDBWeight.java, v 0.1 2018年01月10日 14:05 Gonjan Exp $
 */
public class FileToDBWeight {

    public static boolean originDataToDbWeight(ApplicationContext context, String filePath) {
        List<String> lineList = FileHandler.readAllLines(filePath);

        //引入权值处理器服务
        WeightProcessService weightProcessService = SpringUtil.getBean(context,WeightProcessService.class);
        WeightContainer weightContainer = SpringUtil.getBean(context,WeightContainer.class);
        weightContainer.initWeightContainer();
        weightProcessService.setWeightContainer(weightContainer);


        //二维
        //WeightOriginAdult2D.Builder weightOriginAdult2DBuilder = new WeightOriginAdult2D.Builder();
        //WeightOriginAdult2DService weightOriginAdult2DService = SpringUtil.getBean(context,WeightOriginAdult2DService.class);
        //List<WeightOriginAdult2D> weightOriginAdult2DS = Lists.newArrayList();

        //三维
        WeightOriginAdult3D.Builder weightOriginAdult3DBuilder = new WeightOriginAdult3D.Builder();
        WeightOriginAdult3DService weightOriginAdult3DService = SpringUtil.getBean(context,WeightOriginAdult3DService.class);
        List<WeightOriginAdult3D> weightOriginAdult3DS = Lists.newArrayList();

        //读取每条记录并计算其权值存入数据库
        if(lineList != null) {
            for(String line : lineList) {
                String[] strs = line.split(",");

                //二维
                //WeightOriginAdult2D weightOriginAdult2D = weightOriginAdult2DBuilder.age(Integer.parseInt(strs[0])).sex(strs[1].trim()).nativeCountry(strs[2].trim())
                //        .occupation(strs[3].trim()).education(strs[4].trim()).build();

                //三维
                WeightOriginAdult3D weightOriginAdult3D = weightOriginAdult3DBuilder.age(Integer.parseInt(strs[0])).sex(strs[1].trim()).nativeCountry(strs[2].trim())
                        .occupation(strs[3].trim()).education(strs[4].trim()).maritalStatus(strs[5].trim()).build();

                //计算该条记录的权值
                //二维
                //Double tupleWeight = weightProcessService.processWeight(weightOriginAdult2D.getSensitiveAttrs());
                //三维
                Double tupleWeight = weightProcessService.processWeight(weightOriginAdult3D.getSensitiveAttrs());

                if(tupleWeight == null) {
                    System.err.println("记录权值处理权值出现错误:" + line);
                    System.exit(0);
                }
                //设置权值
                //二维
                //weightOriginAdult2D.setWeight(tupleWeight);
                //weightOriginAdult2DS.add(weightOriginAdult2D);
                //三维
                weightOriginAdult3D.setWeight(tupleWeight);
                weightOriginAdult3DS.add(weightOriginAdult3D);
            }
        }
        try{
            //二维
            //int result = weightOriginAdult2DService.insertByBatch(weightOriginAdult2DS);
            int result = weightOriginAdult3DService.insertByBatch(weightOriginAdult3DS);
            System.out.println("insert to db: " + result + "records");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }




    public static void main(String[] args) {
        ApplicationContext context = SpringUtil.initSpringContainer();
        String filePath1 = "F:\\PyCharmWorkSpace\\Test\\dataProcess\\test_result.txt";
        String surplusTuple = "E:\\论文\\论文实验\\data\\surplus_line.txt";
        String filePath = "E:\\论文\\论文实验\\data\\adult_result_1k.txt";
        originDataToDbWeight(context, filePath);
    }
}