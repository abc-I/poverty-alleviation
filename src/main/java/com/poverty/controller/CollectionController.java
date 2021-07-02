package com.poverty.controller;

import com.poverty.entity.Result;
import com.poverty.entity.dto.BeLikeDTO;
import com.poverty.entity.dto.CollectionDTO;
import com.poverty.entity.po.Collection;
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
     * 添加收藏
     *
     * @param collectionDTO
     * @return Result
     */
    @PostMapping("/insertCollection")
    @ApiOperation("添加收藏")
    public Result insertCollection(@RequestBody CollectionDTO collectionDTO){
        return collectionService.insertCollection(collectionDTO);
    }
    /**
     * 取消收藏
     *
     * @param collectionDTO
     * @return Result
     */
    @DeleteMapping("/deleteCollection")
    @ApiOperation("取消收藏")
    public Result deleteCollection(@RequestBody CollectionDTO collectionDTO){
        return collectionService.deleteCollection(collectionDTO);
    }

    /**
     *  查询收藏
     * @param userId
     * @return Result
     */
    @GetMapping("/selectCollection/{userId}")
    @ApiOperation("查询收藏")
    public Result selectCollection(@PathVariable String userId){
        return collectionService.selectCollection(userId);
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
