/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package dataProcess.file;

import com.google.common.collect.Lists;
import dataProcess.model.OriginAdult3D;
import dataProcess.model.WeightOriginAdult2D;
import dataProcess.service.WeightOriginAdult2DService;
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

        //二维
        WeightOriginAdult2D.Builder weightOriginAdult2DBuilder = new WeightOriginAdult2D.Builder();
        WeightOriginAdult2DService weightOriginAdult2DService = SpringUtil.getBean(context,WeightOriginAdult2DService.class);
        List<WeightOriginAdult2D> weightOriginAdult2DS = Lists.newArrayList();




        if(lineList != null) {
            for(String line : lineList) {
                String[] strs = line.split(",");

                WeightOriginAdult2D weightOriginAdult2D = weightOriginAdult2DBuilder.age(Integer.parseInt(strs[0])).sex(strs[1].trim()).nativeCountry(strs[2].trim())
                        .occupation(strs[3].trim()).education(strs[4].trim()).build();



                weightOriginAdult2DS.add(weightOriginAdult2D);
            }
        }
        try{
            int result = weightOriginAdult2DService.insertByBatch(weightOriginAdult2DS);
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
        originDataToDbWeight(context, filePath);
    }
}