package com.jinhang.dao;

import com.jinhang.model.Dept;
import com.jinhang.mappers.Proj.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptDao {
    @Autowired
    private DeptMapper deptMapper;

    public List<Dept> findAll( )
    {
        return deptMapper.findAll();
    }
}
