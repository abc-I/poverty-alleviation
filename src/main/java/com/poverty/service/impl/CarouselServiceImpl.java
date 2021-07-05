package com.poverty.service.impl;

import com.poverty.entity.Result;
import com.poverty.entity.dto.CarouselDTO;
import com.poverty.entity.dto.PostId;
import com.poverty.entity.po.Carousel;
import com.poverty.entity.vo.CarouselVO;
import com.poverty.mapper.CarouselMapper;
import com.poverty.service.CarouselService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;
/**
 * @author Zhu
 * @version 1.0
 * @date Created in 2021/6/28 10:38
 */
@Service
public class CarouselServiceImpl implements CarouselService {
    @Resource
    private CarouselMapper carouselMapper;
    /**
     * 添加轮播图
     *
     * @param carouselUrl
     * @return Result
     */
    @Override
    public Result insertCarousel(String carouselUrl) {
        String carouselId= UUID.randomUUID().toString().replace("-","");
        Carousel carousel=new Carousel();
        carousel.setId(carouselId);
        carousel.setCarouselUrl(carouselUrl);

        int insertCarousel = carouselMapper.insertCarousel(carousel);
        if(insertCarousel>0){
            return Result.result200("添加成功");
        }else {
            return Result.result500("添加失败");
        }

    }
    /**
     * 删除轮播图
     *
     * @param id 轮播图id
     * @return Result
     */
    @SneakyThrows
    @Override
    public Result deleteCarousel(PostId id) {
        String url = carouselMapper.selectUrlById(id.getId());
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("rm -rf /home" + url);

        int deleteCarousel = carouselMapper.deleteCarousel(id.getId());
        if (deleteCarousel>0){
            return Result.result200("删除成功");
        }else{
            return Result.result500("删除失败");
        }

    }
    /**
     * 修改轮播图
     *
     * @param carouselDTO
     * @return Result
     */
    @SneakyThrows
    @Override
    public Result updateCarousel(CarouselDTO carouselDTO) {
        String url = carouselMapper.selectUrlById(carouselDTO.getId());
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("rm -rf /home" + url);

        int updateCarousel = carouselMapper.updateCarousel(carouselDTO);
        if(updateCarousel>0){
            return Result.result200("修改成功");
        }else{
            return Result.result500("修改失败");
        }

    }

    /**
     * 查找所有轮播图
     *
     * @return Result
     */
    @Override
    public Result selectCarousel(int start, int end) {
        List<CarouselVO> carouselVOS = carouselMapper.selectCarousel(start, end);
        return Result.result200(carouselVOS);
    }
}
