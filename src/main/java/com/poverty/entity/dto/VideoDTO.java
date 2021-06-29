package com.poverty.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class VideoDTO implements Serializable {

    private static final long serialVersionUID = 1492063000742158669L;

    /**
     * 主键(UUID)
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 标题
     */
    @TableField(value = "title")
    private String titel;

    /**
     * 视频url
     */
    @TableField(value = "video_url")
    private String videoUrl;

    /**
     * 图片url
     */
    @TableField(value = "picture_url")
    private String pictureUrl;

    /**
     * 作者id
     */
    @TableField(value = "author_id")
    private String authorId;
}
