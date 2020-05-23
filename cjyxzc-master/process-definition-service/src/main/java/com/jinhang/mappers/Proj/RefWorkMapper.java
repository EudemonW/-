package com.jinhang.mappers.Proj;

import com.jinhang.process.model.RefWork;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RefWorkMapper {
    public void AddRefWorks( List<RefWork> refWorks );
    public List<RefWork> findAllByRefId( @Param("ref_id") String ref_id );
    public void DeleteById( @Param("id")String id );
    public void DeleteByRefId( @Param("ref_id") String ref_id );
}
