package com.poverty.service;

import com.poverty.entity.Result;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/28 9:10
 */
public interface AdminArticleService {
    /**
     * 获取未审核的文章列表
     *
     * @param current 当前页
     * @param size 每页数据数
     * @return Result
     */
    Result getNotArticleList(int current, int size);

    /**
     * 获取未通过审核的文章
     *
     * @param current 当前页
     * @param size 每页数据数
     * @return Result
     */
    Result getNoArticleList(int current, int size);

    /**
     * 删除所有未通过审核的文章
     *
     * @return Result
     */
    Result deleteNoExaminedArticle();
}
