/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package dataProcess.service;

import dataProcess.model.OriginAdult2D;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: OriginAdult2DService.java, v 0.1 2017年11月29日 18:46 Gonjan Exp $
 */
public interface OriginAdult2DService {

    int insert(OriginAdult2D record);

    int insertSelective(OriginAdult2D record);

    List<OriginAdult2D> selectAll();

    int insertByBatch(List<OriginAdult2D> records);

}