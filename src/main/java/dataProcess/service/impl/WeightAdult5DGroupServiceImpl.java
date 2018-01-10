/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package dataProcess.service.impl;

import dataProcess.model.WeightAdult5DGroup;
import dataProcess.model.modelMapper.WeightAdult5DGroupMapper;
import dataProcess.service.WeightAdult5DGroupService;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: WeightAdult5DGroupServiceImpl.java, v 0.1 2018年01月09日 14:58 Gonjan Exp $
 */
public class WeightAdult5DGroupServiceImpl implements WeightAdult5DGroupService {
    private WeightAdult5DGroupMapper weightAdult5DGroupMapper;

    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    public int insert(WeightAdult5DGroup record) {
        return 0;
    }

    public int insertSelective(WeightAdult5DGroup record) {
        return 0;
    }

    public WeightAdult5DGroup selectByPrimaryKey(Integer id) {
        return null;
    }

    public int updateByPrimaryKeySelective(WeightAdult5DGroup record) {
        return 0;
    }

    public int updateByPrimaryKey(WeightAdult5DGroup record) {
        return 0;
    }

    public int insertByBatch(List<WeightAdult5DGroup> records) {
        return weightAdult5DGroupMapper.insertByBatch(records);
    }

    public void setWeightAdult5DGroupMapper(WeightAdult5DGroupMapper weightAdult5DGroupMapper) {
        this.weightAdult5DGroupMapper = weightAdult5DGroupMapper;
    }
}