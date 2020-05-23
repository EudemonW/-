package com.jinhang.mappers.Proj;

import com.jinhang.process.model.ProcessInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessInfoMapper {
    public void AddProcessInfo( ProcessInfo processInfo );
    public List<ProcessInfo> findAll();
    public List<ProcessInfo> findAllByProjId( String proj_id );
    public ProcessInfo findById( String id );
    public List<ProcessInfo> findAllByProjIdAndProcessType(@Param("projid")String projid, @Param("processtype")String processtype );
    public void updateProcessInfo( ProcessInfo processInfo );
    public void deleteById(String id);
}
