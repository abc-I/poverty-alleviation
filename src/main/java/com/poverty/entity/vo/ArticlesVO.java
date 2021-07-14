package com.poverty.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/28 9:15
 */
@Data
public class ArticlesVO implements Serializable {
    private static final long serialVersionUID = -1010822801619179404L;

    /**
     * 文章id
     */
    private String id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 作者
     */
    private String username;

    /**
     * 浏览数
     */
    private Integer recommend;

    /**
     * 点赞数
     */
    private Integer beLiked;

    /**
     * 发布时间
     */
    private Date createTime;
}