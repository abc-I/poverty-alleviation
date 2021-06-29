package com.poverty.mapper;

import com.poverty.entity.dto.VideoDTO;
import com.poverty.entity.po.Video;
import com.poverty.entity.vo.CarouselVO;
import com.poverty.entity.vo.VideoVO;
import com.poverty.entity.vo.VideosVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/23 16:09
 */
@Mapper
public interface VideoMapper {
    int insertVideo(VideoDTO videoDTO);

    int deleteVideo(String id);

    List<VideosVO> selectAllVideo();

    VideoVO seleteVideoById(String id);
}
