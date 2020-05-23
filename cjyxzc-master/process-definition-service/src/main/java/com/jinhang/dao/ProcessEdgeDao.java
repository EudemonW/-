package com.jinhang.dao;

import com.jinhang.mappers.Proj.ProcessEdgeMapper;
import com.jinhang.process.model.ProcessEdge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProcessEdgeDao {
    @Autowired
    private ProcessEdgeMapper processEdgeMapper;

    public List<ProcessEdge> findAllByProcessId( String process_id )
    {
        return processEdgeMapper.findAllByProcessId( process_id);
    }

    public void AddProcessEdges( List<ProcessEdge> processEdges )
    {
        processEdgeMapper.AddProcessEdges( processEdges );
    }

    public void DeleteByProcessId(  String process_id )
    {
        processEdgeMapper.DeleteByProcessId( process_id );
    }

}
