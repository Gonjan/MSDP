package dataProcess.model.modelMapper;

import dataProcess.model.Adult3DGroup;

import java.util.List;

public interface Adult3DGroupMapper {
    int insert(Adult3DGroup record);

    int insertSelective(Adult3DGroup record);

    int insertByBatch(List<Adult3DGroup> records);

}