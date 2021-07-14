package com.poverty.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
/**
 * @author Zhu
 * @version 1.0
 * @date Created in 2021/6/29 17:38
 */
@Data
public class VideoDTO implements Serializable {

    private static final long serialVersionUID = 1492063000742158669L;


    /**
     * 标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 视频url
     */
    @TableField(value = "video_url")
    private String videoUrl;

    /**
     *
     */
    @TableField(value = "author_id")
    private String userId;
}
