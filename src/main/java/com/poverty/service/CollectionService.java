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
    Result insertCollection(CollectionDTO collectionDTO);
    /**
     * 取消收藏
     */
    Result deleteCollection(CollectionDTO collectionDTO);
    /**
     * 查看收藏
     */
    Result selectCollection(String userId);
    /**
     * 点赞
     */
    Result beLike(BeLikeDTO beLikeDTO);
    /**
     * 查看点赞
     */
    Result selectBeLike(String id, String userId);
}
