/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package dataProcess.service.impl;

import dataProcess.model.WeightAdult4DGroup;
import dataProcess.model.modelMapper.WeightAdult4DGroupMapper;
import dataProcess.service.WeightAdult4DGroupService;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: WeightAdult4DGroupServiceImpl.java, v 0.1 2018年01月09日 14:58 Gonjan Exp $
 */
public class WeightAdult4DGroupServiceImpl implements WeightAdult4DGroupService {
    private WeightAdult4DGroupMapper weightAdult4DGroupMapper;

    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    public int insert(WeightAdult4DGroup record) {
        return 0;
    }

    public int insertSelective(WeightAdult4DGroup record) {
        return 0;
    }

    public WeightAdult4DGroup selectByPrimaryKey(Integer id) {
        return null;
    }

    public int updateByPrimaryKeySelective(WeightAdult4DGroup record) {
        return 0;
    }

    public int updateByPrimaryKey(WeightAdult4DGroup record) {
        return 0;
    }

    public int insertByBatch(List<WeightAdult4DGroup> records) {
        return weightAdult4DGroupMapper.insertByBatch(records);
    }

    public void setWeightAdult4DGroupMapper(WeightAdult4DGroupMapper weightAdult4DGroupMapper) {
        this.weightAdult4DGroupMapper = weightAdult4DGroupMapper;
    }
}