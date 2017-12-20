package dataProcess.model.modelMapper;

import dataProcess.model.Adult5DGroup;

import java.util.List;

public interface Adult5DGroupMapper {
    int insert(Adult5DGroup record);

    int insertSelective(Adult5DGroup record);

    int insertByBatch(List<Adult5DGroup> records);

}
