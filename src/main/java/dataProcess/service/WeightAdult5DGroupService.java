/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package dataProcess.service;

import dataProcess.model.WeightAdult5DGroup;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: WeightAdult5DGroupService.java, v 0.1 2018年01月09日 14:52 Gonjan Exp $
 */
public interface WeightAdult5DGroupService {
    int deleteByPrimaryKey(Integer id);

    int insert(WeightAdult5DGroup record);

    int insertSelective(WeightAdult5DGroup record);

    WeightAdult5DGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeightAdult5DGroup record);

    int updateByPrimaryKey(WeightAdult5DGroup record);

    int insertByBatch(List<WeightAdult5DGroup> records);

}