/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package dataProcess.service;

import dataProcess.model.WeightOriginAdult3D;

/**
 *
 * @author Gonjan
 * @version $Id: WeightOriginAdult3DService.java, v 0.1 2018年01月09日 14:41 Gonjan Exp $
 */
public interface WeightOriginAdult3DService {
    int deleteByPrimaryKey(Integer id);

    int insert(WeightOriginAdult3D record);

    int insertSelective(WeightOriginAdult3D record);

    WeightOriginAdult3D selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeightOriginAdult3D record);

    int updateByPrimaryKey(WeightOriginAdult3D record);
}