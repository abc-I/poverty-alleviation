package com.poverty.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/28 19:49
 */
@Data
public class ArticleVO implements Serializable {
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
     * 文章html的url
     */
    private String articleUrl;

    /**
     * 用户名
     */
    private String username;

    /**
     * 收藏数
     */
    private Integer recommend;

    /**
     * 点赞数
     */
    private Integer beLiked;

    /**
     * 创建时间
     */
    private Date createTime;
}
