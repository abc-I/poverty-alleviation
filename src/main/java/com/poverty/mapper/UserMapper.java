package com.poverty.mapper;

import com.poverty.entity.po.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/23 14:16
 */
@Mapper
public interface UserMapper {
    String selectIdByAccount(String account);

    User selectOne(String id);

    int insertOne(User user);
}
