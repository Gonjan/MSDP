package dataProcess.model.modelMapper;

import dataProcess.model.WeightAdult5DGroup;

import java.util.List;

public interface WeightAdult5DGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeightAdult5DGroup record);

    int insertSelective(WeightAdult5DGroup record);

    WeightAdult5DGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeightAdult5DGroup record);

    int updateByPrimaryKey(WeightAdult5DGroup record);

    int insertByBatch(List<WeightAdult5DGroup> records);

}