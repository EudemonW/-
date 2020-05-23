package com.jinhang.model;

import com.jinhang.VO.MetaBasic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meta {
    private String id;
    private String fkey;
    private String caption;
    private String type;
    private int length;
    private Date create_time;
    private String create_by;
    private Date update_time;
    private String update_by;

    public void Init(MetaBasic infos, String create_by )
    {
        this.id = UUID.randomUUID().toString();
        BeanUtils.copyProperties( infos,this );
        this.create_by = create_by;
        this.update_by = create_by;
    }

    public void Update(MetaBasic infos, String id , String userId)
    {
        this.id = id;
        BeanUtils.copyProperties( infos, this );
        Date now = new Date();
        this.update_by = userId;
    }

}
