package com.jinhang.Service;

import com.jinhang.commons.ProcessEnum;
import com.jinhang.dao.MainProcessDao;
import com.jinhang.dao.MapInfoDao;
import com.jinhang.dao.ProcessInfoDao;
import com.jinhang.process.model.MainProcess;
import com.jinhang.process.model.MapInfo;
import com.jinhang.process.model.ProcessInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessService {
    @Autowired
    private ProcessInfoDao processInfoDao;
    @Autowired
    private MainProcessDao mainProcessDao;

    public void addProcessInfo( ProcessInfo processInfo )
    {
        processInfoDao.addProcessInfo(processInfo);
        // 构建一级画布相关信息
        if( processInfo.getProcess_type().equals( ProcessEnum.PROCESS_TYPE.PROCESS ) )
        {
            MainProcess mainProcess = new MainProcess();
            mainProcess.Init( processInfo.getMain_process_id() );
            mainProcessDao.AddMainProcess( mainProcess );
        }
    }

    public List<ProcessInfo> findAll()
    {
        return processInfoDao.findAll();
    }

    public List<ProcessInfo> findAllByProjId( String projid )
    {
        return  processInfoDao.findAllByProjId( projid );
    }

    public List<ProcessInfo> findAllByProjIdAndProcessType( String projid, String type )
    {
        return processInfoDao.findAllByProjIdAndProcessType( projid , type );
    }

    public void updateProcessInfo( ProcessInfo processInfo )
    {
        processInfoDao.updateProcessInfo( processInfo );
    }

    public void deleteById(String id)
    {
        processInfoDao.deleteById( id );
    }

    public ProcessInfo findById( String id )
    {
        return processInfoDao.findById( id );
    }

    public MainProcess findMainProcessById(String id )
    {
        return mainProcessDao.findById(id);
    }
}
