package com.jinhang.dao;

import com.jinhang.mappers.Source.SourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SourceDao {
    @Autowired
    private SourceMapper sourceMapper;
    public List<Map> listTable(){
        return sourceMapper.listTable();
    }

    public List<Map> listTableColumn( String tableName){
        return sourceMapper.listTableColumn(tableName);
    }

    public List<Map> getDatasByFields( String fkeys, String tableName )
    {
        return sourceMapper.getDatasByFields( fkeys,tableName);
    }

    public Map showCreateTableSQL( String tableName )
    {
        return sourceMapper.showCreateTableSQL(tableName);
    }
}
