package com.jinhang.dao;

import com.jinhang.mappers.Proj.ModelMetaAndTableFiledMapper;
import com.jinhang.process.DTO.RelMetaAndTableFiledDTO;
import com.jinhang.process.model.ModelMetaAndTableFiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ModelMetaAndTableFiledDao {
    @Autowired
    private ModelMetaAndTableFiledMapper modelMetaAndTableFiledMapper;
    public List<ModelMetaAndTableFiled> findAll()
    {
        return modelMetaAndTableFiledMapper.findAll();
    }
    public List<ModelMetaAndTableFiled> findAllByMapId(String map_id )
    {
        return modelMetaAndTableFiledMapper.findAllByMapId(map_id);
    }
    public List<RelMetaAndTableFiledDTO> findDtoByMapId(String map_id )
    {
        return modelMetaAndTableFiledMapper.findDtoByMapId(map_id);
    }
    public void deleteById(String id )
    {
        modelMetaAndTableFiledMapper.deleteById(id);
    }
    public void addMetaAndTableFileds( List<ModelMetaAndTableFiled> metaAndTableFileds )
    {
        modelMetaAndTableFiledMapper.addMetaAndTableFileds( metaAndTableFileds );
    }
}
