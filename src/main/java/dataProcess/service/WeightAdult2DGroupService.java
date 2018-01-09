/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package dataProcess.service;

import dataProcess.model.WeightAdult2DGroup;

/**
 *
 * @author Gonjan
 * @version $Id: WeightAdult2DGroupService.java, v 0.1 2018年01月09日 14:51 Gonjan Exp $
 */
public interface WeightAdult2DGroupService {
    int deleteByPrimaryKey(Integer id);

    int insert(WeightAdult2DGroup record);

    int insertSelective(WeightAdult2DGroup record);

    WeightAdult2DGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeightAdult2DGroup record);

    int updateByPrimaryKey(WeightAdult2DGroup record);
}