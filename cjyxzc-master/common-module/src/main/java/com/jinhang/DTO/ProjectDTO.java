package com.jinhang.DTO;

import com.jinhang.model.DataModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
    private String id;
    private String proj_name;
    private String proj_desc;
    private String dept_id;
    private List<DataModel> dataModels;
}
