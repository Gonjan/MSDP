/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package dataProcess.service;

import dataProcess.model.Adult2DGroup;
import dataProcess.model.OriginAdult2D;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: Adult2DGroupService.java, v 0.1 2017年11月29日 19:37 Gonjan Exp $
 */
public interface Adult2DGroupService {

    int insert(Adult2DGroup record);

    int insertSelective(Adult2DGroup record);

    //int insertByBatch(Group<OriginAdult2D> records);
    int insertByBatch(List<Adult2DGroup> records);
}