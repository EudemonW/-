package com.jinhang.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelDataModelAndMeta {
    private String id;
    private String datamodel_id;
    private String meta_id;
    private String status;
}
