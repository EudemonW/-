package com.jinhang.process.VO;

import com.jinhang.process.model.ModelMetaAndTableFiled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelMetaAndTableFiledBasic {
    private String data_model_id;
    private String meta_id;
    private String fkey;
    private String source_table_name;
    private String source_table_field;

    public static Map<String,String> Convert2Map( List<ModelMetaAndTableFiledBasic> list)
    {
        Map ret = new HashMap();
        for( ModelMetaAndTableFiledBasic item : list )
            ret.put( "`" + item.getSource_table_field() + "`","`" + item.getFkey() + "`" );
        return ret;
    }
}
