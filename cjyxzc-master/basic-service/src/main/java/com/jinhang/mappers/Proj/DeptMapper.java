package com.jinhang.mappers.Proj;

import com.jinhang.model.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface DeptMapper {
    public List<Dept> findAll();
}
