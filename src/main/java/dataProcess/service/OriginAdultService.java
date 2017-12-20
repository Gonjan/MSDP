/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package dataProcess.service;

import com.google.common.collect.Lists;
import dataProcess.model.OriginAdult;
import dataProcess.model.OriginAdult2D;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: OriginAdultService.java, v 0.1 2017年11月23日 15:47 Gonjan Exp $
 */
public interface OriginAdultService {

    int insert(OriginAdult record);

    int insertSelective(OriginAdult record);

}