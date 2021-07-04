package com.poverty.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhu
 * @version 1.0
 * @date Created in 2021/7/03 13:22
 */
@Data
public class BrowsingHistoryVO implements Serializable {
    private static final long serialVersionUID = -6669313465031023223L;
    /**
     * 文章或视频id
     */
    private String id;

    /**
     * 文章或视频标题
     */
    private String title;

    /**
     * 时间
     */
    private Date createTime;
}
