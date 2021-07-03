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
    boolean insertCollection(CollectionDTO collectionDTO);

    boolean deleteCollection(CollectionDTO collectionDTO);

    List<CollectionVO> selectVideoCollection(String userId,int start,int end);

    List<CollectionVO> selectArticleCollection(String userId,int start,int end);

    int count(CollectionDTO collectionDTO);

    int countArticleByUserId(String userId);

    int countVideoByUserId(String userId);
}
