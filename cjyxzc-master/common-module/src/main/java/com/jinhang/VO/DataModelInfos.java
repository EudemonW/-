package com.jinhang.VO;

import com.jinhang.DTO.MetaDTO;
import com.jinhang.model.Meta;
import lombok.Data;

import java.util.List;

@Data
public class DataModelInfos {
    private DataModelBasic dataModelBasic;
    private List<String> metasIds;
}
