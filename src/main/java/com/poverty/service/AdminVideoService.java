package com.poverty.service;

import com.poverty.entity.Result;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/29 12:58
 */
public interface AdminVideoService {
    /**
     * 获取所有未审核的视频
     *
     * @param current 当前页
     * @param size    每页数据数
     * @return Result
     */
    Result getNotVideoList(int current, int size);

    /**
     * 获取审核通过的视频列表
     *
     * @param current 当前页数
     * @param size 每页数据数
     * @return Result
     */
    Result getIsVideoList(int current, int size);

    /**
     * 获取未通过审核的视频列表
     *
     * @param current 当前页
     * @param size 每页数据数
     * @return Result
     */
    Result getNoVideoList(int current, int size);

    /**
     * 通过id获取视频
     *
     * @param id 视频id
     * @return Result
     */
    Result getVideoById(String id);
}
