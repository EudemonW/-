package com.jinhang.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataModelDTO {
    private String id;
    private String proj_name;
    private String proj_desc;
    private String dept_id;
    private List<MetaDTO> metas;
}
