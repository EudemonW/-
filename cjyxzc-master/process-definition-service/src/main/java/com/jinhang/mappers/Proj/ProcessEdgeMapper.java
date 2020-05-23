package com.jinhang.mappers.Proj;

import com.jinhang.process.model.ProcessEdge;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessEdgeMapper {
    public List<ProcessEdge> findAllByProcessId( @Param("process_id") String process_id );
    public void AddProcessEdges( List<ProcessEdge> processEdges );
    public void DeleteByProcessId( @Param("process_id") String process_id );
}
