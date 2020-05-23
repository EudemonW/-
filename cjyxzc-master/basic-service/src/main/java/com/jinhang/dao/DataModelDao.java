package com.jinhang.dao;

import com.jinhang.model.DataModel;
import com.jinhang.mappers.Proj.DataModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataModelDao {

    @Autowired
    private DataModelMapper dataModelMapper;

    public List<DataModel> findAllByProjId(String id )
    {
        return dataModelMapper.findAllByProjId(id);
    }
    public List<DataModel> findAllByProjIdAndModelType(String projId,String type )
    {
        return dataModelMapper.findAllByProjIdAndModelType(projId,type);
    }

    public List<DataModel> findAll( )
    {
        return dataModelMapper.findAll();
    }

    public void add( DataModel dataModel )
    {
        dataModelMapper.add( dataModel );
    }

    public void update( DataModel dataModel )
    {
        System.out.println("第一次修改");
        dataModelMapper.update( dataModel);
    }

    public DataModel findById(String id )
    {
        return dataModelMapper.findById( id );
    }

    public void deleteById(String id)
    {
        dataModelMapper.deleteById( id );
    }

    public void createTable(  String sql )
    {
        dataModelMapper.createTable( sql );
    }
}
