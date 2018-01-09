package dataProcess.model.modelMapper;

import dataProcess.model.WeightOriginAdult4D;

public interface WeightOriginAdult4DMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeightOriginAdult4D record);

    int insertSelective(WeightOriginAdult4D record);

    WeightOriginAdult4D selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeightOriginAdult4D record);

    int updateByPrimaryKey(WeightOriginAdult4D record);
}