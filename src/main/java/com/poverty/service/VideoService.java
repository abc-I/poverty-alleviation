package com.poverty.service;

import com.poverty.entity.Result;
import com.poverty.entity.dto.PostId;
import com.poverty.entity.dto.VideoDTO;
import com.poverty.entity.po.Video;
/**
 * @author Zhu
 * @version 1.0
 * @date Created in 2021/6/29 17:38
 */
public interface VideoService {
    /**
     * 添加视频
     */
    Result insertVideo(VideoDTO videoDTO);
    /**
     * 删除视频
     */
    Result deleteVideo(PostId id);
    /**
     * 查询全部视频
     */
    Result selectAllVideo(int current, int size);
    /**
     * 用id查询视频
     */
    Result selectVideoById(String id,String userId);
}
