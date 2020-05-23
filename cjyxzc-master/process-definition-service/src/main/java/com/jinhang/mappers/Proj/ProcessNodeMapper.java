package com.jinhang.mappers.Proj;

import com.jinhang.process.model.ProcessNode;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessNodeMapper {
    public List<ProcessNode> findAllByProcessId( @Param("id") String id );
    public void AddProcessNodes( List<ProcessNode> processNodes );
    public void DeleteByProcessId( @Param("process_id") String process_id );
}
