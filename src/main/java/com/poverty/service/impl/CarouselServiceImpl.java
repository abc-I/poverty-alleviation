package com.poverty.service.impl;

import com.poverty.entity.Result;
import com.poverty.entity.dto.CarouselDTO;
import com.poverty.entity.vo.CarouselVO;
import com.poverty.mapper.CarouselMapper;
import com.poverty.service.CarouselService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;
/**
 * @author chocolili
 */
@Service
public class CarouselServiceImpl implements CarouselService {
    @Resource
    private CarouselMapper carouselMapper;

    @Override
    public Result insertCarousel(CarouselDTO carouselDTO) {
        int insertCarousel = carouselMapper.insertCarousel(carouselDTO);
        if(insertCarousel>0){
            return Result.result200("添加成功");
        }else 
            return Result.result500("添加失败");
    }

    @Override
    public Result deleteCarousel(String carouselID) {
        int deleteCarousel = carouselMapper.deleteCarousel(carouselID);
        if (deleteCarousel>0){
            return Result.result200("删除成功");
        }else
            return Result.result500("删除失败");
    }

    @Override
    public Result updateCarousel(CarouselDTO carouselDTO) {
        int updateCarousel = carouselMapper.updateCarousel(carouselDTO);
        if(updateCarousel>0){
            return Result.result200("修改成功");
        }else
            return Result.result500("修改失败");
    }

    @Override
    public Result selectCarousel() {
        List<CarouselVO> carouselVOS = carouselMapper.selectCarousel();
        return Result.result200(carouselVOS);
}
}
