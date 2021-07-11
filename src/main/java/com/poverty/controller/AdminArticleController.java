package com.poverty.controller;

import com.poverty.entity.Result;
import com.poverty.entity.dto.PostId;
import com.poverty.service.AdminArticleService;
import com.poverty.service.AdminUserService;
import com.poverty.service.AdminVideoService;
import com.poverty.service.CountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/28 9:07
 */
@RestController
@Api(tags = "管理员接口")
@RequiresRoles(value = {"administrator", "admin"}, logical = Logical.OR)
@RequestMapping("/admin")
@ApiImplicitParams(value = {
        @ApiImplicitParam(name = "JwtToken", value = "JwtToken",
                required = true, paramType = "header", dataType = "String", dataTypeClass = String.class)
})
public class AdminArticleController {

    @Resource
    private AdminArticleService administratorService;

    /**
     * 获取所有没有审核的文章
     *
     * @param current 当前页
     * @param size 每页数据数
     * @return Result
     */
    @ApiOperation("获取所有没有审核的文章")
    @GetMapping("/getNotArticleList/{current}/{size}")
    public Result getNotArticleList(@PathVariable int current,@PathVariable int size) {
        return administratorService.getNotArticleList(current, size);
    }

    /**
     * 获取所有未通过审核的文章
     *
     * @param current 当前页
     * @param size 每页总数
     * @return Result
     */
    @ApiOperation("获取所有未通过审核的文章")
    @GetMapping("/getNoArticleList/{current}/{size}")
    public Result getNoArticleList(@PathVariable int current, @PathVariable int size) {
        return administratorService.getNoArticleList(current, size);
    }

    /**
     * 删除所有未通过审核的文章
     *
     * @return Result
     */
    @ApiOperation("删除所有未通过审核的文章")
    @DeleteMapping("/deleteNoExaminedArticle")
    public Result deleteNoExamined() {
        return administratorService.deleteNoExaminedArticle();
    }



    /**
     * 视频管理
     */
    @Resource
    private AdminVideoService adminVideoService;

    /**
     * 获取所有未审核的视频
     *
     * @param current 当前页
     * @param size    每页数据数
     * @return Result
     */
    @ApiOperation("获取未审核的视频")
    @GetMapping("/getNotVideoList/{current}/{size}")
    public Result getNotVideoList(@PathVariable int current, @PathVariable int size) {
        return adminVideoService.getNotVideoList(current, size);
    }

    /**
     * 获取未通过审核的视频列表
     *
     * @param current 当前页
     * @param size    每页几条数据
     * @return Result
     */
    @ApiOperation("获取未通过审核的视频")
    @GetMapping("/getNoVideoList/{current}/{size}")
    public Result getNoVideoList(@PathVariable int current, @PathVariable int size) {
        return adminVideoService.getNoVideoList(current, size);
    }

    /**
     * 删除未通过审核的视频
     *
     * @return Result
     */
    @ApiOperation("删除未通过审核的视频")
    @DeleteMapping("/deleteNoExaminedVideo")
    public Result deleteNoExaminedVideo() {
        return adminVideoService.deleteNoExaminedVideo();
    }


    /**
     * 文章视频审核
     */
    @Resource
    private CountService countService;

    /**
     * 设置 文章、视频 审核未通过
     *
     * @param id 文章id
     * @return Result
     */
    @ApiOperation("设置 文章、视频 审核未通过")
    @PostMapping("/noExamined")
    public Result noExamineArticle(@RequestBody PostId id) {
        return countService.noExaminedArticle(id);
    }

    /**
     * 设置 文章、视频 审核通过
     *
     * @param id 文章id
     * @return Result
     */
    @ApiOperation("设置 文章、视频 审核通过")
    @PostMapping("/isExamined")
    public Result isExamineArticle(@RequestBody PostId id) {
        return countService.isExaminedArticle(id);
    }



    /**
     * 用户管理
     */

    @Resource
    private AdminUserService adminUserService;

    /**
     * 获取未封号的用户列表
     *
     * @param current 当前页数
     * @param size    每页数据数
     * @return Result
     */
    @ApiOperation("获取未封号的用户")
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
    @ApiOperation("获取被封号的用户")
    @GetMapping("/getLockedUserList/{current}/{size}")
    public Result getLockedUserList(@PathVariable int current, @PathVariable int size) {
        return adminUserService.getLockedUserList(current, size);
    }

    /**
     * 通过用户名查询用户
     *
     * @param username 用户名
     * @return Result
     */
    @ApiOperation("通过用户名查询用户")
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
    @ApiOperation("通过用户账号查询用户")
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
    @ApiOperation("封号或解封")
    @PostMapping("/locked")
    public Result locked(@RequestBody PostId id) {
        return adminUserService.locked(id);
    }
}