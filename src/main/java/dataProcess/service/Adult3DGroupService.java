/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package dataProcess.service;

import dataProcess.model.Adult3DGroup;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: Adult3DGroupService.java, v 0.1 2017年12月05日 14:31 Gonjan Exp $
 */
public interface Adult3DGroupService {
    int insert(Adult3DGroup record);

    int insertSelective(Adult3DGroup record);

    int insertByBatch(List<Adult3DGroup> records);
}