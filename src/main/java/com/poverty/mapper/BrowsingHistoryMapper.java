package com.poverty.mapper;

import com.poverty.entity.po.BrowsingHistory;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/23 16:08
 */
@Mapper
public interface BrowsingHistoryMapper {
    void insertOne(BrowsingHistory browsingHistory);
}
