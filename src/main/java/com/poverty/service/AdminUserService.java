package com.poverty.service;

import com.poverty.entity.Result;
import com.poverty.entity.dto.PostId;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/29 15:39
 */
public interface AdminUserService {
    /**
     * 获取未封号的用户列表
     *
     * @param current 当前页数
     * @param size    每页数据数
     * @return Result
     */
    Result getUserList(int current, int size);

    /**
     * 获取被封号的用户列表
     *
     * @param current 当前页数
     * @param size 每页数据数
     * @return Result
     */
    Result getLockedUserList(int current, int size);

    /**
     * 通过用户id获取用户
     *
     * @param id 用户id
     * @return Result
     */
    Result getUserById(String id);

    /**
     * 通过用户名查询用户
     *
     * @param username 用户名
     * @return Result
     */
    Result searchUserByName(String username);

    /**
     * 通过用户id封号
     *
     * @param id JSON{"id":"用户id"}
     * @return Result
     */
    Result locked(PostId id);

    /**
     * 通过用户账号查询用户
     *
     * @param account 用户账号
     * @return Result
     */
    Result searchUserByAccount(String account);
}
