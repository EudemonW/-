package com.jinhang.mappers.Proj;

import com.jinhang.model.Project;

import java.util.List;

public interface ProjMapper {
    public List<Project> findAllByDeptId(String id);
    public List<Project> findAll();
    public void add(Project meta);
    public void update(Project meta);
    public Project findById(String id);
    public void deleteById(String id);
}
