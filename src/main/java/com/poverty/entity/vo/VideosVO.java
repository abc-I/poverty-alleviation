package com.poverty.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/29 13:10
 */
@Data
public class VideosVO implements Serializable {
    private static final long serialVersionUID = 2415040352812917282L;

    /**
     * 视频id
     */
    private String id;

    /**
     * 视频标题
     */
    private String title;

    /**
     * 作者名
     */
    private String username;

    /**
     * 点赞数
     */
    private Integer beLiked;

    /**
     * 浏览数
     */
    private Integer recommend;

    /**
     * 创建时间
     */
    private Date createTime;

}
