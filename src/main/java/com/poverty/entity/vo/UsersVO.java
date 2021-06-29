package com.poverty.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/29 15:43
 */
@Data
public class UsersVO implements Serializable {
    private static final long serialVersionUID = 3487899607677617933L;

    /**
     * 用户id
     */
    private String id;

    /**
     * 用户账号
     */
    private String account;

    /**
     * 用户名
     */
    private String username;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 是否封号
     */
    private Boolean isLocked;
}