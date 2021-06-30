package com.poverty.controller;

import com.poverty.entity.Result;
import com.poverty.entity.dto.PostId;
import com.poverty.entity.dto.VideoDTO;
import com.poverty.entity.po.Video;
import com.poverty.entity.vo.VideoVO;
import com.poverty.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
/**
 * @author Zhu
 * @version 1.0
 * @date Created in 2021/6/29 17:35
 */
@RestController("/Video")
@Api(tags = "视频接口")
@CrossOrigin
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
    public Result insertVideo(@RequestPart VideoDTO videoDTO){
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
    public Result deleteVideo(PostId id){
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
    @GetMapping("/selectVideoById/{id}/{userId}")
    @ApiOperation("查询视频")
    public Result selectVideoById(@PathVariable String id,@PathVariable String userId){
       return videoService.selectVideoById(id,userId);
    }


}
