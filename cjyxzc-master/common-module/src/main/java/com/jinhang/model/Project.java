package com.jinhang.model;

import com.jinhang.VO.ProjBasic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    private String id;
    private String proj_name;
    private String proj_desc;
    private String dept_id;
    private Date create_time;
    private String create_by;
    private Date update_time;
    private String update_by;

    public void Init( ProjBasic projBasic , String user_id )
    {
        this.id = UUID.randomUUID().toString();
        BeanUtils.copyProperties(projBasic,this );
        this.create_by = user_id;
        this.update_by = user_id;
    }

    public void Update(ProjBasic projBasic, String user_id )
    {
        BeanUtils.copyProperties(projBasic,this );
        Date now = new Date();
        this.update_by = user_id;
    }
}
