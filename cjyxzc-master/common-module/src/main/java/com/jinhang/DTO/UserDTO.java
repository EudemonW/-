package com.jinhang.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String id;
    private String user_name;
    private String user_tel;
    private String dept_id;
    private String status;
}
