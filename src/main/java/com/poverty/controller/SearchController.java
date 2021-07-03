package com.poverty.controller;

import com.poverty.entity.Result;
import com.poverty.service.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/7/3 17:31
 */
@RestController
public class SearchController {

    @Resource
    private SearchService searchService;

    /**
     * 搜索title的文章
     *
     * @param userId 用户id
     * @param title title的匹配
     * @param current 当前页
     * @param size 每页总数
     * @return Result
     */
    @GetMapping("/searchArticleByTitle/{userId}/{title}/{current}/{size}")
    public Result searchArticleByTitle(
            @PathVariable String userId, @PathVariable String title,
            @PathVariable int current, @PathVariable int size) {
        return searchService.searchArticleByTitle(userId, title, current, size);
    }

    /**
     * 搜索title的视频
     *
     * @param userId 用户id
     * @param title title的匹配
     * @param current 当前页
     * @param size 每页总数
     * @return Result
     */
    @GetMapping("/searchVideoByTitle/{userId}/{title}/{current}/{size}")
    public Result searchVideoByTitle(
            @PathVariable String userId, @PathVariable String title,
            @PathVariable int current, @PathVariable int size) {
        return searchService.searchVideoByTitle(userId, title, current, size);
    }

    /**
     * 查询搜索记录
     *
     * @param userId 用户id
     * @return Result
     */
    @GetMapping("/searchRecords/{userId}")
    public Result searchRecords(@PathVariable String userId) {
        return searchService.searchRecords(userId);
    }
}
