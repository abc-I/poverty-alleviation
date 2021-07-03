package com.poverty.controller;

import com.poverty.entity.Result;
import com.poverty.entity.dto.BeLikeDTO;
import com.poverty.entity.dto.CollectionDTO;
import com.poverty.service.CollectionService;
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
@Api(tags = "收藏接口")
@RequestMapping("/collection")
@RequiresRoles(value = {"user","admin","administrator"}, logical = Logical.OR)
@ApiImplicitParams(value = {
        @ApiImplicitParam(name = "JwtToken", value = "JwtToken",
                required = true, paramType = "header", dataType = "String", dataTypeClass = String.class)
})
public class CollectionController {
    @Resource
    private CollectionService collectionService;
    /**
     * 添加删除收藏
     *ll
     * @param collectionDTO
     * @return Result
     */
    @PostMapping("/collection")
    @ApiOperation("收藏")
    public Result collection(@RequestBody CollectionDTO collectionDTO){
        return collectionService.collection(collectionDTO);
    }

    /**
     * 查询收藏
     *
     * @param userId
     * @return Result
     */
    @GetMapping("/selectArticleCollection/{userId}/{current}/{size}")
    @ApiOperation("查询收藏")
    public Result selectArticleCollection(@PathVariable String userId, @PathVariable int current, @PathVariable int size) {
        return collectionService.selectArticleCollection(userId, current, size);
    }

    /**
     * 查询视频
     *
     * @param userId
     * @return Result
     */
    @GetMapping("/selectVideoCollection/{userId}/{current}/{size}")
    @ApiOperation("查询视频")
    public Result selectVideoCollection(
            @PathVariable String userId, @PathVariable int current, @PathVariable int size) {

        return collectionService.selectVideoCollection(userId, current, size);
    }
    /**
     * 点赞
     * @param beLikeDTO
     * @return Result
     */
    @PostMapping("/beLike")
    @ApiOperation("点赞")
    public Result beLike(@RequestBody BeLikeDTO beLikeDTO){
        return collectionService.beLike(beLikeDTO);
    }

    /**
     * 查询点赞
     * @param id,userId
     * @return Result
     */
    @GetMapping("/selectBeLike/{id}/{userId}")
    @ApiOperation("查询点赞")
    public Result selectBeLike(@PathVariable String id,@PathVariable String userId){
        return collectionService.selectBeLike(id,userId);
    }
}
