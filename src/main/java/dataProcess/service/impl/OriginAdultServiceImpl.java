/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package dataProcess.service.impl;

import dataProcess.model.OriginAdult;
import dataProcess.model.modelMapper.OriginAdultMapper;
import dataProcess.service.OriginAdultService;

/**
 *
 * @author Gonjan
 * @version $Id: OriginAdultServiceImpl.java, v 0.1 2017年11月23日 15:48 Gonjan Exp $
 */
public class OriginAdultServiceImpl implements OriginAdultService {

    private OriginAdultMapper originAdultMapper;

    public int insert(OriginAdult record) {
        return originAdultMapper.insert(record);
    }

    public int insertSelective(OriginAdult record) {
        int result = originAdultMapper.insertSelective(record);
        return result;
    }

    public OriginAdultMapper getOriginAdultMapper() {
        return originAdultMapper;
    }

    public void setOriginAdultMapper(OriginAdultMapper originAdultMapper) {
        this.originAdultMapper = originAdultMapper;
    }
}