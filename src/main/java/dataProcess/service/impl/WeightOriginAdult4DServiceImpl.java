/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package dataProcess.service.impl;

import dataProcess.model.WeightOriginAdult4D;
import dataProcess.model.modelMapper.WeightAdult4DGroupMapper;
import dataProcess.model.modelMapper.WeightOriginAdult4DMapper;
import dataProcess.service.WeightOriginAdult4DService;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: WeightOriginAdult4DServiceImpl.java, v 0.1 2018年01月09日 14:59 Gonjan Exp $
 */
public class WeightOriginAdult4DServiceImpl implements WeightOriginAdult4DService {

    private WeightOriginAdult4DMapper weightOriginAdult4DMapper;

    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    public int insert(WeightOriginAdult4D record) {
        return 0;
    }

    public int insertSelective(WeightOriginAdult4D record) {
        return 0;
    }

    public WeightOriginAdult4D selectByPrimaryKey(Integer id) {
        return null;
    }

    public int updateByPrimaryKeySelective(WeightOriginAdult4D record) {
        return 0;
    }

    public int updateByPrimaryKey(WeightOriginAdult4D record) {
        return 0;
    }

    public int insertByBatch(List<WeightOriginAdult4D> records) {
        return weightOriginAdult4DMapper.insertByBatch(records);
    }

    public void setWeightOriginAdult4DMapper(WeightOriginAdult4DMapper weightOriginAdult4DMapper) {
        this.weightOriginAdult4DMapper = weightOriginAdult4DMapper;
    }
}