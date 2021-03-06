package com.poverty.controller;

import com.poverty.entity.Result;
import com.poverty.entity.dto.PostId;
import com.poverty.service.SearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author Zhu
 * @version 1.0
 * @date Created in 2021/7/1 10:40
 */
@Api(tags = "搜索接口")
@RestController
public class SearchController {

    @Resource
    private SearchService searchService;

    /**
     * 搜索title的文章
     *
     * @param userId  用户id
     * @param title   title的匹配
     * @param current 当前页
     * @param size    每页总数
     * @return Result
     */
    @ApiOperation("搜索title文章")
    @GetMapping(value={
            "/searchArticleByTitle/{title}/{current}/{size}/{userId}",
            "/searchArticleByTitle/{title}/{current}/{size}"
    })
    public Result searchArticleByTitle(
            @PathVariable(required = false) String userId, @PathVariable String title,
            @PathVariable int current, @PathVariable int size) {
        return searchService.searchArticleByTitle(userId, title, current, size);
    }

    /**
     * 搜索title的视频
     *
     * @param userId  用户id
     * @param title   title的匹配
     * @param current 当前页
     * @param size    每页总数
     * @return Result
     */
    @ApiOperation("搜索title的视频")
    @GetMapping(value = {
            "/searchVideoByTitle/{title}/{current}/{size}/{userId}",
            "/searchVideoByTitle/{title}/{current}/{size}"
    })
    public Result searchVideoByTitle(
            @PathVariable(required = false) String userId, @PathVariable String title,
            @PathVariable int current, @PathVariable int size) {
        return searchService.searchVideoByTitle(userId, title, current, size);
    }

    /**
     * 查询搜索记录
     *
     * @param userId 用户id
     * @return Result
     */
    @ApiOperation("查询搜索记录")
    @GetMapping("/searchRecords/{userId}")
    @RequiresRoles(value = {"user","admin","administrator"}, logical = Logical.OR)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "JwtToken", value = "JwtToken",
                    required = true, paramType = "header", dataType = "String", dataTypeClass = String.class)
    })
    public Result searchRecords(@PathVariable String userId) {
        return searchService.searchRecords(userId);
    }

    /**
     * 删除搜索记录
     *
     * @param id JSON{"id":"用户id"}
     * @return Result
     */
    @ApiOperation("删除搜索记录")
    @DeleteMapping("/deleteRecords")
    @RequiresRoles(value = {"user","admin","administrator"}, logical = Logical.OR)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "JwtToken", value = "JwtToken",
                    required = true, paramType = "header", dataType = "String", dataTypeClass = String.class)
    })
    public Result deleteRecords(@RequestBody PostId id) {
        return searchService.deleteRecords(id);
    }
}
