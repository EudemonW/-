package com.jinhang.dao;

import com.jinhang.mappers.Proj.RelDataModelAndMetaMapper;
import com.jinhang.model.RelDataModelAndMeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RelDataModelAndMetaDao {

    @Autowired
    private RelDataModelAndMetaMapper relDataModelAndMetaMapper;

    public void add(List<RelDataModelAndMeta> list)
    {
        relDataModelAndMetaMapper.batchInsert( list );
    }
    public void delete(String datamodel_id ,String meta_id )
    {
        relDataModelAndMetaMapper.delete( datamodel_id , meta_id );
    }
}
