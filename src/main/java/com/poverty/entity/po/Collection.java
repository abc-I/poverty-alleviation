package com.poverty.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/23 17:02
 */
@Data
@TableName("t_collection")
public class Collection implements Serializable {

    private static final long serialVersionUID = 7081643927467442717L;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 文章id
     */
    @TableField(value = "article_id")
    private String articleId;

    /**
     * 视频id
     */
    @TableField(value = "video_url")
    private String videoUrl;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "modify_time", fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date modifyTime;
}
