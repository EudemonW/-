package com.jinhang.dao;

import com.jinhang.mappers.Proj.ProcessInfoMapper;
import com.jinhang.process.model.ProcessInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProcessInfoDao {
    @Autowired
    private ProcessInfoMapper processInfoMapper;

    public void addProcessInfo(ProcessInfo processInfo)
    {
        processInfoMapper.AddProcessInfo(processInfo);
    }
    public List<ProcessInfo> findAll()
    {
        return processInfoMapper.findAll();
    }

    public List<ProcessInfo> findAllByProjId( String projid )
    {
        return  processInfoMapper.findAllByProjId( projid );
    }

    public List<ProcessInfo> findAllByProjIdAndProcessType( String projid, String type )
    {
        return processInfoMapper.findAllByProjIdAndProcessType( projid , type );
    }

    public void updateProcessInfo( ProcessInfo processInfo )
    {
        processInfoMapper.updateProcessInfo( processInfo );
    }
    public void deleteById(String id)
    {
        processInfoMapper.deleteById( id );
    }
    public ProcessInfo findById( String id )
    {
        return processInfoMapper.findById( id );
    }
}
