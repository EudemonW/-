package com.jinhang.controller;

import com.jinhang.Service.BaseService;
import com.jinhang.VO.DataModelBasic;
import com.jinhang.VO.DataModelInfos;
import com.jinhang.commons.DataModelEnum;
import com.jinhang.model.DataModel;
import com.jinhang.result.HttpResult;
import com.jinhang.result.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Api(value = "", tags = "DataModelController")
@RestController
@RequestMapping(value = "/v1/")
public class DataModelController extends AbstractController{
    @Autowired
    private BaseService baseService;

    @ApiOperation(value = "获取所有数据模型")
    @GetMapping(value = "/datamodels")
    public HttpResult<List<DataModel>> GetAllDataModels() {
        List<DataModel> dataModels = baseService.findAllDataModels();
        String msg = "Get All dataModels succeed!";
        if( dataModels == null || dataModels.size() < 1 )
            msg = "null dataModels!";

        return responseOK( dataModels, msg );
    }

    @ApiOperation(value = "根据场景id获取数据模型")
    @GetMapping(value = "/finddatamodels")
    public HttpResult< List<DataModel> > GetAllDataModelsByProjId( @RequestParam String proj_id ) {
        List<DataModel> dataModels = baseService.findAllDataModelByProjId( proj_id );
        String msg = "Get All Users By deptId succeed!";
        if( dataModels == null || dataModels.size() < 1 )
            msg = "null dataModels!";

        return responseOK( dataModels,msg);
    }

    @ApiOperation(value = "根据场景id和模型类型获取数据模型")
    @GetMapping(value = "/finddatamodelsbyprojidandmodeltype")
    public HttpResult< List<DataModel> > GetAllDataModelsByProjId(@RequestParam String proj_id, @RequestParam DataModelEnum.DATAMODEL_TYPE model_type) {
        List<DataModel> dataModels = baseService.findAllByProjIdAndModelType( proj_id ,model_type.toString() );
        String msg = "Get All Users By deptId succeed!";
        if( dataModels == null || dataModels.size() < 1 )
            msg = "null dataModels!";

        return responseOK( dataModels,msg);
    }

    @ApiOperation(value = "根据数据模型id获取数据模型")
    @GetMapping(value = "/datamodels/{id}")
    public HttpResult< DataModel > GetDataModelById( @PathVariable String id ) {
        DataModel dataModel = baseService.findDataModelById( id );
        if( dataModel == null  )
            responseFail(ResultCode.SYSTEM_ERROR,"GetDataModelById failed!");

        return responseOK( dataModel,"GetDataModelById succeed!");
    }

    @ApiOperation(value = "新增数据模型")
    @PostMapping(value = "/datamodels")
    public HttpResult< String > AddDataModel( @RequestBody DataModelInfos modelInfos ,@RequestParam String UserId) {
        DataModel model = new DataModel();
        DataModelBasic dataModelBasic = modelInfos.getDataModelBasic();
        model.Init( dataModelBasic ,UserId );
        baseService.addDataModel( model );
        if( modelInfos.getMetasIds() != null && modelInfos.getMetasIds().size() > 0 )
            baseService.addRelDataModelAndMeta( model.getId(), modelInfos.getMetasIds() );
        return responseOK( "addDataModel succeed!");
    }

    @ApiOperation(value = "修改数据模型")
    @PutMapping(value = "/datamodels/{id}")
    public HttpResult< String > UpdateDataModel(@PathVariable String id , @RequestBody DataModelBasic dataModelBasic, @RequestParam String UserId) {
        DataModel dataModel = new DataModel();
        dataModel.setId( id );
        dataModel.Update(dataModelBasic, UserId );
        baseService.updateDataModel( dataModel );
        return responseOK( "updateDataModel succeed!");
    }

    @ApiOperation(value = "删除数据模型中元数据")
    @DeleteMapping(value = "/datamodels/{id}/rel")
    public HttpResult< String > DeleteRelDataModelAndMeta(@PathVariable String id , @RequestParam String metaId ) {
        baseService.deleteRelDataModelAndMeta( id , metaId );
        return responseOK( "deleteRelDataModelAndMeta succeed!");
    }

    @ApiOperation(value = "新增数据模型中元数据")
    @PostMapping(value = "/datamodels/{id}/rel")
    public HttpResult< String > AddRelDataModelAndMeta(@PathVariable String id , @RequestParam String metaId ) {
        baseService.addRelDataModelAndMeta( id , new ArrayList<String>(){{this.add(metaId);}}  );
        return responseOK( "AddRelDataModelAndMeta succeed!");
    }

    @ApiOperation(value = "根据数据模型id删除数据模型")
    @DeleteMapping(value = "/datamodels/{id}")
    public HttpResult< String > DeleteDataModelById( @PathVariable String id ) {
        baseService.deleteDataModelById( id );
        return responseOK( "deleteDataModelById succeed!");
    }
}
