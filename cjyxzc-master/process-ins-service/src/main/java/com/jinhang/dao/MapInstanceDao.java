package com.jinhang.dao;

import com.jinhang.mappers.Proj.MapInstanceMapper;
import com.jinhang.process.model.MapInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapInstanceDao {
    @Autowired
    private MapInstanceMapper mapInstanceMapper;
    public void addMapInstances( List<MapInstance> mapInstances )
    {
        mapInstanceMapper.addMapInstances( mapInstances );
    }

    public void EntityBatchInsert( String fields, List<String> datas,String tableName )
    {
        mapInstanceMapper.EntityBatchInsert( fields,datas,tableName);
    }
}
