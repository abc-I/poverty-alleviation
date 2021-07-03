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
     */
    Result collection(CollectionDTO collectionDTO);
    /**
     * 查看文章收藏
     */
    Result selectArticleCollection(String userId,int current,int size);
    /**
     * 点赞
     */
    Result beLike(BeLikeDTO beLikeDTO);
    /**
     * 查看点赞
     */
    Result selectBeLike(String id, String userId);
    /**
     *查看视频收藏
     */
    Result selectVideoCollection(String userId,int current,int size);
}
