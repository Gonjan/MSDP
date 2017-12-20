/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package dataProcess.service.impl;

import dataProcess.model.OriginAdult2D;
import dataProcess.model.modelMapper.OriginAdult2DMapper;
import dataProcess.service.OriginAdult2DService;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: OriginAdult2DServiceImpl.java, v 0.1 2017年11月29日 18:46 Gonjan Exp $
 */
public class OriginAdult2DServiceImpl implements OriginAdult2DService {

    private OriginAdult2DMapper originAdult2DMapper;

    public int insert(OriginAdult2D record) {
        return originAdult2DMapper.insert(record);
    }

    public int insertSelective(OriginAdult2D record) {
        return originAdult2DMapper.insertSelective(record);
    }

    public List<OriginAdult2D> selectAll() {
        return originAdult2DMapper.selectAll();
    }

    /**
     * 批量插入
     * @param records
     * @return
     */
    public int insertByBatch(List<OriginAdult2D> records) {
        return originAdult2DMapper.insertByBatch(records);
    }


    public void setOriginAdult2DMapper(OriginAdult2DMapper originAdult2DMapper) {
        this.originAdult2DMapper = originAdult2DMapper;
    }
}