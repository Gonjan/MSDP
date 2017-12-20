/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package dataProcess.service.impl;

import dataProcess.model.Adult4DGroup;
import dataProcess.model.modelMapper.Adult4DGroupMapper;
import dataProcess.service.Adult4DGroupService;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: Adult4DGroupServiceImpl.java, v 0.1 2017年12月07日 19:57 Gonjan Exp $
 */
public class Adult4DGroupServiceImpl implements Adult4DGroupService {

    private Adult4DGroupMapper adult4DGroupMapper;

    @Override
    public int insert(Adult4DGroup record) {
        return adult4DGroupMapper.insert(record);
    }

    @Override
    public int insertSelective(Adult4DGroup record) {
        return adult4DGroupMapper.insertSelective(record);
    }

    @Override
    public int insertByBatch(List<Adult4DGroup> records) {
        return adult4DGroupMapper.insertByBatch(records);
    }

    public void setAdult4DGroupMapper(Adult4DGroupMapper adult4DGroupMapper) {
        this.adult4DGroupMapper = adult4DGroupMapper;
    }
}