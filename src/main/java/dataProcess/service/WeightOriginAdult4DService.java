/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package dataProcess.service;

import dataProcess.model.WeightOriginAdult4D;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: WeightOriginAdult4DService.java, v 0.1 2018年01月09日 14:42 Gonjan Exp $
 */
public interface WeightOriginAdult4DService {
    int deleteByPrimaryKey(Integer id);

    int insert(WeightOriginAdult4D record);

    int insertSelective(WeightOriginAdult4D record);

    WeightOriginAdult4D selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeightOriginAdult4D record);

    int updateByPrimaryKey(WeightOriginAdult4D record);

    int insertByBatch(List<WeightOriginAdult4D> records);

    List<WeightOriginAdult4D> selectAll();

}