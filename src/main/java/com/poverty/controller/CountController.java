package com.poverty.controller;

import com.poverty.entity.Result;
import com.poverty.entity.dto.PostId;
import com.poverty.service.CountService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/29 12:39
 */
@RestController
@RequiresRoles(value = {"administrator", "admin"}, logical = Logical.OR)
@RequestMapping("/admin")
@ApiImplicitParams(value = {
        @ApiImplicitParam(name = "JwtToken", value = "JwtToken",
                required = true, paramType = "header", dataType = "String", dataTypeClass = String.class)
})
public class CountController {

    @Resource
    private CountService countService;

    /**
     * 设置 文章、视频 审核未通过
     *
     * @param id 文章id
     * @return Result
     */
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
    @PostMapping("/isExamined")
    public Result isExamineArticle(@RequestBody PostId id) {
        return countService.isExaminedArticle(id);
    }
}
