/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package dataProcess.service.impl;

import dataProcess.model.WeightOriginAdult3D;
import dataProcess.model.modelMapper.WeightOriginAdult3DMapper;
import dataProcess.service.WeightOriginAdult3DService;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: WeightOriginAdult3DServiceImpl.java, v 0.1 2018年01月09日 14:59 Gonjan Exp $
 */
public class WeightOriginAdult3DServiceImpl implements WeightOriginAdult3DService {

    private WeightOriginAdult3DMapper weightOriginAdult3DMapper;

    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    public int insert(WeightOriginAdult3D record) {
        return 0;
    }

    public int insertSelective(WeightOriginAdult3D record) {
        return 0;
    }

    public WeightOriginAdult3D selectByPrimaryKey(Integer id) {
        return null;
    }

    public int updateByPrimaryKeySelective(WeightOriginAdult3D record) {
        return 0;
    }

    public int updateByPrimaryKey(WeightOriginAdult3D record) {
        return 0;
    }

    public int insertByBatch(List<WeightOriginAdult3D> records) {
        return weightOriginAdult3DMapper.insertByBatch(records);
    }

    public List<WeightOriginAdult3D> selectAll() {
        return weightOriginAdult3DMapper.selectAll();
    }

    public void setWeightOriginAdult3DMapper(WeightOriginAdult3DMapper weightOriginAdult3DMapper) {
        this.weightOriginAdult3DMapper = weightOriginAdult3DMapper;
    }
}