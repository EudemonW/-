package com.jinhang.VO;

import com.jinhang.commons.DataModelEnum;
import lombok.Data;

@Data
public class DataModelBasic {
    private String model_name;
    private String model_desc;
    private String proj_id;
    private DataModelEnum.DATAMODEL_TYPE model_type;
}
