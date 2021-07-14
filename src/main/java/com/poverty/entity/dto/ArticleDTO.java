package com.poverty.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/7/1 8:35
 */
@Data
public class ArticleDTO implements Serializable {
    private static final long serialVersionUID = 6952920832958962250L;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章html的url
     */
    private String articleUrl;

    /**
     * 用户id
     */
    private String userId;
}
