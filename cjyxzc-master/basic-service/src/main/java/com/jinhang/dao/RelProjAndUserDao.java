package com.jinhang.dao;

import com.jinhang.mappers.Proj.RelProjAndUserMapper;
import com.jinhang.model.RelProjAndUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RelProjAndUserDao {
    @Autowired
    private RelProjAndUserMapper relProjAndUserMapper;

    public void add(List<RelProjAndUser> list)
    {
        relProjAndUserMapper.batchInsert( list );
    }
    public void delete(String proj_id ,String user_id )
    {
        relProjAndUserMapper.delete( proj_id , user_id );
    }
}
