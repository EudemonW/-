package com.jinhang.controller;
import com.jinhang.Service.ProcessService;
import com.jinhang.VO.PreprocessProcessConfig;
import com.jinhang.commons.ProcessEnum;
import com.jinhang.process.VO.ProcessInfoBasic;
import com.jinhang.process.model.MainProcess;
import com.jinhang.process.model.ProcessInfo;
import com.jinhang.result.HttpResult;
import com.jinhang.result.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Api(value = "", tags = "ProcessController")
@RestController
@RequestMapping(value = "/v1/process")
public class ProcessController extends AbstractController{
    @Autowired
    private ProcessService processService;

    @ApiOperation(value = "获取所有任务")
    @GetMapping(value = "/processInfos")
    public HttpResult<List<ProcessInfo>> GetAllProcessInfos() {
        List<ProcessInfo> processInfos = processService.findAll();
        String msg = "Get All processInfos succeed!";
        if( processInfos == null || processInfos.size() < 1 )
            msg = "null processInfos!";

        return responseOK( processInfos, msg );
    }

    @ApiOperation(value = "根据场景id获取任务")
    @GetMapping(value = "/findprocessinfos")
    public HttpResult< List<ProcessInfo> > GetAllProcessInfosByProjId( @RequestParam String proj_id ) {
        List<ProcessInfo> processInfos = processService.findAllByProjId( proj_id );
        String msg = "Get All processInfos By projId succeed!";
        if( processInfos == null || processInfos.size() < 1 )
            msg = "null processInfos!";

        return responseOK( processInfos,msg);
    }

    @ApiOperation(value = "根据场景id和任务类型获取任务")
    @GetMapping(value = "/findprocessInfosbyprojidandprocesstype")
    public HttpResult< List<ProcessInfo> > GetAllProcessInfosByProjIdAndProcessType(@RequestParam String proj_id,
                                                                                    @RequestParam ProcessEnum.PROCESS_TYPE processType) {
        List<ProcessInfo> processInfos = processService.findAllByProjIdAndProcessType( proj_id ,processType.toString() );
        String msg = "findAllByProjIdAndProcessType succeed!";
        if( processInfos == null || processInfos.size() < 1 )
            msg = "null processInfos!";

        return responseOK( processInfos,msg);
    }

    @ApiOperation(value = "根据任务id获取任务")
    @GetMapping(value = "/processInfos/{id}")
    public HttpResult< ProcessInfo > GetProcessInfoById( @PathVariable String id ) {
        ProcessInfo processInfo = processService.findById( id );
        if( processInfo == null  )
            responseFail(ResultCode.SYSTEM_ERROR,"GetProcessInfoById failed!");

        return responseOK( processInfo,"GetProcessInfoById succeed!");
    }

    @ApiOperation(value = "根据任务id获取一级画布工作流")
    @GetMapping(value = "/processInfos/{process_id}/mainProcess/{main_process_id}")
    public HttpResult< MainProcess > GetMainProcess( @PathVariable("process_id") String process_id,
                                                         @PathVariable("main_process_id") String main_process_id ) {
        MainProcess mainProcess = processService.findMainProcessById( process_id );
        if( mainProcess == null  )
            responseFail(ResultCode.SYSTEM_ERROR,"GetMainProcess failed!");

        return responseOK( mainProcess,"GetProcessInfoById succeed!");
    }

    @ApiOperation(value = "新增任务")
    @PostMapping(value = "/processInfos")
    public HttpResult< String > AddProcessInfo( @RequestBody ProcessInfoBasic processInfoBasic ,@RequestParam String UserId) {
        ProcessInfo processInfo = new ProcessInfo();
        processInfo.Init( processInfoBasic , UserId);
        processService.addProcessInfo( processInfo  );
        return responseOK( "addProcessInfo succeed!");
    }

    @ApiOperation(value = "修改任务基础信息")
    @PutMapping(value = "/processInfos/{id}")
    public HttpResult< String > UpdateProcessInfo(@PathVariable String id , @RequestBody ProcessInfoBasic processInfoBasic,
                                                @RequestParam String UserId) {
        ProcessInfo processInfo = new ProcessInfo();
        processInfo.setId( id );
        processInfo.Update( processInfoBasic, UserId );
        processService.updateProcessInfo( processInfo );
        return responseOK( "updateProcessInfo succeed!");
    }

    @ApiOperation(value = "根据任务id删除")
    @DeleteMapping(value = "/processInfos/{id}")
    public HttpResult< String > DeleteProcessInfoById( @PathVariable String id ) {
        processService.deleteById( id );
        return responseOK( "deleteDataModelById succeed!");
    }

    @ApiOperation(value = "配置数据预处理流程")
    @PostMapping(value = "/processInfos/{process_id}/mainProcess/{main_process_id}/preprocess")
    public HttpResult< String > PreProcessConfig( @PathVariable("process_id") String process_id,
                                                  @PathVariable("main_process_id") String main_process_id ,
                                                  @RequestBody PreprocessProcessConfig body ) {

        return responseOK( "PreProcessConfig succeed!");
    }

//    @ApiOperation(value = "配置数据计算流程")
//    @PostMapping(value = "/processInfos/{process_id}/mainProcess/{main_process_id}/calc")
//    public HttpResult< String > CalcProcessConfig( @PathVariable("process_id") String process_id,
//                                                   @PathVariable("main_process_id") String main_process_id,
//                                                   @RequestBody CalcProcessConfig body ) {
//
//        return responseOK( "CalcProcessConfig succeed!");
//    }

}
