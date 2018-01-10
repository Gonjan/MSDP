/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package dataProcess.service.impl;

import dataProcess.model.WeightOriginAdult2D;
import dataProcess.model.modelMapper.WeightOriginAdult2DMapper;
import dataProcess.service.WeightOriginAdult2DService;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: WeightOriginAdult2DServiceImpl.java, v 0.1 2018年01月09日 14:58 Gonjan Exp $
 */
public class WeightOriginAdult2DServiceImpl implements WeightOriginAdult2DService {

    private WeightOriginAdult2DMapper weightOriginAdult2DMapper;

    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    public int insert(WeightOriginAdult2D record) {
        return 0;
    }

    public int insertSelective(WeightOriginAdult2D record) {
        return 0;
    }

    public WeightOriginAdult2D selectByPrimaryKey(Integer id) {
        return null;
    }

    public int updateByPrimaryKeySelective(WeightOriginAdult2D record) {
        return 0;
    }

    public int updateByPrimaryKey(WeightOriginAdult2D record) {
        return 0;
    }

    public int insertByBatch(List<WeightOriginAdult2D> records) {
        return weightOriginAdult2DMapper.insertByBatch(records);
    }

    public List<WeightOriginAdult2D> selectAll() {
        return weightOriginAdult2DMapper.selectAll();
    }

    public void setWeightOriginAdult2DMapper(WeightOriginAdult2DMapper weightOriginAdult2DMapper) {
        this.weightOriginAdult2DMapper = weightOriginAdult2DMapper;
    }
}