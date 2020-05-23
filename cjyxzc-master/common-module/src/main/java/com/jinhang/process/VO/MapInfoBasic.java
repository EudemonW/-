package com.jinhang.process.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapInfoBasic {
    private String map_name;
    private String map_desc;
    private String process_id;
    private String data_model_id;
    private String source_table_name;
}
