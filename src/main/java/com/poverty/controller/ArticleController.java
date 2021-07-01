package com.poverty.controller;

import com.poverty.entity.Result;
import com.poverty.entity.dto.ArticleDTO;
import com.poverty.entity.dto.PostId;
import com.poverty.service.ArticleService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/7/1 8:28
 */
@RestController
@RequiresRoles(value = {"user"}, logical = Logical.OR)
@RequestMapping("/article")
@ApiImplicitParams(value = {
        @ApiImplicitParam(name = "JwtToken", value = "JwtToken",
                required = true, paramType = "header", dataType = "String", dataTypeClass = String.class)
})
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
    @GetMapping("/getArticleList/{current}/{size}")
    private Result getArticleList(@PathVariable int current, @PathVariable int size) {
        return articleService.getArticleList(current, size);
    }

    /**
     * 获取文章
     *
     * @param id 文章id
     * @param userId 用户id
     * @return Result
     */
    @GetMapping("/getArticle/{id}/{userId}")
    private Result getArticleById(@PathVariable String id, @PathVariable String userId) {
        return articleService.getArticleById(id, userId);
    }

    /**
     * 保存文章信息
     *
     * @param articleDTO JSON{"title":"文章标题","articleUrl":"文章html的url","text":"文章部分内容","account":"账号"}
     * @return Result
     */
    @PostMapping("/insertArticle")
    private Result insertArticle(@RequestBody ArticleDTO articleDTO) {
        return articleService.insertArticle(articleDTO);
    }

    @DeleteMapping("/deleteArticle")
    private Result deleteArticleById(PostId id) {
        return articleService.deleteArticleById(id);
    }
}
