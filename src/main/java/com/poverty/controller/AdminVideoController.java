package com.poverty.controller;

import com.poverty.entity.Result;
import com.poverty.service.AdminVideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/29 11:16
 */
@Api(tags = "管理员接口")
@RestController
@RequiresRoles(value = {"administrator", "admin"}, logical = Logical.OR)
@RequestMapping("/admin")
@ApiImplicitParams(value = {
        @ApiImplicitParam(name = "JwtToken", value = "JwtToken",
                required = true, paramType = "header", dataType = "String", dataTypeClass = String.class)
})
public class AdminVideoController {

    @Resource
    private AdminVideoService adminVideoService;

    /**
     * 获取所有未审核的视频
     *
     * @param current 当前页
     * @param size    每页数据数
     * @return Result
     */
    @ApiOperation("获取未审核的视频")
    @GetMapping("/getNotVideoList/{current}/{size}")
    public Result getNotVideoList(@PathVariable int current, @PathVariable int size) {
        return adminVideoService.getNotVideoList(current, size);
    }

    /**
     * 获取未通过审核的视频列表
     *
     * @param current 当前页
     * @param size    每页几条数据
     * @return Result
     */
    @ApiOperation("获取未通过审核的视频")
    @GetMapping("/getNoVideoList/{current}/{size}")
    public Result getNoVideoList(@PathVariable int current, @PathVariable int size) {
        return adminVideoService.getNoVideoList(current, size);
    }

    /**
     * 删除未通过审核的视频
     *
     * @return Result
     */
    @ApiOperation("删除未通过审核的视频")
    @DeleteMapping("/deleteNoExaminedVideo")
    public Result deleteNoExaminedVideo() {
        return adminVideoService.deleteNoExaminedVideo();
    }
}
