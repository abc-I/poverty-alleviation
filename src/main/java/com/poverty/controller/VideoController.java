package com.poverty.controller;

import com.poverty.entity.Result;
import com.poverty.entity.dto.PostId;
import com.poverty.entity.dto.VideoDTO;
import com.poverty.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
/**
 * @author Zhu
 * @version 1.0
 * @date Created in 2021/6/29 17:35
 */
@RestController
@Api(tags = "视频接口")
@RequestMapping("/video")
public class VideoController {

    @Resource
    private VideoService videoService;

    /**
     * 添加视频
     *
     * @param videoDTO
     * @return Result
     */
    @PostMapping("/insetVideo")
    @ApiOperation("添加视频")
    @RequiresRoles(value = {"user","admin","administrator"}, logical = Logical.OR)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "JwtToken", value = "JwtToken",
                    required = true, paramType = "header", dataType = "String", dataTypeClass = String.class)
    })
    public Result insertVideo(@RequestBody VideoDTO videoDTO){
        return videoService.insertVideo(videoDTO);
    }
    /**
     * 删除视频
     *
     * @param id 视频Id
     * @return Result
     */
    @DeleteMapping("/deleteVideo")
    @ApiOperation("删除视频")
    @RequiresRoles(value = {"user","admin","administrator"}, logical = Logical.OR)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "JwtToken", value = "JwtToken",
                    required = true, paramType = "header", dataType = "String", dataTypeClass = String.class)
    })
    public Result deleteVideo(@RequestBody PostId id){
        return videoService.deleteVideo(id);
    }
    /**
     * 查询所有视频
     *
     * @return Result
     */
    @GetMapping("/selectAllVideo/{current}/{size}")
    @ApiOperation("查询所有视频")
    public Result selectAllVideo(@PathVariable int current,@PathVariable int size){
        return videoService.selectAllVideo(current, size);
    }
    /**
     * 查询轮播图
     *
     * @param id 轮播图id
     * @return Result
     */
    @GetMapping(value = {"/selectVideoById/{id}/{userId}","/selectVideoById/{id}"})
    @ApiOperation("查询视频")
    public Result selectVideoById(@PathVariable String id,@PathVariable(required = false) String userId){
       return videoService.selectVideoById(id,userId);
    }
}
