package com.poverty.controller;

import com.poverty.entity.Result;
import com.poverty.entity.dto.PostId;
import com.poverty.service.BrowsingHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
/**
 * @author Zhu
 * @version 1.0
 * @date Created in 2021/6/30 11:05
 */
@RestController("BrowsingHistory")
@Api(tags = "查询历史记录接口")
public class BrowsingHistoryController {
    @Resource
    private BrowsingHistoryService browsingHistoryService;
    @GetMapping("/BrowsingHistory/selectArticleBrowsingHistory/{userId}")
    @ApiOperation("查询文章历史记录")
    public Result articleBrowsingHistory(@PathVariable PostId userId){
        return browsingHistoryService.selectArticleBrowsingHistory(userId);
    }

    @GetMapping("/BrowsingHistory/selectVideoBrowsingHistory/{userId}")
    @ApiOperation("查询视频历史记录")
    public Result videoBrowsingHistory(@PathVariable PostId userId){
        return browsingHistoryService.selectVideoBrowsingHistory(userId);
    }

}
