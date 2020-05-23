package com.jinhang.controller;

import com.jinhang.Service.BaseService;
import com.jinhang.VO.ProjBasic;
import com.jinhang.VO.ProjInfos;
import com.jinhang.model.Project;
import com.jinhang.result.HttpResult;
import com.jinhang.result.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Api(value = "", tags = "ProjController")
@RestController
@RequestMapping(value = "/v1/")
public class ProjController extends AbstractController{
    @Autowired
    private BaseService baseService;

    @ApiOperation(value = "获取所有场景")
    @GetMapping(value = "/projs")
    public HttpResult<List<Project>> GetAllProjects() {
        List<Project> projects = baseService.findAllProjs();
        String msg = "Get All projects succeed!";
        if( projects == null || projects.size() < 1 )
            msg = "null projects!";

        return responseOK( projects, msg );
    }

    @ApiOperation(value = "根据部门id获取场景")
    @GetMapping(value = "/findprojs")
    public HttpResult< List<Project> > GetAllProjectsByDeptId( @RequestParam String dept_id  ) {
        List<Project> projects = baseService.findAllProjsByDeptId( dept_id );
        String msg = "Get All projects By deptId succeed!";
        if( projects == null || projects.size() < 1 )
            msg = "null projects!";

        return responseOK( projects,msg);
    }

    @ApiOperation(value = "根据场景id获取场景")
    @GetMapping(value = "/projs/{id}")
    public HttpResult< Project > GetProjectById( @PathVariable String id ) {
        Project project = baseService.findProjectById( id );
        if( project == null  )
            responseFail(ResultCode.SYSTEM_ERROR,"GetProjectById failed!");

        return responseOK( project,"GetProjectById succeed!");
    }

    @ApiOperation(value = "新增场景")
    @PostMapping(value = "/projs")
    public HttpResult< String > AddProject( @RequestBody ProjInfos projInfos ,@RequestParam String UserId ) {
        Project project = new Project();
        ProjBasic projBasic = projInfos.getProjBasic();
        project.Init( projBasic , UserId );
        baseService.addProject( project );
        if( projInfos.getUserIds() != null && projInfos.getUserIds().size() > 0 )
            baseService.addRelProjAndUser( project.getId(), projInfos.getUserIds() );
        return responseOK( "addDataModel succeed!");
    }

    @ApiOperation(value = "修改场景")
    @PutMapping(value = "/projs/{id}")
    public HttpResult< String > UpdateProject(@PathVariable String id , @RequestBody ProjBasic projBasic, @RequestParam String UserId) {
        Project project = new Project();
        project.setId(id);
        project.Update(projBasic, UserId );
        baseService.updateProject( project );
        return responseOK( "updateProject succeed!");
    }

    @ApiOperation(value = "删除场景中人员")
    @DeleteMapping(value = "/projs/{id}/rel")
    public HttpResult< String > DeleteRelProjAndUser(@PathVariable String id , @RequestParam String userId) {
        baseService.deleteRelProjAndUser( id , userId );
        return responseOK( "deleteRelProjAndUser succeed!");
    }

    @ApiOperation(value = "新增场景中人员")
    @PostMapping(value = "/projs/{id}/rel")
    public HttpResult< String > AddRelProjAndUser(@PathVariable String id , @RequestParam String userId ) {
        baseService.addRelProjAndUser( id , new ArrayList<String>(){{this.add(userId);}}  );
        return responseOK( "addRelProjAndUser succeed!");
    }

    @ApiOperation(value = "根据场景id删除场景")
    @DeleteMapping(value = "/projs/{id}")
    public HttpResult< String > DeleteProjectById( @PathVariable String id ) {
        baseService.deleteProjectById( id );
        return responseOK( "deleteProjectById succeed!");
    }
}
