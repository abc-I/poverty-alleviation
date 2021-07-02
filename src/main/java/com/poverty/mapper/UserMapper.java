package com.poverty.mapper;

import com.poverty.entity.dto.PostId;
import com.poverty.entity.vo.UsersVO;
import com.poverty.entity.po.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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

    /**
     * 获取没有封号的用户
     *
     * @param start 第一个index
     * @param end 最后一个index
     * @return List<UsersVO>
     */
    List<UsersVO> selectNotLockedUserList(int start, int end);

    /**
     * 统计没有封号的用户数
     *
     * @return int
     */
    int countNotLockedUser();

    /**
     * 获取封号的用户
     *
     * @param start 第一个index
     * @param end 第二个index
     * @return List<UserVO>
     */
    List<UsersVO> selectIsLockedUserList(int start, int end);

    /**
     * 统计封号的用户
     *
     * @return int
     */
    int countIsLockedUser();

    /**
     * 通过id获取用户
     *
     * @param id 用户id
     * @return UsersVO
     */
    User selectById(String id);

    /**
     * 通过用户名查询用户
     *
     * @param username 用户名
     * @return List<UsersVO>
     */
    List<UsersVO> selectByUsername(String username);

    /**
     * 查询封号状态
     *
     * @param id JSON{"id":"用户id"}
     * @return boolean
     */
    boolean selectLockedById(PostId id);

    /**
     * 通过id解封账号
     *
     * @param id JSON{"id":"用户id"}
     * @return boolean
     */
    boolean updateNotLockedById(PostId id);

    /**
     * 通过id封号
     *
     * @param id JSON{"id":"用户id"}
     * @return boolean
     */
    boolean updateLockedById(PostId id);

    /**
     * 获取管理员列表
     *
     * @param start 第一个index
     * @param end 最后一个index
     * @return List<UsersVO>
     */
    List<UsersVO> selectAdminList(int start, int end);

    /**
     * 通过账号查询用户
     *
     * @param account 账号
     * @return UserVO
     */
    UsersVO selectByAccount(String account);
}
