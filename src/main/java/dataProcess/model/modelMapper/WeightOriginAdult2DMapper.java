package dataProcess.model.modelMapper;

import dataProcess.model.WeightOriginAdult2D;

import java.util.List;

public interface WeightOriginAdult2DMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeightOriginAdult2D record);

    int insertSelective(WeightOriginAdult2D record);

    WeightOriginAdult2D selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeightOriginAdult2D record);

    int updateByPrimaryKey(WeightOriginAdult2D record);

    int insertByBatch(List<WeightOriginAdult2D> records);
}