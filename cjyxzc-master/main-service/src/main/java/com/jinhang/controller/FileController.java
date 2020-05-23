package com.jinhang.controller;

import com.jinhang.Service.BaseService;
import com.jinhang.result.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(value = "", tags = "FileController")
@RestController
@RequestMapping(value = "/v1/")
public class FileController extends AbstractController {
    @Autowired
    private BaseService baseService;

    @ApiOperation(value = "上传文件", notes = "")
    @PostMapping(value = "/Upload")
    public HttpResult< String > upLoadIMG(@RequestParam("file") MultipartFile srcFile) {
        return responseOK( baseService.uploadFile(srcFile) , "");
    }
}
