package dataProcess.model.modelMapper;

import dataProcess.model.OriginAdult3D;

import java.util.List;

public interface OriginAdult3DMapper {
    int insert(OriginAdult3D record);

    int insertSelective(OriginAdult3D record);

    int insertByBatch(List<OriginAdult3D> records);


    List<OriginAdult3D> selectAll();
}