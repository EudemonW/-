package com.jinhang.mappers.Proj;

import com.jinhang.model.RelProjAndUser;

import java.util.List;

public interface RelProjAndUserMapper {
    public void batchInsert( List<RelProjAndUser> list );
    public void delete( String proj_id,String user_id );
}
