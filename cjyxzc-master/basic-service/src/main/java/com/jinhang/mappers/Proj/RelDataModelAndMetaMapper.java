package com.jinhang.mappers.Proj;

import com.jinhang.model.RelDataModelAndMeta;

import java.util.List;

public interface RelDataModelAndMetaMapper {
    public void batchInsert( List<RelDataModelAndMeta> list );
    public void delete( String datamodel_id,String meta_id );
}
