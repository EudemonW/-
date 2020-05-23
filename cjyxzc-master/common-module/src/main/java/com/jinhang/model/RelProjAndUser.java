package com.jinhang.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelProjAndUser {
    private String id;
    private String proj_id;
    private String user_id;
    private String status;
}
