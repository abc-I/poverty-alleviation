package com.poverty.controller;

import com.poverty.entity.Result;
import com.poverty.entity.dto.CarouselDTO;
import com.poverty.entity.dto.PostId;
import com.poverty.service.CarouselService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhu
 * @version 1.0
 * @date Created in 2021/6/28 10:35
 */
@RestController
@Api(tags = "轮播图接口")
@RequestMapping("/carousel")
public class CarouselController {
    @Resource
    private CarouselService carouselService;
    /**
     * 添加轮播图
     *
     * @param carouselDTO
     * @return Result
     */
    @ApiOperation("添加轮播图")
    @PostMapping("/insertCarousel")
    @RequiresRoles(value = {"administrator", "admin"}, logical = Logical.OR)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "JwtToken", value = "JwtToken",
                    required = true, paramType = "header", dataType = "String", dataTypeClass = String.class)
    })
    public Result insertCarousel(@RequestBody CarouselDTO carouselDTO) {
        return carouselService.insertCarousel(carouselDTO);
    }

    /**
     * 删除轮播图
     *
     * @param  id JSON{"id":"轮播图id"}
     * @return Result
     */
    @ApiOperation("删除轮播图")
    @RequiresRoles(value = {"administrator", "admin"}, logical = Logical.OR)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "JwtToken", value = "JwtToken",
                    required = true, paramType = "header", dataType = "String", dataTypeClass = String.class)
    })
    @DeleteMapping("/deleteCarousel")
    public Result deleteCarousel(@RequestBody PostId id) {
        return carouselService.deleteCarousel(id);
    }

    /**
     * 修改轮播图
     *
     * @param carouselDTO
     * @return Result
     */
    @ApiOperation("修改轮播图")
    @RequiresRoles(value = {"administrator", "admin"}, logical = Logical.OR)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "JwtToken", value = "JwtToken",
                    required = true, paramType = "header", dataType = "String", dataTypeClass = String.class)
    })
    @PostMapping("/updateCarousel")
    public Result updateCarousel(@RequestBody CarouselDTO carouselDTO) {
        return carouselService.updateCarousel(carouselDTO);
    }

    /**
     * 查询轮播图
     *
     * @return Result
     */
    @ApiOperation("查询所有轮播图")
    @GetMapping("/selectCarousel/{start}/{end}")
    public Result selectCarousel(@PathVariable int start,@PathVariable int end){
        return  carouselService.selectCarousel(start,end);
    }
}
