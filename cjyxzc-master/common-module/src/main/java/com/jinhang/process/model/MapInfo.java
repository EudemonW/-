package com.jinhang.process.model;

import com.jinhang.process.VO.MapInfoBasic;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class MapInfo {
    private String id;
    private String map_name;
    private String map_desc;
    private String process_id;
    private String data_model_id;
    private String source_table_name;
    private String entity_table_name;
    private Date create_time;
    private String create_by;
    private Date update_time;
    private String update_by;
    private String status;

    public void Init( MapInfoBasic mapInfoBasic , String user_id )
    {
        this.id = UUID.randomUUID().toString();
        BeanUtils.copyProperties(mapInfoBasic,this );

        this.create_by = user_id;
        this.update_by = user_id;
    }

    public void Update( MapInfoBasic mapInfoBasicc, String user_id )
    {
        BeanUtils.copyProperties( mapInfoBasicc,this );
        this.update_by = user_id;
    }

    public static List<String> GetIds( List<MapInfo> mapInfos )
    {
        List<String> ids = new ArrayList<>();
        for( MapInfo item : mapInfos )
            ids.add(item.getId());
        return ids;
    }
}
