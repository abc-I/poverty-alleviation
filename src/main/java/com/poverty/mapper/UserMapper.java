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
    /**
     * 通过账号获取id
     *
     * @param account 账号
     * @return String
     */
    String selectIdByAccount(String account);

    /**
     * 通过id获取用户信息
     *
     * @param id 用户id
     * @return com.poverty.entity.po.User
     */
    User selectOne(String id);

    /**
     * 保存用户信息
     *
     * @param user JSON{"id":"用户id","account":"账号","password":"密码","salt":"加密盐"}
     * @return int
     */
    int insertOne(User user);
}
