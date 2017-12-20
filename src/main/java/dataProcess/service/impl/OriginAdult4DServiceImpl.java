/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package dataProcess.service.impl;

import dataProcess.model.OriginAdult4D;
import dataProcess.model.modelMapper.OriginAdult4DMapper;
import dataProcess.service.OriginAdult4DService;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: OriginAdult4DServiceImpl.java, v 0.1 2017年12月07日 19:56 Gonjan Exp $
 */
public class OriginAdult4DServiceImpl implements OriginAdult4DService {

    private OriginAdult4DMapper originAdult4DMapper;

    @Override
    public int insert(OriginAdult4D record) {
        return originAdult4DMapper.insert(record);
    }

    @Override
    public int insertSelective(OriginAdult4D record) {
        return originAdult4DMapper.insertSelective(record);
    }

    @Override
    public int insertByBatch(List<OriginAdult4D> records) {
        return originAdult4DMapper.insertByBatch(records);
    }

    @Override
    public List<OriginAdult4D> selectAll() {
        return originAdult4DMapper.selectAll() ;
    }

    public void setOriginAdult4DMapper(OriginAdult4DMapper originAdult4DMapper) {
        this.originAdult4DMapper = originAdult4DMapper;
    }
}