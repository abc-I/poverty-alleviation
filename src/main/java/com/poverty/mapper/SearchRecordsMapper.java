package com.poverty.mapper;

import com.poverty.entity.dto.PostId;
import com.poverty.entity.po.SearchRecords;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/23 16:08
 */
@Mapper
public interface SearchRecordsMapper {
    /**
     * 通过用户id查询搜索记录
     *
     * @param userId 用户id
     * @return List<String>
     */
    List<String> selectSearchRecords(String userId);

    /**
     * 保存搜索记录
     *
     * @param searchRecords JSON{"userId":"用户id","searchContent":"搜索内容"}
     */
    void insertOne(SearchRecords searchRecords);

    /**
     * 通过id删除搜索记录
     *
     * @param id JSON{"id":"用户id"}
     * @return boolean
     */
    boolean deleteByUserId(PostId id);

    /**
     * 更新创建时间
     *
     * @param searchRecords JSON{"userId":"用户id","searchContent":"搜索内容"}
     */
    void updateCreateTime(SearchRecords searchRecords);
}
