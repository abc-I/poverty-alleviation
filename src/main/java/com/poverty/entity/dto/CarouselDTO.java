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
    /**
     * 轮播图id
     */
    private String CarouselId;
    /**
     * 轮播图url
     */
    private String CarouselUrl;
}
