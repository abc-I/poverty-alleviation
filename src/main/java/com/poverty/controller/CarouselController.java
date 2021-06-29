package com.poverty.controller;

import com.poverty.entity.Result;
import com.poverty.entity.dto.CarouselDTO;
import com.poverty.entity.po.Carousel;
import com.poverty.service.CarouselService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @ApiOperation("添加轮播图")
    @PostMapping("/Carousel/insertCarousel")
    public Result insertCarousel(CarouselDTO carouselDTO) {
        return carouselService.insertCarousel(carouselDTO);
    }

    @ApiOperation("删除轮播图")
    @DeleteMapping("/Carousel/deleteCarousel")
    public Result deleteCarousel(String carouselID) {
        return carouselService.deleteCarousel(carouselID);
    }

    @ApiOperation("修改轮播图")
    @PostMapping("/Carousel/updateCarousel")
    public Result updateCarousel(CarouselDTO carouselDTO) {
        return carouselService.updateCarousel(carouselDTO);
    }

    @ApiOperation("查询轮播图")
    @GetMapping("/Carousel/selectCarousel")
    public List<CarouselDTO> selectCarousel(){
        return  carouselService.selectCarousel();
    }
}