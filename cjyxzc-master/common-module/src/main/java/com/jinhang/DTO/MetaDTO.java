package com.jinhang.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetaDTO {
    private String id;
    private String fKey;
    private String caption;
    private String type;
    private String desc;
    private int length;
}
