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
     * @param videoDTO
     * @return
     */
    Result insertVideo(VideoDTO videoDTO);

    /**
     * 删除视频
     * @param id
     * @return Result
     */
    Result deleteVideo(PostId id);

    /**
     * 查询所有视频
     * @param current
     * @param size
     * @return Result
     */
    Result selectAllVideo(int current, int size);

    /**
     * 通过id查询视频
     * @param id
     * @param userId
     * @return  Result
     */
    Result selectVideoById(String id,String userId);
}
