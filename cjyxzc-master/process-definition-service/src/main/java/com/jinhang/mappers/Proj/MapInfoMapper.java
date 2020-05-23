package com.jinhang.mappers.Proj;

import com.jinhang.process.model.MapInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MapInfoMapper {
    public List<MapInfo> findAllByProcessId( String process_id );
    public List<MapInfo> findAll();
    public void addMapInfo(MapInfo mapInfo);
    public void updateMapInfo(MapInfo mapInfo);
    public MapInfo findById(String id);
    public void deleteMapInfoById(String id);
}
