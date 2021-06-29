package com.poverty.service.impl;

import com.poverty.entity.Result;
import com.poverty.entity.dto.PostId;
import com.poverty.entity.vo.UsersVO;
import com.poverty.mapper.UserMapper;
import com.poverty.service.AdminUserService;
import com.poverty.util.PageUtil;
import org.bearer.entity.vo.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/29 15:39
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 获取未封号的用户列表
     *
     * @param current 当前页数
     * @param size    每页数据数
     * @return Result
     */
    @Override
    public Result getUserList(int current, int size) {
        int start = PageUtil.getStart(current, size);
        int end = PageUtil.getEnd(current, size);

        List<UsersVO> users = userMapper.selectNotLockedUserList(start, end);
        int total = userMapper.countNotLockedUser();
        return Result.result200(new Page(total, PageUtil.getPageCount(total, size), users));
    }

    /**
     * 获取被封号的用户列表
     *
     * @param current 当前页数
     * @param size 每页数据数
     * @return Result
     */
    @Override
    public Result getLockedUserList(int current, int size) {
        int start = PageUtil.getStart(current, size);
        int end = PageUtil.getEnd(current, size);

        List<UsersVO> users = userMapper.selectIsLockedUserList(start, end);
        int total = userMapper.countIsLockedUser();

        return Result.result200(new Page(total, PageUtil.getPageCount(total, size), users));
    }

    /**
     * 通过用户id获取用户
     *
     * @param id 用户id
     * @return Result
     */
    @Override
    public Result getUserById(String id) {
        UsersVO userVO = userMapper.selectById(id);
        return Result.result200(userVO);
    }

    /**
     * 通过用户名查询用户
     *
     * @param username 用户名
     * @return Result
     */
    @Override
    public Result searchUser(String username) {
        List<UsersVO> usersVO = userMapper.selectByUsername(username);

        return Result.result200(usersVO);
    }

    /**
     * 通过用户id封号
     *
     * @param id JSON{"id":"用户id"}
     * @return Result
     */
    @Override
    public Result locked(PostId id) {
        // 如果为true，是封号状态
        if (userMapper.selectLockedById(id)) {
            // 解封
            return Result.result200(userMapper.updateNotLockedById(id));
        } else {
            // 封号
            return Result.result200(userMapper.updateLockedById(id));
        }
    }
}
