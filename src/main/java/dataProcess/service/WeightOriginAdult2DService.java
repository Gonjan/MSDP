/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package dataProcess.service;

import dataProcess.model.WeightOriginAdult2D;

/**
 *
 * @author Gonjan
 * @version $Id: WeightOriginAdult2DService.java, v 0.1 2018年01月09日 14:41 Gonjan Exp $
 */
public interface WeightOriginAdult2DService {
    int deleteByPrimaryKey(Integer id);

    int insert(WeightOriginAdult2D record);

    int insertSelective(WeightOriginAdult2D record);

    WeightOriginAdult2D selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeightOriginAdult2D record);

    int updateByPrimaryKey(WeightOriginAdult2D record);
}