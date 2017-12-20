package dataProcess.model.modelMapper;

import dataProcess.model.OriginAdult2D;

import java.util.List;

public interface OriginAdult2DMapper {
    int insert(OriginAdult2D record);

    int insertSelective(OriginAdult2D record);

    List<OriginAdult2D> selectAll();

    int insertByBatch(List<OriginAdult2D> records);

}