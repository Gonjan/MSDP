/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package dataProcess.service;

import dataProcess.model.Adult5DGroup;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: Adult5DGroupService.java, v 0.1 2017年12月08日 14:11 Gonjan Exp $
 */
public interface Adult5DGroupService {
    int insert(Adult5DGroup record);

    int insertSelective(Adult5DGroup record);

    int insertByBatch(List<Adult5DGroup> records);
}