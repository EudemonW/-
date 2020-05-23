package com.jinhang.dao;

import com.jinhang.mappers.Proj.RefWorkMapper;
import com.jinhang.process.model.RefWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RefWorkDao {
    @Autowired
    private RefWorkMapper refWorkMapper;
    public void AddRefWorks( List<RefWork> refWorks )
    {
        refWorkMapper.AddRefWorks( refWorks);
    }

    public List<RefWork> findAllByRefId( String ref_id )
    {
        return refWorkMapper.findAllByRefId( ref_id );
    }

    public void DeleteById( String id )
    {
        refWorkMapper.DeleteById(id);
    }

    public void DeleteByRefId( String ref_id )
    {
        refWorkMapper.DeleteByRefId( ref_id );
    }
}
