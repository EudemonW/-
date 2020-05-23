package com.jinhang.dao;

import com.jinhang.mappers.Proj.RefTableMapper;
import com.jinhang.process.model.RefTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RefTableDao {
    @Autowired
    private RefTableMapper refTableMapper;

    public RefTable findById(String id )
    {
        return  refTableMapper.findById(id);
    }
    public void AddRefTable( RefTable refTable )
    {
        refTableMapper.AddRefTable( refTable );
    }
}
