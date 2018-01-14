/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package dataProcess.service.weightProcess.impl;

import dataProcess.service.weightProcess.WeightContainer;
import dataProcess.service.weightProcess.WeightProcessService;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: WeightProcessServiceImpl.java, v 0.1 2018年01月10日 14:58 Gonjan Exp $
 */
public class WeightProcessServiceImpl implements WeightProcessService {

    private WeightContainer weightContainer;

    @Override
    public Double processWeight(List<String> sensitives) {
        if(CollectionUtils.isEmpty(sensitives)) {
            return null;
        }
        Double toupleWeight = new Double(0);
        //计算元组的权值，各属性值的累加
        Double valueFinalWeight = null;
        for(String value : sensitives) {
           valueFinalWeight = getValueFinanlWeight(value);
           if(valueFinalWeight == null) {
               System.err.println("获取单个属性值失败，属性值：" + value);
               return null;
           }
           toupleWeight += valueFinalWeight;
        }
        return toupleWeight;
    }

    private Double getValueFinanlWeight(String value) {
        Double valueFinalWeight = null;
        //获取属性值对应的权值
        Double valueWeight = weightContainer.getValueWeight(value);
        //获取属性值对应的属性的权值
        Double attrWeight = weightContainer.getAttrWeight(value);
        //计算属性值的最终权值
        if(valueWeight != null && attrWeight != null) {
            valueFinalWeight = valueWeight.doubleValue() * attrWeight.doubleValue();
        }
        return valueFinalWeight;
    }

    @Override
    public void setWeightContainer(WeightContainer weightContainer) {
        this.weightContainer = weightContainer;
    }
}