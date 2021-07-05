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
    /**
     * 添加轮播图
     *
     * @param carousel
     * @return int
     */
    int insertCarousel(Carousel carousel);
    /**
     * 删除轮播图
     *
     * @param id    轮播图id
     * @return int
     */
    int deleteCarousel(String id);
    /**
     * 修改轮播图
     *
     * @param carouselDTO
     * @return int
     */
    int updateCarousel(CarouselDTO carouselDTO);

    /**
     * 查询所有轮播图
     * @param start  开始
     * @param end    结束
     * @return List<CarouselVO>
     */
    List<CarouselVO> selectCarousel(int start,int end);

    /**
     * 根据id查询轮播图
     * @param id    轮播图id
     * @return String
     */
    String selectUrlById(String id);
}
