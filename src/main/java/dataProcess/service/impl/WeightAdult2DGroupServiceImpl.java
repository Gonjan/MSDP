/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package dataProcess.service.impl;

import dataProcess.model.WeightAdult2DGroup;
import dataProcess.model.modelMapper.WeightAdult2DGroupMapper;
import dataProcess.service.WeightAdult2DGroupService;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: WeightAdult2DGroupServiceImpl.java, v 0.1 2018年01月09日 14:57 Gonjan Exp $
 */
public class WeightAdult2DGroupServiceImpl implements WeightAdult2DGroupService {

    private WeightAdult2DGroupMapper weightAdult2DGroupMapper;



    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    public int insert(WeightAdult2DGroup record) {
        return weightAdult2DGroupMapper.insert(record);
    }

    public int insertSelective(WeightAdult2DGroup record) {
        return 0;
    }

    public WeightAdult2DGroup selectByPrimaryKey(Integer id) {
        return null;
    }

    public int updateByPrimaryKeySelective(WeightAdult2DGroup record) {
        return 0;
    }

    public int updateByPrimaryKey(WeightAdult2DGroup record) {
        return 0;
    }

    public int insertByBatch(List<WeightAdult2DGroup> records) {
        return weightAdult2DGroupMapper.insertByBatch(records);
    }

    public void setWeightAdult2DGroupMapper(WeightAdult2DGroupMapper weightAdult2DGroupMapper) {
        this.weightAdult2DGroupMapper = weightAdult2DGroupMapper;
    }
}