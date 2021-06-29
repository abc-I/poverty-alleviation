package com.poverty.service.impl;

import com.poverty.entity.Result;
import com.poverty.entity.dto.VideoDTO;
import com.poverty.entity.po.Video;
import com.poverty.entity.vo.VideoVO;
import com.poverty.entity.vo.VideosVO;
import com.poverty.mapper.VideoMapper;
import com.poverty.service.VideoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class VideoServiceImpl implements VideoService {

    @Resource
    private VideoMapper videoMapper;

    @Override
    public Result insertVideo(VideoDTO videoDTO) {
       String id= UUID.randomUUID().toString().replace("-","");
       videoDTO.setId(id);
       int insertVideo = videoMapper.insertVideo(videoDTO);
       if(insertVideo>0){
           return Result.result200("添加成功");
       }else{
           return Result.result500("添加失败");
       }

    }

    @Override
    public Result deleteVideo(String id) {
        int deleteVideo = videoMapper.deleteVideo(id);
        if(deleteVideo>0){
            return Result.result200("删除成功");
        }else{
            return Result.result500("删除失败");
        }

    }

    @Override
    public Result selectAllVideo() {
        List<VideosVO> videosVOS = videoMapper.selectAllVideo();
        return Result.result200(videosVOS);
    }

    @Override
    public Result selectVideoById(String id) {
        VideoVO seleteVideoById = videoMapper.seleteVideoById(id);
        if(seleteVideoById!=null){
            return Result.result200(seleteVideoById);
        }else {
            return null;
        }
    }


}
