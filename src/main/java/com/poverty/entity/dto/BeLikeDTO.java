package com.poverty.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
/**
 * @author zhu
 * @version 1.0
 * @date Created in 2021/7/1 11.45
 */
@Data
public class BeLikeDTO implements Serializable {
    private static final long serialVersionUID = 6108069056557707561L;
    /**
     * 文章或视频id
     */
    @TableField("id")
    private String id;

    /**
     * 用户id
     */
    @TableField("userId")
    private String userId;

}
