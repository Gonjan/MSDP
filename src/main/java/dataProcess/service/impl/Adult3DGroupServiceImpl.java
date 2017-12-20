/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package dataProcess.service.impl;

import dataProcess.model.Adult3DGroup;
import dataProcess.model.modelMapper.Adult3DGroupMapper;
import dataProcess.service.Adult3DGroupService;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: Adult3DGroupServiceImpl.java, v 0.1 2017年12月05日 14:44 Gonjan Exp $
 */
public class Adult3DGroupServiceImpl implements Adult3DGroupService {

    private Adult3DGroupMapper adult3DGroupMapper;

    @Override
    public int insert(Adult3DGroup record) {
        return adult3DGroupMapper.insert(record);
    }

    @Override
    public int insertSelective(Adult3DGroup record) {
        return adult3DGroupMapper.insertSelective(record);
    }

    @Override
    public int insertByBatch(List<Adult3DGroup> records) {
        return adult3DGroupMapper.insertByBatch(records);
    }

    public void setAdult3DGroupMapper(Adult3DGroupMapper adult3DGroupMapper) {
        this.adult3DGroupMapper = adult3DGroupMapper;
    }
}