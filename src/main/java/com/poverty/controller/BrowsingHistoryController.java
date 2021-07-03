package com.poverty.controller;

import com.poverty.entity.Result;
import com.poverty.entity.dto.PostId;
import com.poverty.service.BrowsingHistoryService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController("BrowsingHistory")
@Api(tags = "查询历史记录接口")
public class BrowsingHistoryController {
    @Resource
    private BrowsingHistoryService browsingHistoryService;
    @GetMapping("/BrowsingHistory/selectArticleBrowsingHistory")
    public Result ArticleBrowsingHistory(@PathVariable PostId userId){
        return browsingHistoryService.selectArticleBrowsingHistory(userId);
    }

    @GetMapping("/BrowsingHistory/selectVideoBrowsingHistory")
    public Result VideoBrowsingHistory(@PathVariable PostId userId){
        return browsingHistoryService.selectVideoBrowsingHistory(userId);
    }
}
