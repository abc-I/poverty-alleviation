package com.poverty.mapper;

import com.poverty.entity.dto.CarouselDTO;
import com.poverty.entity.po.Carousel;
import com.poverty.entity.vo.CarouselVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/23 16:08
 */
@Mapper
public interface CarouselMapper {

    int insertCarousel(Carousel carousel);

    int deleteCarousel(String id);

    int updateCarousel(CarouselDTO carouselDTO);

    List<CarouselVO> selectCarousel(int start,int end);

    String selectUrlById(String id);
}
