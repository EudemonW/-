package com.jinhang.process.model;

import lombok.Data;

import java.util.Date;

@Data
public class ProcessNode {
    private String id;
    private String process_id;
    private String process_type_id;
    private String ref_id;
    private Date create_time;
    private String create_by;
    private Date update_time;
    private String update_by;
    private String status;
}
