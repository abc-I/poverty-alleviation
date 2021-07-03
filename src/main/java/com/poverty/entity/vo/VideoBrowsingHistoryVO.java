package com.poverty.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class VideoBrowsingHistoryVO implements Serializable {
    private static final long serialVersionUID = -5980700103267161565L;
    /**
     * 视频id
     */
    private String id;

    /**
     * 视频标题
     */
    private String title;

    /**
     * 时间
     */
    private Date createTime;
}
