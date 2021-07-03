package com.poverty.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class CollectionVO implements Serializable {
    private static final long serialVersionUID = -3884014582431622632L;

    private String id;
    private String title;
    private String pictureUrl;
    private String text;
    private Integer recommend;
    private Integer beLiked;
}
