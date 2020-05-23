package com.jinhang.process.VO;

import com.jinhang.commons.ProcessEnum;
import lombok.Data;

import java.util.Date;

@Data
public class ProcessInfoBasic {
    private String process_name;
    private String process_desc;
    private ProcessEnum.PROCESS_TYPE process_type;
    private boolean is_real_time;
    private String proj_id;
    private ProcessEnum.TIMER timer_set;
    private Date start_time;
}
