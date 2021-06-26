package com.poverty.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/26 10:30
 */
@Data
public class Login implements Serializable {

    private static final long serialVersionUID = 8392978941417375310L;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;
}
