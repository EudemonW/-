package com.jinhang.dao;

import com.jinhang.model.User;
import com.jinhang.mappers.Proj.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao {
    @Autowired
    private UserMapper userMapper;

    public List<User> findAll( )
    {
        return userMapper.findAll();
    }

    public List<User> findAllByDeptId( String id )
    {
        return userMapper.findAllByDeptId( id );
    }

    public List<User> findAllByProjId( String id )
    {
        return userMapper.findAllByProjId( id );
    }
}
