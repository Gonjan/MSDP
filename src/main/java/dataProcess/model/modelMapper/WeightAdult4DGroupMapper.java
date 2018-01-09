package dataProcess.model.modelMapper;

import dataProcess.model.WeightAdult4DGroup;

public interface WeightAdult4DGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeightAdult4DGroup record);

    int insertSelective(WeightAdult4DGroup record);

    WeightAdult4DGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeightAdult4DGroup record);

    int updateByPrimaryKey(WeightAdult4DGroup record);
}