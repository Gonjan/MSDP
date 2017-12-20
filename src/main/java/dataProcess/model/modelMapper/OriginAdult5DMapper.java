package dataProcess.model.modelMapper;

import dataProcess.model.OriginAdult5D;

import java.util.List;

public interface OriginAdult5DMapper {
    int insert(OriginAdult5D record);

    int insertSelective(OriginAdult5D record);

    int insertByBatch(List<OriginAdult5D> records);


    List<OriginAdult5D> selectAll();
}