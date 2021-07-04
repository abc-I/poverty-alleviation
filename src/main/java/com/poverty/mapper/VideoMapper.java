package com.poverty.mapper;

import com.poverty.entity.dto.PostId;
import com.poverty.entity.dto.VideoDTO;
import com.poverty.entity.po.Video;
import com.poverty.entity.vo.ArticlesVO;
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
    int insertVideo(Video videoDTO);

    int deleteVideo(PostId id);

    VideoVO selectVideoById(String id);

    List<VideosVO> selectIsExaminedVideoList(int start, int end);

    List<VideosVO> selectNoExaminedVideoList(int start, int end);

    List<VideosVO> selectNotExaminedVideoList(int start, int end);

    String selectVideoUrlById(String id);

    List<VideosVO> selectVideoByTitle(String title, int start, int end);

    int countByTitle(String title);
}
