package com.jinhang.mappers.Source;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SourceMapper {
    List<Map> listTable();
    List<Map> listTableColumn(@Param("tableName") String tableName);
    public List<Map> getDatasByFields(@Param("fields") String fields, @Param("tableName") String tableName );
    public Map showCreateTableSQL( @Param("tableName") String tableName );
}
