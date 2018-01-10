/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package dataProcess.service.impl;

import dataProcess.model.WeightOriginAdult5D;
import dataProcess.model.modelMapper.WeightOriginAdult5DMapper;
import dataProcess.service.WeightOriginAdult5DService;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: WeightOriginAdult5DServiceImpl.java, v 0.1 2018年01月09日 14:59 Gonjan Exp $
 */
public class WeightOriginAdult5DServiceImpl implements WeightOriginAdult5DService {

    private WeightOriginAdult5DMapper weightOriginAdult5DMapper;

    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    public int insert(WeightOriginAdult5D record) {
        return 0;
    }

    public int insertSelective(WeightOriginAdult5D record) {
        return 0;
    }

    public WeightOriginAdult5D selectByPrimaryKey(Integer id) {
        return null;
    }

    public int updateByPrimaryKeySelective(WeightOriginAdult5D record) {
        return 0;
    }

    public int updateByPrimaryKey(WeightOriginAdult5D record) {
        return 0;
    }

    public int insertByBatch(List<WeightOriginAdult5D> records) {
        return weightOriginAdult5DMapper.insertByBatch(records);
    }

    public void setWeightOriginAdult5DMapper(WeightOriginAdult5DMapper weightOriginAdult5DMapper) {
        this.weightOriginAdult5DMapper = weightOriginAdult5DMapper;
    }
}