package com.yupi.yupao.controller;

import com.yupi.yupao.common.BaseResponse;
import com.yupi.yupao.common.ResultUtils;
import com.yupi.yupao.service.OssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Api(description = "阿里云文件管理")
//@CrossOrigin(origins = {"http://101.43.134.210:8080/api"})
@RestController
@RequestMapping("/file")
public class OssController {
    @Resource
    private OssService ossService;
    @ApiOperation(value = "文件上传")
    @PostMapping("/upload")
    public BaseResponse<String> uploadOssFile(@RequestParam(required = false) MultipartFile file) {
        //获取上传的文件
        if (file.isEmpty()) {
            return null;
        }
        //返回上传到oss的路径
        String url = ossService.uploadFileAvatar(file);
        //返回r对象
        return ResultUtils.success(url);
    }
}
