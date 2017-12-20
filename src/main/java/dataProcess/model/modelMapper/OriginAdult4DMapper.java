package dataProcess.model.modelMapper;

import dataProcess.model.OriginAdult4D;

import java.util.List;

public interface OriginAdult4DMapper {
    int insert(OriginAdult4D record);

    int insertSelective(OriginAdult4D record);
    int insertByBatch(List<OriginAdult4D> records);


    List<OriginAdult4D> selectAll();
}