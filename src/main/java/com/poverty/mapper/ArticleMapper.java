package com.poverty.mapper;

import com.poverty.entity.vo.ArticleVO;
import com.poverty.entity.vo.ArticlesVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/23 16:03
 */
@Mapper
public interface ArticleMapper {
    /**
     * 获取未审核的文章列表
     *
     * @param start 第一个index
     * @param end 最后一个index
     * @return List<ArticlesVO>
     */
    List<ArticlesVO> selectNotExaminedArticleList(int start, int end);

    /**
     * 获取审核通过的文章列表
     *
     * @param start 第一个index
     * @param end 最后一个index
     * @return List<ArticlesVO>
     */
    List<ArticlesVO> selectIsExaminedArticleList(int start, int end);

    /**
     * 通过文章id删除文章
     *
     * @param ids id列表
     * @return boolean
     */
    boolean deleteArticleByIds(List<String> ids);

    /**
     * 获取审核未通过的文章列表
     *
     * @param start 第一个index
     * @param end 最后一个index
     * @return List<ArticleVO>
     */
    List<ArticlesVO> selectNoExaminedArticleList(int start, int end);

    /**
     * 通过id获取文章
     *
     * @param id 文章id
     * @return ArticleVO
     */
    ArticleVO getArticleById(String id);
}
