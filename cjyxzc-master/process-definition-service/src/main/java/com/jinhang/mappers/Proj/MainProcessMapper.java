package com.jinhang.mappers.Proj;

import com.jinhang.process.model.MainProcess;

public interface MainProcessMapper {
    public void AddMainProcess( MainProcess mainProcess );
    public void DeleteMainProcessById( String id );
    public MainProcess findById(String id);
}
