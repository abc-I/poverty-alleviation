package com.poverty.entity.vo;

import lombok.Data;

import java.io.Serializable;

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
     * 视频截图
     */
    private String pictureUrl;

    /**
     * 视频标题
     */
    private String title;

}
