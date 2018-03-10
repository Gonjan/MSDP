/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package mpdp;

import com.google.common.collect.Lists;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import dataProcess.file.WriteToFile;
import dataProcess.model.OriginAdult2D;
import dataProcess.model.OriginAdult3D;
import dataProcess.model.OriginAdult4D;
import dataProcess.model.OriginAdult5D;
import dataProcess.model.WeightOriginAdult2D;
import dataProcess.service.OriginAdult2DService;
import dataProcess.service.OriginAdult3DService;
import dataProcess.service.OriginAdult4DService;
import dataProcess.service.OriginAdult5DService;
import dataProcess.service.WeightOriginAdult2DService;
import dataProcess.service.weightProcess.WeightContainer;
import mpdp.algorithm.CommonBG;
import mpdp.algorithm.WeightBG;
import org.springframework.context.ApplicationContext;
import util.SpringUtil;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Gonjan
 * @version $Id: Mpdp.java, v 0.1 2017年11月24日 12:19 Gonjan Exp $
 */
public class Mpdp {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringUtil.initSpringContainer();
        WeightContainer weightContainer = SpringUtil.getBean(context,WeightContainer.class);
        weightContainer.initWeightContainer();
        System.out.println("hh");


        //CommonBG commonBG = new CommonBG();
        //得到所有待分组元素
        //OriginAdult2DService originAdult2DService = SpringUtil.getBean(context, OriginAdult2DService.class);
        //List<OriginAdult2D> originAdult2DList = originAdult2DService.selectAll();

        //OriginAdult3DService originAdult3DService = SpringUtil.getBean(context, OriginAdult3DService.class);
        //List<OriginAdult3D> originAdult3DList = originAdult3DService.selectAll();

        //OriginAdult4DService originAdult4DService = SpringUtil.getBean(context, OriginAdult4DService.class);
        //List<OriginAdult4D> originAdult4DList = originAdult4DService.selectAll();

        //OriginAdult5DService originAdult5DService = SpringUtil.getBean(context, OriginAdult5DService.class);
        //List<OriginAdult5D> originAdult5DList = originAdult5DService.selectAll();

        //2维分组
        //List<OriginAdult2D> restTuples =  commonBG.commonBG2D(originAdult2DList, context);
        //3维分组
        //List<OriginAdult3D> restTuples =  commonBG.commonBG3D(originAdult3DList, context);
        //四维分组
        //List<OriginAdult4D> restTuples = commonBG.commonBG4D(originAdult4DList, context);
        //五维分组
        //List<OriginAdult5D> restTuples = commonBG.commonBG5D(originAdult5DList, context);

        WeightBG weightBG = new WeightBG();

        WeightOriginAdult2DService weightOriginAdult2DService = SpringUtil.getBean(context,WeightOriginAdult2DService.class);
        List<WeightOriginAdult2D> weightOriginAdult2DS = weightOriginAdult2DService.selectAll();

        //带权二维分组
        List<WeightOriginAdult2D> restTuples = weightBG.weightBG2D(weightOriginAdult2DS,context);


        System.out.println("剩余元组" + restTuples.size());
        //for(OriginAdult2D originAdult2D : restTuples) {
        //    System.out.println(originAdult2D.toString());
        //}

        //System.out.println("剩余元组写入文件:"  );
        //
        //List<String> surplusTuple = restTuples.stream()
        //                            .map(param -> param.toStringWithoutId())
        //                            .collect(Collectors.toList());
        //String fileName = "E:\\论文\\论文实验\\data\\surplus_line.txt";
        //WriteToFile.writeListToFile(surplusTuple, fileName);


    }

}
