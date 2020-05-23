package com.jinhang.Service;

import com.jinhang.dao.MapInfoDao;
import com.jinhang.dao.ModelMetaAndTableFiledDao;
import com.jinhang.process.DTO.RelMetaAndTableFiledDTO;
import com.jinhang.process.VO.ModelMetaAndTableFiledBasic;
import com.jinhang.process.model.MapInfo;
import com.jinhang.process.model.ModelMetaAndTableFiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MapService {
    @Autowired
    private MapInfoDao mapInfoDao;
    @Autowired
    private ModelMetaAndTableFiledDao modelMetaAndTableFiledDao;

    // 映射相关
    public List<MapInfo> findAllMapInfosByProcessId(String process_id )
    {
        return mapInfoDao.findAllByProcessId(process_id);
    }

    public List<MapInfo> findAllMapInfos()
    {
        return mapInfoDao.findAll();
    }

    public void addMapInfo(MapInfo mapInfo)
    {
        mapInfoDao.addMapInfo(mapInfo);
    }

    public void updateMapInfo(MapInfo mapInfo)
    {
        mapInfoDao.updateMapInfo(mapInfo);
    }

    public MapInfo findMapInfoById(String id)
    {
        return mapInfoDao.findById(id);
    }

    public void deleteMapInfoById(String id)
    {
        mapInfoDao.deleteMapInfoById(id);
    }

    // 映射和源表关联字段相关
    public List<ModelMetaAndTableFiled> findAllModelMetaAndTableFileds()
    {
        return modelMetaAndTableFiledDao.findAll();
    }

    public List<ModelMetaAndTableFiled> findAllModelMetaAndTableFiledsByMapId(String map_id )
    {
        return modelMetaAndTableFiledDao.findAllByMapId(map_id);
    }

    public void deleteModelMetaAndTableFiledById(String id )
    {
        modelMetaAndTableFiledDao.deleteById(id);
    }

    public void addMetaAndTableFileds( String map_id,List<ModelMetaAndTableFiledBasic> modelMetaAndTableFiledBasics )
    {
        List<ModelMetaAndTableFiled> list = new ArrayList<>();
        for( ModelMetaAndTableFiledBasic modelMetaAndTableFiledBasic : modelMetaAndTableFiledBasics )
        {
            list.add( new ModelMetaAndTableFiled(){ {this.build( modelMetaAndTableFiledBasic,map_id);}} );
        }
        modelMetaAndTableFiledDao.addMetaAndTableFileds( list );
    }
    public List<RelMetaAndTableFiledDTO> findDtoByMapId(String map_id )
    {
        return modelMetaAndTableFiledDao.findDtoByMapId(map_id);
    }
}
