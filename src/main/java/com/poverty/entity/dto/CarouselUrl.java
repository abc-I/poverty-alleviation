package com.poverty.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhu
 * @version 1.0
 * @date Created in 2021/7/12 21.57
 */
@Data
public class CarouselUrl implements Serializable {
    private static final long serialVersionUID = 6672476080752849308L;
    /**
     * 轮播图url
     */
    private String carouselUrl;
}
