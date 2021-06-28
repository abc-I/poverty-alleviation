package com.poverty.mapper;

import com.poverty.entity.dto.CarouselDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/23 16:08
 */
@Mapper
public interface CarouselMapper {


 

    int insertCarousel(CarouselDTO carouselDTO);

    int deleteCarousel(String carouselID);

    int updateCarousel(CarouselDTO carouselDTO);

    List<CarouselDTO> selectCarousel();
}
