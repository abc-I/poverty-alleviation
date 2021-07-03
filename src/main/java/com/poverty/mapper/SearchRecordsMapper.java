package com.poverty.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/23 16:08
 */
@Mapper
public interface SearchRecordsMapper {
    boolean selectSearchRecords();
}
