package dataProcess.model.modelMapper;

import dataProcess.model.WeightOriginAdult5D;

import java.util.List;

public interface WeightOriginAdult5DMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeightOriginAdult5D record);

    int insertSelective(WeightOriginAdult5D record);

    WeightOriginAdult5D selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeightOriginAdult5D record);

    int updateByPrimaryKey(WeightOriginAdult5D record);

    int insertByBatch(List<WeightOriginAdult5D> records);

    List<WeightOriginAdult5D> selectAll();

}