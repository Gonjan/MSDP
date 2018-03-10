/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package dataProcess.file;

import com.google.common.collect.Lists;
import dataProcess.model.OriginAdult2D;
import dataProcess.model.OriginAdult3D;
import dataProcess.model.OriginAdult4D;
import dataProcess.model.OriginAdult5D;
import dataProcess.service.OriginAdult2DService;
import dataProcess.service.OriginAdult3DService;
import dataProcess.service.OriginAdult4DService;
import dataProcess.service.OriginAdult5DService;
import org.springframework.context.ApplicationContext;
import util.FileHandler;
import util.SpringUtil;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: FileToDB.java, v 0.1 2017年11月25日 11:26 Gonjan Exp $
 */
public class FileToDB {

    /**
     *目前是二维的数据处理写入
     * @param filePath
     * @return
     */
    public static boolean originDataToDb(ApplicationContext context, String filePath) {
        List<String> lineList = FileHandler.readAllLines(filePath);

        //二维
        OriginAdult2D.Builder originAdult2DBuilder = new OriginAdult2D.Builder();
        OriginAdult2DService originAdult2DService = SpringUtil.getBean(context,OriginAdult2DService.class);
        List<OriginAdult2D> originAdult2DS = Lists.newArrayList();

        //三维
        OriginAdult3D.Builder originAdult3dBuilder = new OriginAdult3D.Builder();
        OriginAdult3DService originAdult3DService = SpringUtil.getBean(context, OriginAdult3DService.class);
        List<OriginAdult3D> originAdult3DS = Lists.newArrayList();

        //四维
        OriginAdult4D.Builder originAdult4DBuilder = new OriginAdult4D.Builder();
        OriginAdult4DService originAdult4DService = SpringUtil.getBean(context, OriginAdult4DService.class);
        List<OriginAdult4D> originAdult4DS = Lists.newArrayList();

        //五维
        OriginAdult5D.Builder originAdult5DBuilder = new OriginAdult5D.Builder();
        OriginAdult5DService originAdult5DService = SpringUtil.getBean(context, OriginAdult5DService.class);
        List<OriginAdult5D> originAdult5DS = Lists.newArrayList();



        if(lineList != null) {
            for(String line : lineList) {
                String[] strs = line.split(",");

                //OriginAdult originAdult1 = originBuilder.age(Integer.parseInt(strs[0])).sex(strs[1]).nativeCountry(strs[2])
                //                                  .occupation(strs[3]).education(strs[4]).maritalStatus(strs[5])
                //                                  .workclass(strs[6]).race(strs[7]).build();
                //二维
                //OriginAdult2D originAdult2D1 = originAdult2DBuilder.age(Integer.parseInt(strs[0])).sex(strs[1].trim()).nativeCountry(strs[2].trim())
                //        .occupation(strs[3].trim()).education(strs[4].trim()).build();
                //originAdult2DS.add(originAdult2D1);
                //三维
                //OriginAdult3D originAdult3D = originAdult3dBuilder.age(Integer.parseInt(strs[0])).sex(strs[1].trim()).nativeCountry(strs[2].trim())
                //        .occupation(strs[3].trim()).education(strs[4].trim()).maritalStatus(strs[5].trim()).build();
                //originAdult3DS.add(originAdult3D);
                //四维
                //OriginAdult4D originAdult4D = originAdult4DBuilder.age(Integer.parseInt(strs[0])).sex(strs[1].trim()).nativeCountry(strs[2].trim())
                //        .occupation(strs[3].trim()).education(strs[4].trim()).maritalStatus(strs[5].trim()).workclass(strs[6].trim()).build();
                //originAdult4DS.add(originAdult4D);
                //五维
                OriginAdult5D originAdult5D = originAdult5DBuilder.age(Integer.parseInt(strs[0])).sex(strs[1].trim()).nativeCountry(strs[2].trim())
                        .occupation(strs[3].trim()).education(strs[4].trim()).maritalStatus(strs[5].trim()).workclass(strs[6].trim()).race(strs[7].trim()).build();
                originAdult5DS.add(originAdult5D);
            }
        }
        try{
            //int result = originAdultService.insertSelective(originAdult1);
            //二维
            //int result = originAdult2DService.insertByBatch(originAdult2DS);
            //三维
            //int result = originAdult3DService.insertByBatch(originAdult3DS);
            //四维
            //int result = originAdult4DService.insertByBatch(originAdult4DS);
            //五维
            int result = originAdult5DService.insertByBatch(originAdult5DS);


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
        String filePath = "E:\\论文\\论文实验\\data\\adult_result_10k.txt";
        originDataToDb(context, filePath);
    }
}