package com.poverty.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.poverty.entity.Result;
import com.poverty.entity.po.Video;
import com.poverty.mapper.VideoMapper;
import com.poverty.service.VideoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class VideoServiceImpl implements VideoService {

    @Resource
    private VideoMapper videoMapper;

    @Override
    public Result insertVideo(Video video) {
       int insertVideo = videoMapper.insertVideo(video);
       if(insertVideo>0){
           return Result.result200("添加成功");
       }else
           return Result.result500("添加失败");
    }

    @Override
    public Result deleteVideo(String id) {
        int deleteVideo = videoMapper.deleteVideo(id);
        if(deleteVideo>0){
            return Result.result200("删除成功");
        }else
            return Result.result500("删除失败");
    }

    @Override
    public Result selectVideo(){
        videoMapper.selectVideo();

    }

}
