package dataProcess.model.modelMapper;

import dataProcess.model.WeightAdult2DGroup;

public interface WeightAdult2DGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeightAdult2DGroup record);

    int insertSelective(WeightAdult2DGroup record);

    WeightAdult2DGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeightAdult2DGroup record);

    int updateByPrimaryKey(WeightAdult2DGroup record);
}