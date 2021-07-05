package com.poverty.mapper;

import com.poverty.entity.dto.CollectionDTO;
import com.poverty.entity.vo.CollectionVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/23 16:08
 */
@Mapper
public interface CollectionMapper {
    /**
     * 添加收藏
     *
     * @param collectionDTO
     * @return boolean
     */
    boolean insertCollection(CollectionDTO collectionDTO);
    /**
     * 取消收藏
     *
     * @param collectionDTO
     * @return boolean
     */
    boolean deleteCollection(CollectionDTO collectionDTO);

    /**
     * 查看视频收藏列表
     * @param userId
     * @param start
     * @param end
     * @return List<CollectionVO>
     */
    List<CollectionVO> selectVideoCollection(String userId,int start,int end);

    /**
     * 查看文章收藏列表
     * @param userId
     * @param start
     * @param end
     * @return List<CollectionVO>
     */
    List<CollectionVO> selectArticleCollection(String userId,int start,int end);

    /**
     * 查看收藏表中id和user_id的数量
     * @param collectionDTO
     * @return int
     */
    int count(CollectionDTO collectionDTO);

    /**
     *
     * @param userId
     * @return
     */
    int countArticleByUserId(String userId);

    /**
     *
     * @param userId
     * @return
     */
    int countVideoByUserId(String userId);
}
