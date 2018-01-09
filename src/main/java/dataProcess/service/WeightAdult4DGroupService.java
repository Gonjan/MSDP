/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package dataProcess.service;

import dataProcess.model.WeightAdult4DGroup;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: WeightAdult4DGroupService.java, v 0.1 2018年01月09日 14:51 Gonjan Exp $
 */
public interface WeightAdult4DGroupService {
    int deleteByPrimaryKey(Integer id);

    int insert(WeightAdult4DGroup record);

    int insertSelective(WeightAdult4DGroup record);

    WeightAdult4DGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeightAdult4DGroup record);

    int updateByPrimaryKey(WeightAdult4DGroup record);

    int insertByBatch(List<WeightAdult4DGroup> records);
}