package dataProcess.model.modelMapper;

import dataProcess.model.WeightAdult3DGroup;

public interface WeightAdult3DGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeightAdult3DGroup record);

    int insertSelective(WeightAdult3DGroup record);

    WeightAdult3DGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeightAdult3DGroup record);

    int updateByPrimaryKey(WeightAdult3DGroup record);
}