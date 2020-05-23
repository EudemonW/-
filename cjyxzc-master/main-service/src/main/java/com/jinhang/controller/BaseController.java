package com.jinhang.controller;

import com.jinhang.DTO.DeptTreeNodeDTO;
import com.jinhang.Service.BaseService;
import com.jinhang.model.Dept;
import com.jinhang.model.User;
import com.jinhang.result.HttpResult;
import com.jinhang.result.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(value = "", tags = "BaseController")
@RestController
@RequestMapping(value = "/v1/")
public class BaseController extends AbstractController {

    @Autowired
    private BaseService baseService;

    @ApiOperation(value = "获取所有用户")
    @GetMapping(value = "/users")
    public HttpResult< List<User> > GetAllUsers() {
        List<User> users = baseService.findUsers();
        String msg = "Get All Users succeed!";
        if( users == null || users.size() < 1 )
            msg = "null datas!";

        return responseOK( users, msg );
    }

    @ApiOperation(value = "根据部门ID获取所有用户")
    @GetMapping(value = "/findusersbydept")
    public HttpResult< List<User> > GetAllUsersByDeptId( @RequestParam String deptId ) {
        List<User> users = baseService.findUsersByDeptId( deptId );
        String msg = "Get All Users By deptId succeed!";
        if( users == null || users.size() < 1 )
            msg = "null datas!";

        return responseOK( users,msg);
    }

    @ApiOperation(value = "根据场景ID获取所有用户")
    @GetMapping(value = "/findusersbyproj")
    public HttpResult< List<User> > GetAllUsersByProjId( @RequestParam String projId ) {
        List<User> users = baseService.findAllByProjId( projId );
        String msg = "Get All Users By projId succeed!";
        if( users == null || users.size() < 1 )
            msg = "null users!";

        return responseOK( users,msg);
    }

    @ApiOperation(value = "获取部门组织结构树")
    @GetMapping(value = "/depts")
    public HttpResult<DeptTreeNodeDTO> GetAllUsersByDeptId(  ) {
        List<Dept> depts = baseService.findAllDept(  );
        if( depts == null || depts.size() < 1 )
            responseFail(ResultCode.SYSTEM_ERROR,"System Initialize failed!");

        DeptTreeNodeDTO ret = new DeptTreeNodeDTO();
        return responseOK( ret.buildDeptTree( depts ),"Get All Depts succeed!");
    }

}
