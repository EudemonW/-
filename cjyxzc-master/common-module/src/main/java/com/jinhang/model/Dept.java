package com.jinhang.model;

import lombok.Data;

@Data
public class Dept {
    private String id;
    private String dept_name;
    private String parent_dept_id;
}
