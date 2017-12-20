/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package dataProcess.service.impl;

import dataProcess.model.Adult5DGroup;
import dataProcess.model.modelMapper.Adult5DGroupMapper;
import dataProcess.service.Adult5DGroupService;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: Adult5DGroupServiceImpl.java, v 0.1 2017年12月08日 14:15 Gonjan Exp $
 */
public class Adult5DGroupServiceImpl implements Adult5DGroupService {

    private Adult5DGroupMapper adult5DGroupMapper;

    @Override
    public int insert(Adult5DGroup record) {
        return adult5DGroupMapper.insert(record);
    }

    @Override
    public int insertSelective(Adult5DGroup record) {
        return adult5DGroupMapper.insertSelective(record);
    }

    @Override
    public int insertByBatch(List<Adult5DGroup> records) {
        return adult5DGroupMapper.insertByBatch(records);
    }

    public void setAdult5DGroupMapper(Adult5DGroupMapper adult5DGroupMapper) {
        this.adult5DGroupMapper = adult5DGroupMapper;
    }
}