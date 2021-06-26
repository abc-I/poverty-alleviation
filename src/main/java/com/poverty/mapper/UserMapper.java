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
     * 通过账号获取用户信息
     *
     * @param account 用户账号
     * @return com.poverty.entity.po.User
     */
    User selectOne(String account);

    /**
     * 保存用户信息
     *
     * @param user JSON{"id":"用户id","account":"账号","password":"密码","salt":"加密盐"}
     * @return int
     */
    int insertOne(User user);

    /**
     * 通过账号查询id
     *
     * @param account 账号
     * @return boolean
     */
    String selectIdByAccount(String account);
}
