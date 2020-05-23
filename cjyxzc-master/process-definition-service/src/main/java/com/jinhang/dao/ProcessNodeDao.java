package com.jinhang.dao;

import com.jinhang.mappers.Proj.ProcessNodeMapper;
import com.jinhang.process.model.ProcessNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProcessNodeDao {
    @Autowired
    private ProcessNodeMapper processNodeMapper;

    public List<ProcessNode> findAllByProcessId( String process_id )
    {
        return processNodeMapper.findAllByProcessId( process_id );
    }

    public void AddProcessNodes( List<ProcessNode> processNodes )
    {
        processNodeMapper.AddProcessNodes( processNodes );
    }

    public void DeleteByProcessId( String process_id )
    {
        processNodeMapper.DeleteByProcessId( process_id );
    }

}
