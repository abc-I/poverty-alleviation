package com.poverty.service.impl;

import com.poverty.entity.Result;
import com.poverty.entity.dto.PostId;
import com.poverty.entity.vo.UsersVO;
import com.poverty.mapper.UserMapper;
import com.poverty.mapper.UserRoleMapper;
import com.poverty.service.AdministratorService;
import com.poverty.util.PageUtil;
import com.poverty.entity.vo.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/29 16:42
 */
@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private UserMapper userMapper;

    /**
     * 通过用户id设置管理员
     *
     * @param id JSON{"id":"用户id"}
     * @return Result
     */
    @Override
    public Result setAdmin(PostId id) {
        return Result.result200(userRoleMapper.updateAdminRoleById(id));
    }

    /**
     * 通过用户id取消管理员
     *
     * @param id JSON{"id":"用户id"}
     * @return Result
     */
    @Override
    public Result setUser(PostId id) {
        return Result.result200(userRoleMapper.updateUserRoleById(id));
    }

    /**
     * 获取管理员账号
     *
     * @param current 当前页数
     * @param size 每页几条数据
     * @return Result
     */
    @Override
    public Result getAdmin(int current, int size) {
        int start = PageUtil.getStart(current, size);
        int end = PageUtil.getEnd(current, size);

        List<UsersVO> users = userMapper.selectAdminList(start, end);
        int total = userRoleMapper.countAdmin();
        return Result.result200(new Page(total, PageUtil.getPageCount(total, size), users));
    }
}
