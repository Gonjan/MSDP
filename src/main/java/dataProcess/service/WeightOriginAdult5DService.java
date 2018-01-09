/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package dataProcess.service;

import dataProcess.model.WeightOriginAdult5D;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: WeightOriginAdult5DService.java, v 0.1 2018年01月09日 14:42 Gonjan Exp $
 */
public interface WeightOriginAdult5DService {
    int deleteByPrimaryKey(Integer id);

    int insert(WeightOriginAdult5D record);

    int insertSelective(WeightOriginAdult5D record);

    WeightOriginAdult5D selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeightOriginAdult5D record);

    int updateByPrimaryKey(WeightOriginAdult5D record);

    int insertByBatch(List<WeightOriginAdult5D> records);
}