package com.jinhang.mappers.Proj;

import com.jinhang.model.DataModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DataModelMapper {
    public List<DataModel> findAllByProjId(String id);
    public List<DataModel> findAllByProjIdAndModelType(@Param("projid") String projid, @Param("modeltype")String modeltype);
    public List<DataModel> findAll();
    public void add(DataModel dataModel);
    public void update(DataModel dataModel);
    public DataModel findById(String id);
    public void deleteById(String id);
    public void createTable( @Param("sql") String sql );
}
