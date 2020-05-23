package com.jinhang.process.model;

import com.jinhang.process.VO.ModelMetaAndTableFiledBasic;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Data
public class ModelMetaAndTableFiled {
    private String id;
    private String map_id;
    private String data_model_id;
    private String meta_id;
    private String source_table_name;
    private String source_table_field;

    public void build(ModelMetaAndTableFiledBasic modelMetaAndTableFiledBasic , String map_id )
    {
        this.id = UUID.randomUUID().toString();
        this.map_id = map_id;
        BeanUtils.copyProperties( modelMetaAndTableFiledBasic,this);
    }
}
