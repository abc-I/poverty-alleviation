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
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/**
 * @author Zhu
 * @version 1.0
 * @date Created in 2021/6/29 17:37
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class VideoServiceImpl implements VideoService {

    @Resource
    private VideoMapper videoMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private CountMapper countMapper;
    @Resource
    private BrowsingHistoryMapper browsingHistoryMapper;
    /**
     * 添加视频
     *
     * @param videoDTO
     * @return Result
     */
    @Override
    public Result insertVideo(VideoDTO videoDTO) {
        String id = UUID.randomUUID().toString().replaceAll("-", "");

        Video video = new Video();
        video.setId(id);
        video.setVideoUrl(videoDTO.getVideoUrl());
        video.setPictureUrl(videoDTO.getPictureUrl());
        video.setAuthorId(videoDTO.getUserId());
        video.setTitle(videoDTO.getTitle());

        int insertVideo = videoMapper.insertVideo(video);

        Count count = new Count();
        count.setId(id);
        count.setBeLiked(0);
        count.setRecommend(0);
        count.setIsExamined(-1);

        countMapper.insertCount(count);
        if(insertVideo>0){
            return Result.result200("添加成功");
        }else{
            return Result.result500("添加失败");
        }

    }
    /**
     * 删除视频
     *
     * @param id 视频id
     * @return Result
     */
    @SneakyThrows
    @Override
    public Result deleteVideo(PostId id) {
        String url = videoMapper.selectVideoUrlById(id.getId());
        int deleteVideo = videoMapper.deleteVideo(id);
        List<String> ids = new ArrayList<>();
        ids.add(id.getId());
        countMapper.deleteByIds(ids);

        if (deleteVideo > 0 && url != null) {

            Runtime runtime = Runtime.getRuntime();
            runtime.exec("rm -rf /home" + url);
            runtime.exec("rm -rf /home" + url);

            return Result.result200("删除成功");
        } else {
            return Result.result500("删除失败");
        }

    }
    /**
     * 查询视频
     *
     * @param current,size
     * @return Result
     */
    @Override
    public Result selectAllVideo(int current, int size) {
        int start = PageUtil.getStart(current, size);
        int end = PageUtil.getEnd(current, size);

        List<VideosVO> videos = videoMapper.selectIsExaminedVideoList(start,end);
        int total = countMapper.countIsExaminedVideo();

        return Result.result200(new Page(total, PageUtil.getPageCount(total, size), videos));
    }


    /**
     * 用id查询视频
     *
     * @param id,userid
     * @return Result
     */
    @Override
    public Result selectVideoById(String id,String userId) {
        VideoVO selectVideoById = videoMapper.selectVideoById(id);
        countMapper.updateRecommendById(id);
        if (userId != null) {
            BrowsingHistory browsingHistory=new BrowsingHistory();
            browsingHistory.setUserId(userId);
            browsingHistory.setId(id);

            browsingHistoryMapper.insertOne(browsingHistory);
        }

        if(selectVideoById!=null){
            return Result.result200(selectVideoById);
        }else {
            return null;
        }
    }


}
