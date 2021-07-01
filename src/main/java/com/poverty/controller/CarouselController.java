package com.poverty.controller;

import com.poverty.entity.Result;
import com.poverty.entity.dto.CarouselDTO;
import com.poverty.service.CarouselService;
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
 * @date Created in 2021/6/28 10:35
 */
@RestController("/Carousel")
@Api(tags = "轮播图接口")
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
    @PostMapping("/Carousel/insertCarousel")
    @RequiresRoles(value = {"administrator", "admin"}, logical = Logical.OR)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "JwtToken", value = "JwtToken",
                    required = true, paramType = "header", dataType = "String", dataTypeClass = String.class)
    })
    public Result insertCarousel(CarouselDTO carouselDTO) {
        return carouselService.insertCarousel(carouselDTO);
    }

    /**
     * 删除轮播图
     *
     * @param  carouselID
     * @return Result
     */
    @ApiOperation("删除轮播图")
    @RequiresRoles(value = {"administrator", "admin"}, logical = Logical.OR)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "JwtToken", value = "JwtToken",
                    required = true, paramType = "header", dataType = "String", dataTypeClass = String.class)
    })
    @DeleteMapping("/Carousel/deleteCarousel")
    public Result deleteCarousel(String carouselID) {
        return carouselService.deleteCarousel(carouselID);
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
    @PostMapping("/Carousel/updateCarousel")
    public Result updateCarousel(CarouselDTO carouselDTO) {
        return carouselService.updateCarousel(carouselDTO);
    }

    /**
     * 查询轮播图
     *
     * @return Result
     */
    @ApiOperation("查询所有轮播图")
    @GetMapping("/Carousel/selectCarousel")
    public Result selectCarousel(){
        return  carouselService.selectCarousel();
    }
}