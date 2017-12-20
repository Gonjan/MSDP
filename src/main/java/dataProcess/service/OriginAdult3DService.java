/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package dataProcess.service;

import dataProcess.model.OriginAdult3D;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: OriginAdult3DService.java, v 0.1 2017年12月05日 14:33 Gonjan Exp $
 */
public interface OriginAdult3DService {

    int insert(OriginAdult3D record);

    int insertSelective(OriginAdult3D record);

    int insertByBatch(List<OriginAdult3D> records);


    List<OriginAdult3D> selectAll();
}