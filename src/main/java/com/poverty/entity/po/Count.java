package com.poverty.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/23 17:05
 */
@Data
@TableName("t_count")
public class Count implements Serializable {

    private static final long serialVersionUID = 1965796402730763034L;

    /**
     * 主键(视频或文章id)
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 被点击数
     */
    @TableField(value = "recommend")
    private String recommend;

    /**
     * 是否审核
     */
    @TableField(value = "is_examined")
    private Integer isExamined;

    /**
     * 被点赞数
     */
    @TableField(value = "be_liked")
    private String beLiked;

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
