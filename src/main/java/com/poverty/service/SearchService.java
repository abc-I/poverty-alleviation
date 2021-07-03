package com.poverty.service;

import com.poverty.entity.Result;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/7/3 17:34
 */
public interface SearchService {
    /**
     * 搜索title的文章
     *
     * @param userId 用户id
     * @param title title的匹配
     * @param current 当前页
     * @param size 每页总数
     * @return Result
     */
    Result searchArticleByTitle(String userId,String title, int current, int size);

    /**
     * 搜索title的视频
     *
     * @param userId 用户id
     * @param title title的匹配
     * @param current 当前页
     * @param size 每页总数
     * @return Result
     */
    Result searchVideoByTitle(String userId, String title, int current, int size);

    /**
     * 查询搜索记录
     *
     * @param userId 用户id
     * @return Result
     */
    Result searchRecords(String userId);
}
