package com.jinhang.mappers.Proj;

import com.jinhang.model.User;

import java.util.List;

public interface UserMapper {
    public List<User> findAll();
    public List<User> findAllByDeptId(String dept_id);
    public List<User> findAllByProjId(String proj_id);
}
