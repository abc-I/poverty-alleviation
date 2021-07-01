package com.poverty.mapper;

import com.poverty.entity.dto.CollectionDTO;
import com.poverty.entity.po.Collection;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/23 16:08
 */
@Mapper
public interface CollectionMapper {
    boolean insertCollection(CollectionDTO collectionDTO);

    boolean deleteCollection(CollectionDTO collectionDTO);

    boolean selectCollection(Collection userId);
}
