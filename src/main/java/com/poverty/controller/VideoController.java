package com.poverty.controller;

import com.poverty.entity.Result;
import com.poverty.entity.po.Video;
import com.poverty.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController("/Video")
@Api(tags = "视频接口")
@CrossOrigin
public class VideoController {
    @Resource
    private VideoService videoService;

    @PostMapping("/insetVideo")
    @ApiOperation("添加视频")
    public Result insertVideo(Video video){
        return videoService.insertVideo(video);
    }

    @DeleteMapping("/deleteVideo")
    @ApiOperation("删除视频")
    public Result deleteVideo(String id){
        return videoService.deleteVideo(id);
    }

    @PatchMapping(/"selectVideo")
    @ApiOperation("修改轮播图")
    public Result selectVideo(Video video){
        return videoService.selectVideo(video);
    }

}
