package dataProcess.model.modelMapper;

import dataProcess.model.Adult4DGroup;

import java.util.List;

public interface Adult4DGroupMapper {
    int insert(Adult4DGroup record);

    int insertSelective(Adult4DGroup record);
    int insertByBatch(List<Adult4DGroup> records);

}