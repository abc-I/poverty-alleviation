package com.poverty.entity.dto;

import lombok.Data;

import java.io.Serializable;
/**
 * @author Zhu
 * @version 1.0
 * @date Created in 2021/6/28 9:30
 */
@Data
public class CarouselDTO implements Serializable {

    private static final long serialVersionUID = 6109327220467456719L;
    /**
     * 轮播图id
     */
    private String carouselId;
    /**
     * 轮播图url
     */
    private String carouselUrl;
}
