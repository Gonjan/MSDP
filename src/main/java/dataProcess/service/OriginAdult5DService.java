/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package dataProcess.service;

import dataProcess.model.OriginAdult5D;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: OriginAdult5DService.java, v 0.1 2017年12月08日 14:10 Gonjan Exp $
 */
public interface OriginAdult5DService {
    int insert(OriginAdult5D record);

    int insertSelective(OriginAdult5D record);

    int insertByBatch(List<OriginAdult5D> records);


    List<OriginAdult5D> selectAll();
}