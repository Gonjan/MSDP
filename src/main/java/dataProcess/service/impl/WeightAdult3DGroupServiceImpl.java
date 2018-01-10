/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package dataProcess.service.impl;

import dataProcess.model.WeightAdult3DGroup;
import dataProcess.model.modelMapper.WeightAdult3DGroupMapper;
import dataProcess.service.WeightAdult3DGroupService;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: WeightAdult3DGroupServiceImpl.java, v 0.1 2018年01月09日 14:58 Gonjan Exp $
 */
public class WeightAdult3DGroupServiceImpl implements WeightAdult3DGroupService {

    private WeightAdult3DGroupMapper weightAdult3DGroupMapper;

    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    public int insert(WeightAdult3DGroup record) {
        return 0;
    }

    public int insertSelective(WeightAdult3DGroup record) {
        return 0;
    }

    public WeightAdult3DGroup selectByPrimaryKey(Integer id) {
        return null;
    }

    public int updateByPrimaryKeySelective(WeightAdult3DGroup record) {
        return 0;
    }

    public int updateByPrimaryKey(WeightAdult3DGroup record) {
        return 0;
    }

    public int insertByBatch(List<WeightAdult3DGroup> records) {
        return weightAdult3DGroupMapper.insertByBatch(records);
    }

    public void setWeightAdult3DGroupMapper(WeightAdult3DGroupMapper weightAdult3DGroupMapper) {
        this.weightAdult3DGroupMapper = weightAdult3DGroupMapper;
    }
}