package com.jinhang.mappers.Proj;

import com.jinhang.model.Meta;

import java.util.List;

public interface MetaMapper {
    public List<Meta> findAllByDataModelId(String id);
    public List<Meta> findAll();
    public void add(Meta meta);
    public void update(Meta meta);
    public Meta findById(String id);
    public void deleteById(String id);
}
