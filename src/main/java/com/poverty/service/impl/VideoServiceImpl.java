package com.poverty.service.impl;

import com.poverty.entity.Result;
import com.poverty.entity.dto.PostId;
import com.poverty.entity.dto.VideoDTO;
import com.poverty.entity.po.BrowsingHistory;
import com.poverty.entity.po.Count;
import com.poverty.entity.po.Video;
import com.poverty.entity.vo.VideoVO;
import com.poverty.entity.vo.Page;
import com.poverty.entity.vo.VideosVO;
import com.poverty.mapper.BrowsingHistoryMapper;
import com.poverty.mapper.CountMapper;
import com.poverty.mapper.UserMapper;
import com.poverty.mapper.VideoMapper;
import com.poverty.service.VideoService;
import com.poverty.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class VideoServiceImpl implements VideoService {

    @Resource
    private VideoMapper videoMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private CountMapper countMapper;
    @Resource
    private BrowsingHistoryMapper browsingHistoryMapper;
    @Override
    public Result insertVideo(VideoDTO videoDTO) {
       String id= UUID.randomUUID().toString().replace("-","");
       String userId = userMapper.selectIdByAccount(videoDTO.getAccount());

       Video video = new Video();
       video.setId(id);
       video.setVideoUrl(videoDTO.getVideoUrl());
       video.setPictureUrl(videoDTO.getPictureUrl());
       video.setAuthorId(userId);
       video.setTitel(videoDTO.getTitel());

       int insertVideo = videoMapper.insertVideo(video);

       Count count =new Count();
       count.setId(id);

       countMapper.insertCount(count);
       if(insertVideo>0){
           return Result.result200("添加成功");
       }else{
           return Result.result500("添加失败");
       }

    }

    @Override
    public Result deleteVideo(PostId id) {
        int deleteVideo = videoMapper.deleteVideo(id);
        List<String> ids = new ArrayList<>();
        ids.add(id.getId());
        countMapper.deleteByIds(ids);

        if(deleteVideo>0){
            return Result.result200("删除成功");
        }else{
            return Result.result500("删除失败");
        }

    }

    @Override
    public Result selectAllVideo(int current, int size) {
        int start = PageUtil.getStart(current, size);
        int end = PageUtil.getEnd(current, size);

        List<VideosVO> videos = videoMapper.selectIsExaminedVideoList(start,end);
        int total = countMapper.countIsExaminedVideo();

        return Result.result200(new Page(total, PageUtil.getPageCount(total, size), videos));
    }



    @Override
    public Result selectVideoById(String id,String userId) {
        VideoVO selectVideoById = videoMapper.selectVideoById(id);
        countMapper.updateRecommendById(id);

        BrowsingHistory browsingHistory=new BrowsingHistory();
        browsingHistory.setUserId(userId);
        browsingHistory.setVideoId(id);

        browsingHistoryMapper.insertOne(browsingHistory);
        if(selectVideoById!=null){
            return Result.result200(selectVideoById);
        }else {
            return null;
        }
    }


}
