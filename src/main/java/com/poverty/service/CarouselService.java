package com.poverty.service;

import com.poverty.entity.Result;
import com.poverty.entity.dto.CarouselDTO;

import java.util.List;
/**
 * @author Zhu
 * @version 1.0
 * @date Created in 2021/6/28 10:38
 */
public interface CarouselService {
    /**
     * 添加轮播图
     */
    Result insertCarousel(CarouselDTO carouselDTO);
    /**
     * 删除轮播图
     */
    Result deleteCarousel(String carouselID);

    /**
     * 修改轮播图
     */
    Result updateCarousel(CarouselDTO carouselDTO);

    /**
     * 查询轮播图
     */
    Result selectCarousel();
}
