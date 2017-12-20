package dataProcess.model.modelMapper;

import dataProcess.model.Adult2DGroup;

import java.util.List;

public interface Adult2DGroupMapper {
    int insert(Adult2DGroup record);

    int insertSelective(Adult2DGroup record);

    int insertByBatch(List<Adult2DGroup> records);

}