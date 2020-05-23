package com.jinhang.controller;

import com.jinhang.Service.BaseService;
import com.jinhang.result.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Api(value = "数据源", tags = "DataSourceController")
@RestController
@RequestMapping(value = "/v1/")
public class DataSourceController extends AbstractController{
    @Autowired
    private BaseService baseService;

    @ApiOperation(value = "源数据表列表")
    @GetMapping("/tables")
    public HttpResult< List<Map> > listTable() {
        return responseOK( baseService.listTable() );
    }

    @ApiOperation(value = "根据表名查询源数据表结构")
    @GetMapping("/tables/{tableName}/structure")
    public HttpResult< List<Map> > tableInfo(@PathVariable String tableName) {
        return responseOK( baseService.listTableColumn(tableName) );
    }

    @ApiOperation(value = "根据表名查询建表语句")
    @GetMapping("/tables/{tableName}/SQL")
    public HttpResult< List<String> > showCreateTableSQL(@PathVariable String tableName) {
        return responseOK( baseService.showCreateTableSQLLines(tableName) );
    }

    @ApiOperation(value = "根据表名查询源数据表数据")
    @GetMapping("/tables/{tableName}")
    public HttpResult< List<Map> > showTableDatas(@PathVariable String tableName , @RequestParam(required = false) List<String> fields ) {
        return responseOK( baseService.getDatasByFields( null , tableName) );
    }
}
