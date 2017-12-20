/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package dataProcess.service;

import dataProcess.model.Adult4DGroup;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: Adult4DGroupService.java, v 0.1 2017年12月07日 19:57 Gonjan Exp $
 */
public interface Adult4DGroupService {
    int insert(Adult4DGroup record);

    int insertSelective(Adult4DGroup record);
    int insertByBatch(List<Adult4DGroup> records);
}