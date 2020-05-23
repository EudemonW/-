package com.jinhang.process.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class RelMetaAndTableFiledDTO {
    private String id;
    private String map_id;
    private String data_model_id;
    private String fkey;
    private String source_table_name;
    private String source_table_field;

    public static Map Convert2Map( List<RelMetaAndTableFiledDTO> list )
    {
        Map ret = new HashMap();
        for( RelMetaAndTableFiledDTO item : list )
            ret.put( "`"+item.source_table_field+"`","`"+item.fkey+"`");

        return ret;
    }

    public static List<String> GetSourceTableFields( List<RelMetaAndTableFiledDTO> list )
    {
        List<String> ret = new ArrayList<>();
        for( RelMetaAndTableFiledDTO item : list )
            ret.add( item.getSource_table_field());

        return ret;
    }

    public static List<String> GetDataModelFkeys( List<RelMetaAndTableFiledDTO> list )
    {
        List<String> ret = new ArrayList<>();
        for( RelMetaAndTableFiledDTO item : list )
            ret.add( item.getFkey());

        return ret;
    }
}
