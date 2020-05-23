package com.jinhang.dao;

import com.jinhang.mappers.Proj.MapInfoMapper;
import com.jinhang.process.model.MapInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapInfoDao {

    @Autowired
    private MapInfoMapper mapInfoMapper;

    public List<MapInfo> findAllByProcessId(String process_id )
    {
        return mapInfoMapper.findAllByProcessId(process_id);
    }
    public List<MapInfo> findAll()
    {
        return mapInfoMapper.findAll();
    }
    public void addMapInfo(MapInfo mapInfo)
    {
        mapInfoMapper.addMapInfo(mapInfo);
    }
    public void updateMapInfo(MapInfo mapInfo)
    {
        mapInfoMapper.updateMapInfo(mapInfo);
    }
    public MapInfo findById(String id)
    {
        return mapInfoMapper.findById(id);
    }
    public void deleteMapInfoById(String id)
    {
        mapInfoMapper.deleteMapInfoById(id);
    }
}
