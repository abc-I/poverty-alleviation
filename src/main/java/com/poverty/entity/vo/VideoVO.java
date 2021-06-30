package com.poverty.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/29 13:03
 */
@Data
public class VideoVO implements Serializable {
    private static final long serialVersionUID = 7467192327123762225L;

    /**
     * 视频id
     */
    private String id;

    /**
     * 视频标题
     */
    private String title;

    /**
     * 视频url
     */
    private String videoUrl;

    /**
     * 用户名
     */
    private String username;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 被点击数
     */
    private Integer recommend;

    /**
     * 点赞数
     */
    private Integer beLiked;
}
