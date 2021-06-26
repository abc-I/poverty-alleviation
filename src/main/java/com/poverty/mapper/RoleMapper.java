package com.poverty.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/23 16:08
 */
@Mapper
public interface RoleMapper {

    /**
     * 通过用户id获取权限
     *
     * @param id 用户id
     * @return Set<String>
     */
    Set<String> selectRolesByUserId(String id);
}
