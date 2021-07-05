package com.poverty.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import com.poverty.entity.Result;
import com.poverty.service.UploadService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/18 15:02
 */
@Api(tags = "上传接口")
@RestController
@RequiresRoles(value = {"user", "admin","administrator"}, logical = Logical.OR)
@RequestMapping("/upload")
@ApiImplicitParams(value = {
        @ApiImplicitParam(name = "JwtToken", value = "JwtToken",
                required = true, paramType = "header", dataType = "String", dataTypeClass = String.class)
})
public class UploadController {

    @Resource
    private UploadService uploadService;

    /**
     * 上传图片
     *
     * @param file 文件保存对象
     * @return org.bearer.entity.Result
     */
    @ApiOperation("上传图片")
    @PostMapping("/uploadPictureFile")
    public Result uploadPictureFile(@RequestPart MultipartFile file) {
        String url = uploadService.uploadPicture(file);
        return result(url);
    }

    /**
     * 上传视频
     *
     * @param file 文件保存对象
     * @return org.bearer.entity.Result
     */
    @ApiOperation("上传视频")
    @PostMapping("/uploadVideoFile")
    public Result uploadVideoFile(@RequestPart MultipartFile file) {
        String url = uploadService.uploadVideo(file);
        return result(url);
    }

    /**
     * 上传docx
     *
     * @param file 文件保存对象
     * @return org.bearer.entity.Result
     */
    @ApiOperation("上传docx")
    @PostMapping("/uploadDocx")
    public Result uploadDocx(@RequestPart MultipartFile file) {
        String url = uploadService.uploadDocx(file);
        return Result.result200(url);
    }

    /**
     * 判读url
     *
     * @param url url
     * @return org.bearer.entity.Result
     */
    @ApiOperation("判读url")
    private Result result(String url) {
        if (url != null) {
            return Result.result200(url);
        } else {
            return Result.result500("Fail：上传失败！");
        }
    }
}
