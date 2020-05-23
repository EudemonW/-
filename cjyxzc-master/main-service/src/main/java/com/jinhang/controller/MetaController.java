package com.jinhang.controller;

import com.jinhang.Service.BaseService;
import com.jinhang.VO.MetaBasic;
import com.jinhang.model.Meta;
import com.jinhang.result.HttpResult;
import com.jinhang.result.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "", tags = "MetaController")
@RestController
@RequestMapping(value = "/v1/")
public class MetaController extends AbstractController{
    @Autowired
    private BaseService baseService;


    @ApiOperation(value = "获取所有元数据")
    @GetMapping(value = "/metas")
    public HttpResult<List<Meta>> GetAllMetas() {
        List<Meta> metas = baseService.findAllMetas();
        String msg = "Get All metas succeed!";
        if( metas == null || metas.size() < 1 )
            msg = "null metas!";

        return responseOK( metas, msg );
    }

    @ApiOperation(value = "根据数据模型id获取元数据")
    @GetMapping(value = "/findmetas")
    public HttpResult< List<Meta> > GetAllMetasByDeptId( @RequestParam String datamodel_id ) {
        List<Meta> metas = baseService.findAllMetasByDataModelId( datamodel_id );
        String msg = "Get All metas succeed!";
        if( metas == null || metas.size() < 1 )
            msg = "null metas!";

        return responseOK( metas,msg);
    }

    @ApiOperation(value = "根据元数据id获取元数据")
    @GetMapping(value = "/metas/{id}")
    public HttpResult< Meta > GetMetaById( @PathVariable String id ) {
        Meta meta = baseService.findMetaById( id );
        if( meta == null  )
            responseFail(ResultCode.SYSTEM_ERROR,"GetDataModelById failed!");

        return responseOK( meta,"GetDataModelById succeed!");
    }

    @ApiOperation(value = "新增元数据")
    @PostMapping(value = "/metas")
    public HttpResult< String > AddMeta(@RequestBody MetaBasic metaInfos , @RequestParam String userId) {
        Meta meta = new Meta();
        meta.Init( metaInfos ,userId );
        baseService.addMeta( meta );
        return responseOK( "addMeta succeed!");
    }

    @ApiOperation(value = "修改元数据")
    @PutMapping(value = "/metas/{id}")
    public HttpResult< String > UpdateMeta(@PathVariable String id , @RequestBody MetaBasic metaInfos
            ,@RequestParam String userId) {
        Meta meta = new Meta();
        meta.Update( metaInfos ,id ,userId);
        baseService.updateMeta( meta );
        return responseOK( "UpdateMeta succeed!");
    }

    @ApiOperation(value = "根据id删除元数据")
    @DeleteMapping(value = "/metas/{id}")
    public HttpResult< String > DeleteMetalById( @PathVariable String id ) {
        baseService.deleteMetaById( id );
        return responseOK( "DeleteMetalById succeed!");
    }

}
