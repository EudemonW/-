package com.jinhang.dao;

import com.jinhang.mappers.Proj.MainProcessMapper;
import com.jinhang.process.model.MainProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainProcessDao {
    @Autowired
    private MainProcessMapper mainProcessMapper;

    public void AddMainProcess( MainProcess mainProcess )
    {
        mainProcessMapper.AddMainProcess( mainProcess );
    }
    public void DeleteMainProcessById( String id )
    {
        mainProcessMapper.DeleteMainProcessById( id );
    }
    public MainProcess findById(String id )
    {
        return mainProcessMapper.findById(id);
    }
}
