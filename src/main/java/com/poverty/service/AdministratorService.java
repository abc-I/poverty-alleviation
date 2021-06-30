package com.poverty.service;

import com.poverty.entity.Result;
import com.poverty.entity.dto.PostId;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/29 16:42
 */
public interface AdministratorService {

    /**
     * 通过用户账号设置管理员
     *
     * @param id JSON{"id":"用户账号"}
     * @return Result
     */
    Result setAdmin(PostId id);

    /**
     * 通过用户id取消管理员
     *
     * @param id JSON{"id":"用户id"}
     * @return Result
     */
    Result setUser(PostId id);

    /**
     * 获取管理员账号
     *
     * @param current 当前页数
     * @param size 每页几条数据
     * @return Result
     */
    Result getAdmin(int current, int size);
}
