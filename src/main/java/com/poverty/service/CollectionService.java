package com.poverty.service;

import com.poverty.entity.Result;
import com.poverty.entity.dto.BeLikeDTO;
import com.poverty.entity.dto.CollectionDTO;
import com.poverty.entity.po.Collection;
/**
 * @author Zhu
 * @version 1.0
 * @date Created in 2021/6/30 11:05
 */
public interface CollectionService {
    /**
     * 收藏
     * @param collectionDTO
     * @return Result
     */
    Result collection(CollectionDTO collectionDTO);

    /**
     * 查找文章收藏
     * @param userId
     * @param current
     * @param size
     * @return Result
     */
    Result selectArticleCollection(String userId,int current,int size);

    /**
     * 点赞
     * @param beLikeDTO
     * @return Result
     */
    Result beLike(BeLikeDTO beLikeDTO);

    /**
     * 查找点赞
     * @param id
     * @param userId
     * @return Result
     */
    Result selectBeLike(String id, String userId);

    /**
     * 查找视频收藏
     * @param userId
     * @param current
     * @param size
     * @return Result
     */
    Result selectVideoCollection(String userId,int current,int size);
}
