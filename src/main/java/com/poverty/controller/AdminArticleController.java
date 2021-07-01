package com.poverty.controller;

import com.poverty.entity.Result;
import com.poverty.service.AdminArticleService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
    @GetMapping("/getNoArticleList/{current}/{size}")
    public Result getNoArticleList(@PathVariable int current, @PathVariable int size) {
        return administratorService.getNoArticleList(current, size);
    }

    /**
     * 删除所有未通过审核的文章
     *
     * @return Result
     */
    @DeleteMapping("/deleteNoExaminedArticle")
    public Result deleteNoExamined() {
        return administratorService.deleteNoExaminedArticle();
    }
}