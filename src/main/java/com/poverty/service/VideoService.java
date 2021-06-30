package com.poverty.service;

import com.poverty.entity.Result;
import com.poverty.entity.dto.PostId;
import com.poverty.entity.dto.VideoDTO;
import com.poverty.entity.po.Video;

public interface VideoService {
    Result insertVideo(VideoDTO videoDTO);

    Result deleteVideo(PostId id);

    Result selectAllVideo(int current, int size);

    Result selectVideoById(String id,String userId);
}
