/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package dataProcess.service.impl;

import com.google.common.collect.Lists;
import dataProcess.model.Adult2DGroup;
import dataProcess.model.OriginAdult2D;
import dataProcess.model.modelMapper.Adult2DGroupMapper;
import dataProcess.service.Adult2DGroupService;
import mpdp.base.Group;

import java.util.List;

/**
 *
 * @author Gonjan
 * @version $Id: Adult2DGroupServiceImpl.java, v 0.1 2017年11月29日 19:38 Gonjan Exp $
 */
public class Adult2DGroupServiceImpl implements Adult2DGroupService {

    private Adult2DGroupMapper adult2DGroupMapper;

    @Override
    public int insert(Adult2DGroup record) {
        return adult2DGroupMapper.insert(record);
    }

    @Override
    public int insertSelective(Adult2DGroup record) {
        return adult2DGroupMapper.insertSelective(record);
    }

    /**
     * 分组批量插入
     * @param records
     * @return
     */
    //public int insertByBatch(Group<OriginAdult2D> records) {
    //    List<Adult2DGroup> adult2DGroups = convert(records);
    //    return adult2DGroupMapper.insertByBatch(adult2DGroups);
    //}
    public int insertByBatch(List<Adult2DGroup> records) {
        return adult2DGroupMapper.insertByBatch(records);
    }

    public void setAdult2DGroupMapper(Adult2DGroupMapper adult2DGroupMapper) {
        this.adult2DGroupMapper = adult2DGroupMapper;
    }

    private List<Adult2DGroup> convert(Group<OriginAdult2D> originAdult2DGroup) {
        List<Adult2DGroup> adult2DGroups = Lists.newArrayList();
        List<OriginAdult2D> originAdult2DS = originAdult2DGroup.getGroupContainer();
        for(OriginAdult2D originAdult2D : originAdult2DS) {
            Adult2DGroup adult2DGroup = new Adult2DGroup();
            adult2DGroup.setTupleId(originAdult2D.getId());
            adult2DGroup.setGroupId(originAdult2DGroup.getGroupId());
            adult2DGroup.setAge(originAdult2D.getAge());
            adult2DGroup.setSex(originAdult2D.getSex());
            adult2DGroup.setEducation(originAdult2D.getEducation());
            adult2DGroup.setNativeCountry(originAdult2D.getNativeCountry());
            adult2DGroup.setOccupation(originAdult2D.getOccupation());
            adult2DGroups.add(adult2DGroup);
        }
        return adult2DGroups;
    }
}