package com.jinhang.dao;

import com.jinhang.mappers.Proj.ProcessNodeTypeMapper;
import com.jinhang.process.model.ProcessNodeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProcessNodeTypeDao {
    @Autowired
    private ProcessNodeTypeMapper processNodeTypeMapper;
    public List<ProcessNodeType> findAll()
    {
        return processNodeTypeMapper.findAll();
    }
}
