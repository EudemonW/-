package com.jinhang;

import com.jinhang.Service.BaseService;
import com.jinhang.Service.MapInstanceService;
import com.jinhang.Service.MapService;
import com.jinhang.Service.ProcessService;
import com.jinhang.model.DataModel;
import com.jinhang.process.DTO.RelMetaAndTableFiledDTO;
import com.jinhang.process.VO.MapInfoBasic;
import com.jinhang.process.VO.MapInfos;
import com.jinhang.process.VO.ModelMetaAndTableFiledBasic;
import com.jinhang.process.model.MapInfo;
import com.jinhang.utils.ShortUUIDGenerator;
import com.jinhang.utils.StringHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@SpringBootTest
public class MapTest {
    @Autowired
    private BaseService baseService;
    @Autowired
    private ProcessService processService;
    @Autowired
    private MapService mapService;
    @Autowired
    private MapInstanceService mapInstanceService;

    @Test
    public void test()
    {
        MapInfoBasic mapInfoBasic_post = new MapInfoBasic( "test1","test1","test1","datasource1","t_test") ;
        List<ModelMetaAndTableFiledBasic> list = new ArrayList<>();
        list.add( new ModelMetaAndTableFiledBasic("datasource1","1","FName","t_test","user_name") );
        list.add( new ModelMetaAndTableFiledBasic("datasource1","2","FSex","t_test","user_sex") );
        list.add( new ModelMetaAndTableFiledBasic("datasource1","3","FAddr","t_test","user_addr") );
        list.add( new ModelMetaAndTableFiledBasic("datasource1","7","FId","t_test","id") );
        MapInfos mapInfos = new MapInfos( mapInfoBasic_post , list );

        MapInfo mapInfo = new MapInfo();

        MapInfoBasic mapInfoBasic = mapInfos.getMapInfoBasic();
        mapInfo.Init( mapInfoBasic , "3" );

        DataModel dataModel = baseService.findDataModelById( mapInfos.getMapInfoBasic().getData_model_id() );
        String dataModelName = dataModel.getModel_name();
        mapInfo.setEntity_table_name( dataModelName+"_"+ ShortUUIDGenerator.UUID());

        mapService.addMapInfo( mapInfo );
        if( mapInfos.getRels() != null && mapInfos.getRels().size() > 0 )
        {
            mapService.addMetaAndTableFileds( mapInfo.getId(), mapInfos.getRels() );
            baseService.createTable( mapInfo.getSource_table_name(),mapInfo.getEntity_table_name() , ModelMetaAndTableFiledBasic.Convert2Map(mapInfos.getRels() ) );
        }

    }

    @Test
    public void mapTest()
    {
        String entitytableName = "t_test_dshjwedj";
        String srcTableName = "t_test";
        String map_id = "map1";

        List<RelMetaAndTableFiledDTO> rels = mapService.findDtoByMapId(map_id);

        // 字段映射关系 key 是原表字段，value 是模型字段，封装成类似: `key`:`value`
        Map<String,String> map = RelMetaAndTableFiledDTO.Convert2Map( rels );

        // 读取原表数据
        List<Map> srcdatas = baseService.getDatasByFields( RelMetaAndTableFiledDTO.GetSourceTableFields(rels) , srcTableName );
        if( srcdatas == null )
            return;

        // 拼接插入语句的字段
        String colums = StringHelper.GetInsertColumns( RelMetaAndTableFiledDTO.GetDataModelFkeys( rels ) );

        // 拼接插入语句的值
        List<String> datas = StringHelper.GetInsertValues( srcdatas , RelMetaAndTableFiledDTO.GetSourceTableFields(rels) );

        // 批量插入
        mapInstanceService.EntityBatchInsert( colums ,datas ,entitytableName );

        // 写入映射表
        // mapInstanceService.addMapInstances();
    }
}