package com.jinhang.mappers.Proj;

import com.jinhang.process.model.MapInstance;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MapInstanceMapper {
    public void addMapInstances( List<MapInstance> metaAndTableFiled );
    public void EntityBatchInsert( @Param("fields") String fields, @Param("datas") List<String> datas,@Param("tableName") String tableName );
}
