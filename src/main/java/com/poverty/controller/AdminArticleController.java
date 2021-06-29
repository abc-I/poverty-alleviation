package com.poverty.controller;

import com.poverty.entity.Result;
import com.poverty.entity.dto.PostId;
import com.poverty.service.AdminArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/28 9:07
 */
@RestController
@RequestMapping("/admin")
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
     * 获取所有已通过审核的文章
     *
     * @param current 当前页
     * @param size 每页数据数
     * @return Result
     */
    @GetMapping("/getIsArticleList/{current}/{size}")
    public Result getIsArticleList(@PathVariable int current,@PathVariable int size) {
        return administratorService.getIsArticleList(current, size);
    }

    /**
     * 设置文章审核未通过
     *
     * @param id 文章id
     * @return Result
     */
    @PostMapping("/noExaminedArticle")
    public Result noExamineArticle(@RequestBody PostId id) {
        return administratorService.noExaminedArticle(id);
    }

    /**
     * 设置文章审核通过
     *
     * @param id 文章id
     * @return Result
     */
    @PostMapping("/isExaminedArticle")
    public Result isExamineArticle(@RequestBody PostId id) {
        return administratorService.isExaminedArticle(id);
    }

    /**
     * 获取未通过审核的文章
     *
     * @param id 文章id
     * @return Result
     */
    @GetMapping("/getNoArticle/{id}")
    public Result getNoArticle(@PathVariable String id) {
        return administratorService.getNoArticle(id);
    }

    /**
     * 删除所有未通过审核的文章
     *
     * @return Result
     */
    @DeleteMapping("/deleteNoExamined")
    public Result deleteNoExamined() {
        return administratorService.deleteNoExamined();
    }

}