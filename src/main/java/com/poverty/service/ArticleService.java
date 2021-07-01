package com.poverty.service;

import com.poverty.entity.Result;

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
}
