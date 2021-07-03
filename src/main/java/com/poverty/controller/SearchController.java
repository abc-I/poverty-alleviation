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

    @GetMapping("/searchArticleByTitle/{userId}/{title}/{current}/{size}")
    public Result searchArticleByTitle(
            @PathVariable String userId, @PathVariable String title,
            @PathVariable int current, @PathVariable int size) {
        return searchService.searchArticleByTitle(userId, title, current, size);
    }

    @GetMapping("/searchVideoByTitle/{userId}/{title}/{current}/{size}")
    public Result searchVideoByTitle(
            @PathVariable String userId, @PathVariable String title,
            @PathVariable int current, @PathVariable int size) {
        return searchService.searchVideoByTitle(userId, title, current, size);
    }
}
