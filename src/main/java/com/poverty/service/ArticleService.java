package com.poverty.service;

import com.poverty.entity.Result;
import com.poverty.entity.dto.ArticleDTO;
import com.poverty.entity.dto.PostId;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/7/1 8:47
 */
public interface ArticleService {
    /**
     * 获取文章列表
     *
     * @param current 当前页
     * @param size 每页数据量
     * @return Result
     */
    Result getArticleList(int current, int size);

    /**
     * 获取文章
     *
     * @param id 文章id
     * @param userId 用户id
     * @return Result
     */
    Result getArticleById(String id,String userId);

    /**
     * 保存文章
     *
     * @param articleDTO JSON{"title":"标题","articleUrl":"文章html的url","text":"文章部分内容","userId":"用户id"}
     * @return Result
     */
    Result insertArticle(ArticleDTO articleDTO) throws Exception;

    /**
     * 通过文章id删除文章
     *
     * @param id JSON{"id":"文章id"}
     * @return Result
     */
    Result deleteArticleById(PostId id) throws Exception;
}
