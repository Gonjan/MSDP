/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package dataProcess.service;

import dataProcess.model.OriginAdult4D;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: OriginAdult4DService.java, v 0.1 2017年12月07日 19:56 Gonjan Exp $
 */
public interface OriginAdult4DService {
    int insert(OriginAdult4D record);

    int insertSelective(OriginAdult4D record);
    int insertByBatch(List<OriginAdult4D> records);


    List<OriginAdult4D> selectAll();

}