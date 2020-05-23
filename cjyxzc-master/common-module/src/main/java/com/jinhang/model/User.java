package com.jinhang.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String id;
    private String user_name;
    private String user_tel;
    private String dept_id;
    private Date create_time;
    private String create_by;
    private Date update_time;
    private String update_by;
    private Date last_login_time;
    private String status;
}
