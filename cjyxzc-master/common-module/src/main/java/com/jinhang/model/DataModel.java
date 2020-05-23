package com.jinhang.model;

import com.jinhang.VO.DataModelBasic;
import com.jinhang.commons.DataModelEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataModel {
    private String id;
    private String model_name;
    private String model_desc;
    private String proj_id;
    private DataModelEnum.DATAMODEL_TYPE model_type;
    private Date create_time;
    private String create_by;
    private Date update_time;
    private String update_by;
    private String status;

    public void Init( DataModelBasic dataModelBasic,String create_by )
    {
        this.id = UUID.randomUUID().toString();
        BeanUtils.copyProperties(dataModelBasic, this );
        this.create_by = create_by;
        this.update_by = create_by;
        this.status = "valid";
    }

    public void Update(DataModelBasic dataModelBasic, String user_id )
    {
        BeanUtils.copyProperties(dataModelBasic, this );
        this.update_by = user_id;
    }
}
