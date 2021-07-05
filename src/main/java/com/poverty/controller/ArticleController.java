package com.poverty.controller;

import com.poverty.entity.Result;
import com.poverty.entity.dto.ArticleDTO;
import com.poverty.entity.dto.PostId;
import com.poverty.service.ArticleService;
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
 * @date Created in 2021/7/1 8:28
 */
@Api(tags = "文章接口")
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    /**
     * 获取文章列表
     *
     * @param current 当前页
     * @param size    每页几条数据
     * @return Result
     */
    @ApiOperation("获取文章列表")
    @GetMapping("/getArticleList/{current}/{size}")
    public Result getArticleList(@PathVariable int current, @PathVariable int size) {
        System.out.println(articleService);
        return articleService.getArticleList(current, size);
    }

    /**
     * 获取文章
     *
     * @param id 文章id
     * @param userId 用户id
     * @return Result
     */
    @ApiOperation("获取文章")
    @GetMapping("/getArticle/{id}/{userId}")
    public Result getArticleById(@PathVariable String id, @PathVariable String userId) {
        return articleService.getArticleById(id, userId);
    }

    /**
     * 保存文章信息
     *
     * @param articleDTO JSON{"title":"文章标题","articleUrl":"文章html的url","text":"文章部分内容","userId":"用户id"}
     * @return Result
     */
    @ApiOperation("保存文章信息")
    @PostMapping("/insertArticle")
    @RequiresRoles(value = {"user","admin","administrator"}, logical = Logical.OR)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "JwtToken", value = "JwtToken",
                    required = true, paramType = "header", dataType = "String", dataTypeClass = String.class)
    })
    public Result insertArticle(@RequestBody ArticleDTO articleDTO) {
        try {
            return articleService.insertArticle(articleDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.result500("上传失败！");
        }
    }

    /**
     * 通过文章id删除文章
     *
     * @param id JSON{"id":"文章id"}
     * @return Result
     */
    @ApiOperation("删除文章")
    @RequiresRoles(value = {"user","admin","administrator"}, logical = Logical.OR)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "JwtToken", value = "JwtToken",
                    required = true, paramType = "header", dataType = "String", dataTypeClass = String.class)
    })
    @DeleteMapping("/deleteArticle")
    public Result deleteArticleById(@RequestBody PostId id) {
        try {
            return articleService.deleteArticleById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.result500("删除失败！");
        }
    }
}