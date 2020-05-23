package com.jinhang.dao;

import com.jinhang.model.Meta;
import com.jinhang.mappers.Proj.MetaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MetaDao {
    @Autowired
    private MetaMapper metaMapper;

    public List<Meta> findAllByDataModelId(String id )
    {
        return metaMapper.findAllByDataModelId(id);
    }

    public List<Meta> findAll( )
    {
        return metaMapper.findAll();
    }

    public void add( Meta dataModel )
    {
        metaMapper.add( dataModel );
    }

    public void update( Meta dataModel )
    {
        metaMapper.update( dataModel);
    }

    public Meta findById(String id )
    {
        return metaMapper.findById( id );
    }

    public void deleteById(String id)
    {
        metaMapper.deleteById( id );
    }
}
