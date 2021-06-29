package com.poverty.service;

import com.poverty.entity.Result;
import com.poverty.entity.po.Video;

public interface VideoService {
    Result insertVideo(Video video);

    Result deleteVideo(String id);

    Result selectVideo(Video video);
}
