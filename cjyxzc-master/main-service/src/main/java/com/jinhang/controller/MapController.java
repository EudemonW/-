package com.jinhang.controller;

import com.jinhang.Service.BaseService;
import com.jinhang.Service.MapService;
import com.jinhang.model.DataModel;
import com.jinhang.process.VO.MapInfoBasic;
import com.jinhang.process.VO.MapInfos;
import com.jinhang.process.VO.ModelMetaAndTableFiledBasic;
import com.jinhang.process.model.MapInfo;
import com.jinhang.process.model.ModelMetaAndTableFiled;
import com.jinhang.result.HttpResult;
import com.jinhang.result.ResultCode;
import com.jinhang.utils.ShortUUIDGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Api(value = "", tags = "MapController")
@RestController
@RequestMapping(value = "/v1/process/mapping")
public class MapController extends AbstractController{
    @Autowired
    private MapService mapService;
    @Autowired
    private BaseService baseService;

    @ApiOperation(value = "根据 流程ID 获取所有映射")
    @GetMapping(value = "/mappings")
    public HttpResult< List<MapInfo> > GetAllMappingsByProcessId( @RequestParam String processId ) {
        List<MapInfo> mapInfos = mapService.findAllMapInfosByProcessId(processId);
        String msg = "Get findAllMapInfosByProcessId succeed!";
        if( mapInfos == null || mapInfos.size() < 1 )
            msg = "null mapInfos!";

        return responseOK( mapInfos, msg );
    }

    @ApiOperation(value = "根据映射id获取映射")
    @GetMapping(value = "/mappings/{id}")
    public HttpResult< MapInfo > GetMapInfoById( @PathVariable String id ) {
        MapInfo project =mapService.findMapInfoById(id);
        if( project == null  )
            responseFail(ResultCode.SYSTEM_ERROR,"GetMapInfoById failed!");

        return responseOK( project,"GetMapInfoById succeed!");
    }

    @ApiOperation(value = "新增映射")
    @PostMapping(value = "/mappings")
    public HttpResult< String > AddMapInfo(@RequestBody MapInfos mapInfos , @RequestParam String UserId ) {
        MapInfo mapInfo = new MapInfo();

        MapInfoBasic mapInfoBasic = mapInfos.getMapInfoBasic();
        mapInfo.Init( mapInfoBasic , UserId );

        DataModel dataModel = baseService.findDataModelById( mapInfos.getMapInfoBasic().getData_model_id() );
        String dataModelName = dataModel.getModel_name();
        mapInfo.setEntity_table_name( dataModelName+"_"+ ShortUUIDGenerator.UUID());

        mapService.addMapInfo( mapInfo );
        if( mapInfos.getRels() != null && mapInfos.getRels().size() > 0 )
        {
            mapService.addMetaAndTableFileds( mapInfo.getId(), mapInfos.getRels() );
            baseService.createTable( mapInfo.getSource_table_name(),mapInfo.getEntity_table_name() , ModelMetaAndTableFiledBasic.Convert2Map(mapInfos.getRels() ) );
        }

        return responseOK( "AddMapInfo succeed!");
    }

    @ApiOperation(value = "修改映射")
    @PutMapping(value = "/mappings/{id}")
    public HttpResult< String > UpdateMapInfo(@PathVariable String id , @RequestBody MapInfoBasic mapInfoBasic, @RequestParam String UserId) {
        MapInfo mapInfo = new MapInfo();
        mapInfo.setId(id);
        mapInfo.Update( mapInfoBasic, UserId );
        mapService.updateMapInfo( mapInfo );
        return responseOK( "UpdateMapInfo succeed!");
    }

    @ApiOperation(value = "删除映射对应字段")
    @DeleteMapping(value = "/mappings/{id}/rel")
    public HttpResult< String > DeleteRelProjAndUser( @PathVariable String id ) {
        mapService.deleteModelMetaAndTableFiledById( id );
        return responseOK( "deleteModelMetaAndTableFiledById succeed!");
    }

    @ApiOperation(value = "新增映射对应字段")
    @PostMapping(value = "/mappings/{id}/rel")
    public HttpResult< String > AddMetaAndTableFiled(@PathVariable String map_id , @RequestBody ModelMetaAndTableFiledBasic modelMetaAndTableFiledBasic ) {
        mapService.addMetaAndTableFileds( map_id , new ArrayList<ModelMetaAndTableFiledBasic>(){{this.add(modelMetaAndTableFiledBasic);}}  );
        return responseOK( "AddMetaAndTableFiled succeed!");
    }

    @ApiOperation(value = "根据映射id删除映射")
    @DeleteMapping(value = "/mappings/{id}")
    public HttpResult< String > DeleteMapInfoById( @PathVariable String id ) {
        mapService.deleteMapInfoById( id );
        return responseOK( "deleteMapInfoById succeed!");
    }

    @ApiOperation(value = "根据映射id获取映射关系")
    @GetMapping(value = "/mappings/{id}/rels")
    public HttpResult< List<ModelMetaAndTableFiled> > GetRelationsById(@PathVariable String id ) {
        return responseOK( mapService.findAllModelMetaAndTableFiledsByMapId( id ),"GetRelationsById succeed!");
    }

    @ApiOperation(value = "删除映射关系")
    @DeleteMapping(value = "/mappings/{id}/rels/{rel_id}")
    public HttpResult< String > GetRelationsById(@PathVariable("id") String id ,@PathVariable("rel_id") String rel_id ) {
        mapService.deleteModelMetaAndTableFiledById(rel_id);
        return responseOK( "deleteModelMetaAndTableFiledById succeed!");
    }

}
