package com.poverty.service;

import com.poverty.entity.Result;
import com.poverty.entity.dto.PostId;
/**
 * @author Zhu
 * @version 1.0
 * @date Created in 2021/6/28 10:38
 */

public interface BrowsingHistoryService {
    /**
     * 查找文章历史记录
     * @param userId
     * @return Result
     */
    Result selectArticleBrowsingHistory(PostId userId);

    /**
     * 查找视频历史记录
     * @param userId
     * @return Result
     */
    Result selectVideoBrowsingHistory(PostId userId);

    /**
     * 删除文章历史记录
     * @param userId
     * @return Result
     */
    Result deleteArticleBrowsingHistory(PostId userId);

    /**
     * 删除视频历史记录
     * @param userId
     * @return Result
     */
    Result deleteVideoBrowsingHistory(PostId userId);
}
