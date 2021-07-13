package com.poverty.controller;

import com.poverty.entity.Result;
import com.poverty.entity.dto.PostId;
import com.poverty.service.BrowsingHistoryService;
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
 * @date Created in 2021/6/30 11:05
 */
@RestController
@RequestMapping("/browsingHistory")
@Api(tags = "历史记录接口")
@RequiresRoles(value = {"user","admin","administrator"}, logical = Logical.OR)
@ApiImplicitParams(value = {
        @ApiImplicitParam(name = "JwtToken", value = "JwtToken",
                required = true, paramType = "header", dataType = "String", dataTypeClass = String.class)
})
public class BrowsingHistoryController {
    @Resource
    private BrowsingHistoryService browsingHistoryService;
    /**
     * 查询文章历史记录
     * @param userId 用户id
     * @return Result
     */
    @GetMapping("/selectArticleBrowsingHistory/{userId}/{current}/{size}")
    @ApiOperation("查询文章历史记录")
    public Result articleBrowsingHistory(@PathVariable String userId,
                                         @PathVariable int current,@PathVariable int size){
        return browsingHistoryService.selectArticleBrowsingHistory(userId, current, size);
    }
    /**
     * 查询视频历史记录
     * @param userId 用户id
     * @return Result
     */
    @GetMapping("/selectVideoBrowsingHistory/{userId}/{current}/{size}")
    @ApiOperation("查询视频历史记录")
    public Result videoBrowsingHistory(@PathVariable String userId,
                                       @PathVariable int current, @PathVariable int size) {
        return browsingHistoryService.selectVideoBrowsingHistory(userId, current, size);
    }
    /**
     * 删除文章历史记录
     * @param userId 用户id
     * @return Result
     */
    @DeleteMapping("/deleteArticleBrowsingHistory")
    @ApiOperation("删除文章历史记录")
    public Result deleteArticleBrowsingHistory(@RequestBody PostId userId){
        return browsingHistoryService.deleteArticleBrowsingHistory(userId);
    }
    /**
     * 删除视频历史记录
     * @param userId 用户id
     * @return Result
     */
    @DeleteMapping("/deleteVideoBrowsingHistory")
    @ApiOperation("删除视频历史记录")
    public Result deleteVideoBrowsingHistory(@RequestBody PostId userId){
        return browsingHistoryService.deleteVideoBrowsingHistory(userId);
    }
}
