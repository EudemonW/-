package com.jinhang.controller;

import com.jinhang.Service.BaseService;
import com.jinhang.Service.MapService;
import com.jinhang.Service.MapInstanceService;

import com.jinhang.process.DTO.RelMetaAndTableFiledDTO;
import com.jinhang.process.model.MapInfo;
import com.jinhang.utils.StringHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(value = "", tags = "MapInsController")
@RestController
@RequestMapping(value = "/v1/mapinstances")
public class MapInsController extends AbstractController{
    @Autowired
    private MapService mapService;
    @Autowired
    private BaseService baseService;
    @Autowired
    private MapInstanceService mapInstanceService;

    @ApiOperation(value = "测试执行映射任务")
    @PostMapping("/mapinstances")
    public void testExcuteMapInstance( @RequestBody List<String> mapIds ) {
        mapInstanceService.MapInstanceRun( mapIds );
    }

    @ApiOperation(value = "测试执行映射任务")
    @GetMapping("/mapinstances")
    public void testExcuteMapInstance( @RequestParam String processId ) {
        List<MapInfo> mapInfos = mapService.findAllMapInfosByProcessId( processId );
        mapInstanceService.MapInstanceRun(  MapInfo.GetIds( mapInfos ) );
    }
}
