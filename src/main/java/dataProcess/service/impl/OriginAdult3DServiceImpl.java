/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package dataProcess.service.impl;

import dataProcess.model.OriginAdult3D;
import dataProcess.model.modelMapper.OriginAdult3DMapper;
import dataProcess.service.OriginAdult3DService;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: OriginAdult3DServiceImpl.java, v 0.1 2017年12月05日 14:45 Gonjan Exp $
 */
public class OriginAdult3DServiceImpl implements OriginAdult3DService {

   private OriginAdult3DMapper originAdult3DMapper;

    @Override
    public int insert(OriginAdult3D record) {
        return originAdult3DMapper.insert(record);
    }

    @Override
    public int insertSelective(OriginAdult3D record) {
        return originAdult3DMapper.insertSelective(record);
    }

    @Override
    public int insertByBatch(List<OriginAdult3D> records) {
        return originAdult3DMapper.insertByBatch(records);
    }

    @Override
    public List<OriginAdult3D> selectAll() {
        return originAdult3DMapper.selectAll();
    }


    public void setOriginAdult3DMapper(OriginAdult3DMapper originAdult3DMapper) {
        this.originAdult3DMapper = originAdult3DMapper;
    }
}