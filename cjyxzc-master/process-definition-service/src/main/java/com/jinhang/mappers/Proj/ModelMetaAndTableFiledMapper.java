package com.jinhang.mappers.Proj;

import com.jinhang.process.DTO.RelMetaAndTableFiledDTO;
import com.jinhang.process.model.ModelMetaAndTableFiled;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModelMetaAndTableFiledMapper {
    public List<ModelMetaAndTableFiled> findAll();
    public List<ModelMetaAndTableFiled> findAllByMapId(@Param("map_id") String map_id );
    public List<RelMetaAndTableFiledDTO> findDtoByMapId(@Param("map_id") String map_id );
    public void deleteById(String id );
    public void addMetaAndTableFileds( List<ModelMetaAndTableFiled> metaAndTableFiled );
}
