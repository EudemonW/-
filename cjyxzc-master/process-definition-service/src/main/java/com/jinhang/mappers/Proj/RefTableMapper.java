package com.jinhang.mappers.Proj;

import com.jinhang.process.model.RefTable;
import org.apache.ibatis.annotations.Param;

public interface RefTableMapper {
    public RefTable findById( @Param("id") String id );
    public void AddRefTable( @Param("refTable") RefTable refTable );
}
