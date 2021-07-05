package com.poverty.service;

import com.poverty.entity.Result;
import com.poverty.entity.dto.CarouselDTO;
import com.poverty.entity.dto.PostId;

import java.util.List;
/**
 * @author Zhu
 * @version 1.0
 * @date Created in 2021/6/28 10:38
 */
public interface CarouselService {
    /**
     * 添加轮播图
     * @param carouselUrl
     * @return Result
     */
    Result insertCarousel(String carouselUrl);

    /**
     * 删除轮播图
     * @param id
     * @return Result
     */
    Result deleteCarousel(PostId id);

    /**
     * 修改轮播图
     * @param carouselDTO
     * @return Result
     */
    Result updateCarousel(CarouselDTO carouselDTO);

    /**
     * 查找轮播图
     * @param start
     * @param end
     * @return Result
     */
    Result selectCarousel(int start,int end);
}
