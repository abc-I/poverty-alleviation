package com.poverty.mapper;

import com.poverty.entity.Result;
import com.poverty.entity.dto.PostId;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/23 16:08
 */
@Mapper
public interface CountMapper {
    /**
     * 通过id删除信息
     *
     * @param ids id
     * @return boolean
     */
    boolean deleteByIds(List<String> ids);

    /**
     * 通过id设置 is_examined字段为 1（审核通过）
     *
     * @param id 文章id
     * @return boolean
     */
    boolean updateIsExaminedById(PostId id);

    /**
     * 通过文章id设置 is_examined字段为0（审核未通过）
     *
     * @param id 文章id
     * @return boolean
     */
    boolean updateNoExaminedById(PostId id);

    /**
     * 通过所有未审核的文章数
     *
     * @return int
     */
    int countNotExaminedArticle();

    /**
     * 统计所有通过审核的文章数
     *
     * @return int
     */
    int countIsExaminedArticle();

    /**
     * 统计所有未通过审核的文章数
     *
     * @return int
     */
    int countNoExaminedArticle();

    /**
     * 获取所有未通过审核的的文章id
     *
     * @return List<String>
     */
    List<String> selectArticleIdsByNoExamined();

    /**
     * 统计所有未审核的视频数
     *
     * @return int
     */
    int countNotExaminedVideo();

    /**
     * 统计所有通过审核的视频数
     *
     * @return int
     */
    int countIsExaminedVideo();

    /**
     * 统计未通过审核的视频数
     *
     * @return int
     */
    int countNoExaminedVideo();
}
