package com.poverty.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
/**
 * @author zhu
 * @version 1.0
 * @date Created in 2021/6/30 11.05
 */
@Data
public class CollectionDTO implements Serializable {
    private static final long serialVersionUID = -765136283797091203L;
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
    @TableField(value = "video_id")
    private String videoUrl;

}
