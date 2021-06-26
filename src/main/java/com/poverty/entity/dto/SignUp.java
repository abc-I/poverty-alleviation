package com.poverty.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/26 14:31
 */
@Data
public class SignUp implements Serializable {
    private static final long serialVersionUID = -799376607249546086L;

    private String username;
    private String realName;
    private String phone;
    private String email;
    private String idCard;
    private String address;
    private String password;
}
