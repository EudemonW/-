package com.jinhang.VO;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ProjBasic {
    private String proj_name;
    private String dept_id;
    private String proj_desc;
}
