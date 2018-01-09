package dataProcess.model.modelMapper;

import dataProcess.model.WeightOriginAdult3D;

import java.util.List;

public interface WeightOriginAdult3DMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeightOriginAdult3D record);

    int insertSelective(WeightOriginAdult3D record);

    WeightOriginAdult3D selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeightOriginAdult3D record);

    int updateByPrimaryKey(WeightOriginAdult3D record);

    int insertByBatch(List<WeightOriginAdult3D> records);
}