package com.poverty.mapper;

import com.poverty.entity.dto.PostId;
import com.poverty.entity.po.UserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/23 16:09
 */
@Mapper
public interface UserRoleMapper {
    /**
     * 保存权限信息
     *
     * @param userRole JSON{"userId":"用户id","roleId":"权限id"}
     * @return int
     */
    int insertOne(UserRole userRole);

    /**
     * 通过用户账号设置管理员权限
     *
     * @param id 用户账号
     * @return boolean
     */
    boolean updateAdminRoleById(PostId id);

    /**
     * 取消管理员权限
     *
     * @param id 用户id
     * @return boolean
     */
    boolean updateUserRoleById(PostId id);

    /**
     * 统计管理员数
     *
     * @return int
     */
    int countAdmin();
}
