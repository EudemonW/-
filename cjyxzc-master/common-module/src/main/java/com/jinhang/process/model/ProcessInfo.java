package com.jinhang.process.model;

import com.jinhang.commons.ProcessEnum;
import com.jinhang.process.VO.ProcessInfoBasic;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.UUID;

@Data
public class ProcessInfo {
    private String id;
    private String process_name;
    private String process_desc;
    private ProcessEnum.PROCESS_TYPE process_type;
    private String main_process_id;
    private boolean is_real_time;
    private String proj_id;
    private ProcessEnum.TIMER timer_set;
    private Date start_time;
    private Date create_time;
    private String create_by;
    private Date update_time;
    private String update_by;
    private String status;

    public void Init(ProcessInfoBasic processInfoBasic , String create_by )
    {
        this.id = UUID.randomUUID().toString();
        this.main_process_id = UUID.randomUUID().toString();
        BeanUtils.copyProperties(processInfoBasic, this );
        this.create_by = create_by;
        this.update_by = create_by;
        this.status = "valid";
    }

    public void Update(ProcessInfoBasic processInfoBasic, String user_id )
    {
        BeanUtils.copyProperties(processInfoBasic, this );
        this.update_by = user_id;
    }
}
