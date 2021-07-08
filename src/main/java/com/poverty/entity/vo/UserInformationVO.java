package com.poverty.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/7/8 8:20
 */
@Data
public class UserInformationVO implements Serializable {
    private static final long serialVersionUID = 5063815914492184620L;

    /**
     * 用户id
     */
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 真名
     */
    private String realName;

    /**
     * 电话
     */
    private String phone;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 地址
     */
    private String address;

    /**
     * 账号
     */
    private String account;
}
