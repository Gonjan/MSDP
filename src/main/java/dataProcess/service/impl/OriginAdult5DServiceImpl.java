/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package dataProcess.service.impl;

import dataProcess.model.OriginAdult5D;
import dataProcess.model.modelMapper.OriginAdult5DMapper;
import dataProcess.service.OriginAdult5DService;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: OriginAdult5DServiceImpl.java, v 0.1 2017年12月08日 14:11 Gonjan Exp $
 */
public class OriginAdult5DServiceImpl implements OriginAdult5DService {

    private OriginAdult5DMapper originAdult5DMapper;

    @Override
    public int insert(OriginAdult5D record) {
        return originAdult5DMapper.insert(record);
    }

    @Override
    public int insertSelective(OriginAdult5D record) {
        return originAdult5DMapper.insertSelective(record);
    }

    @Override
    public int insertByBatch(List<OriginAdult5D> records) {
        return originAdult5DMapper.insertByBatch(records);
    }

    @Override
    public List<OriginAdult5D> selectAll() {
        return originAdult5DMapper.selectAll();
    }

    public void setOriginAdult5DMapper(OriginAdult5DMapper originAdult5DMapper) {
        this.originAdult5DMapper = originAdult5DMapper;
    }
}