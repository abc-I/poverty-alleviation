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
        /**
         * 添加视频
         * @param videoDTO
         * @return int
         */
        int insertVideo(Video videoDTO);

        /**
         * 删除视频
         * @param id
         * @return int
         */
        int deleteVideo(PostId id);

        /**
         * 根据id查找视频
         * @param id
         * @return  VideoVO
         */
        VideoVO selectVideoById(String id);

        /**
         * 查找通过审核的视频
         * @param start
         * @param end
         * @return List<VideosVO>
         */
        List<VideosVO> selectIsExaminedVideoList(int start, int end);

        /**
         * 查找没有审核的视频
         * @param start
         * @param end
         * @return List<VideosVO>
         */
        List<VideosVO> selectNoExaminedVideoList(int start, int end);
        /**
         * 查找没有通过审核的视频
         * @param start
         * @param end
         * @return List<VideosVO>
         */
        List<VideosVO> selectNotExaminedVideoList(int start, int end);
        /**
         * 通过id查视频
         * @param id
         * @return String
         */
        String selectVideoUrlById(String id);

        /**
         * 通过标题查视频
         * @param title
         * @param start
         * @param end
         * @return List<VideosVO>
         */
        List<VideosVO> selectVideoByTitle(String title, int start, int end);
        /**
         *  通过标题显示视频条数
         * @param title
         * @return int
         */
        int countByTitle(String title);
}
