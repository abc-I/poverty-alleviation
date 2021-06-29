package com.poverty.service;

import com.poverty.entity.Result;
import com.poverty.entity.dto.VideoDTO;
import com.poverty.entity.po.Video;

public interface VideoService {
    Result insertVideo(VideoDTO videoDTO);

    Result deleteVideo(String id);

    Result selectAllVideo();

    Result selectVideoById(String id);
}
