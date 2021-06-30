package com.poverty.controller;

import com.poverty.entity.Result;
import com.poverty.entity.dto.PostId;
import com.poverty.service.AdminUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/29 14:42
 */
@RestController
@RequiresRoles(value = {"administrator", "admin"}, logical = Logical.OR)
@RequestMapping("/admin")
@ApiImplicitParams(value = {
        @ApiImplicitParam(name = "JwtToken", value = "JwtToken",
                required = true, paramType = "header", dataType = "String", dataTypeClass = String.class)
})
public class AdminUserController {

    @Resource
    private AdminUserService adminUserService;

    /**
     * 获取未封号的用户列表
     *
     * @param current 当前页数
     * @param size    每页数据数
     * @return Result
     */
    @GetMapping("/getUserList/{current}/{size}")
    public Result getUserList(@PathVariable int current, @PathVariable int size) {
        return adminUserService.getUserList(current, size);
    }

    /**
     * 获取被封号的用户列表
     *
     * @param current 当前页
     * @param size    每页数据数
     * @return Result
     */
    @GetMapping("/getLockedUserList/{current}/{size}")
    public Result getLockedUserList(@PathVariable int current, @PathVariable int size) {
        return adminUserService.getLockedUserList(current, size);
    }

    /**
     * 通过id获取用户
     *
     * @param id 用户id
     * @return Result
     */
    @GetMapping("/getUserById/{id}")
    public Result getUserById(@PathVariable String id) {
        return adminUserService.getUserById(id);
    }

    /**
     * 通过用户名查询用户
     *
     * @param username 用户名
     * @return Result
     */
    @GetMapping("/searchUserByName/{username}")
    public Result searchUser(@PathVariable String username) {
        return adminUserService.searchUserByName(username);
    }

    /**
     * 通过用户账号查询用户
     *
     * @param account 账号
     * @return Result
     */
    @GetMapping("/searchUserByAccount/{account}")
    public Result searchUserByAccount(@PathVariable String account) {
        return adminUserService.searchUserByAccount(account);
    }

    /**
     * 通过用户id封号或解封
     *
     * @param id JSON{"id":"用户id"}
     * @return Result
     */
    @PostMapping("/locked")
    public Result locked(PostId id) {
        return adminUserService.locked(id);
    }
}
