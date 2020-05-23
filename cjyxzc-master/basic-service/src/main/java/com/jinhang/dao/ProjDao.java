package com.jinhang.dao;

import com.jinhang.mappers.Proj.ProjMapper;
import com.jinhang.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjDao {
    @Autowired
    private ProjMapper projMapper;

    public List<Project> findAllByDeptId(String id )
    {
        return projMapper.findAllByDeptId(id);
    }

    public List<Project> findAll( )
    {
        return projMapper.findAll();
    }

    public void add( Project project )
    {
        projMapper.add( project );
    }

    public void update( Project project )
    {
        projMapper.update( project);
    }

    public Project findById(String id )
    {
        return projMapper.findById( id );
    }

    public void deleteById(String id)
    {
        projMapper.deleteById( id );
    }
}
