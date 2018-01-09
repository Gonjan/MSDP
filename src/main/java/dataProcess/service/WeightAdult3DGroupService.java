/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package dataProcess.service;

import dataProcess.model.WeightAdult3DGroup;

/**
 *
 * @author Gonjan
 * @version $Id: WeightAdult3DGroupService.java, v 0.1 2018年01月09日 14:51 Gonjan Exp $
 */
public interface WeightAdult3DGroupService {
    int deleteByPrimaryKey(Integer id);

    int insert(WeightAdult3DGroup record);

    int insertSelective(WeightAdult3DGroup record);

    WeightAdult3DGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeightAdult3DGroup record);

    int updateByPrimaryKey(WeightAdult3DGroup record);
}