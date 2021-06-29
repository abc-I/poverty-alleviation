package com.poverty.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/28 9:15
 */
@Data
public class ArticlesVO implements Serializable {
    private static final long serialVersionUID = -1010822801619179404L;

    private String id;
    private String title;
    private String text;
    private String pictureUrl;
    private Integer recommend;
    private Integer beLiked;
}