package com.poverty.entity.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 * @author zhu
 * @version 1.0
 * @date Created in 2021/7/1 10:45
 */
@Data
public class UserInformationDTO implements Serializable {
    private static final long serialVersionUID = 5888981412387696177L;
    /**
     * 主键(用户id)
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 用户昵称
     */
    @TableField(value = "username")
    private String username;

    /**
     * 用户真名
     */
    @TableField(value = "realName")
    private String realName;

    /**
     * 电话号
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 生日
     */
    @TableField(value = "birthday")
    private String birthday;

    /**
     * 身份证号
     */
    @TableField(value = "idCard")
    private String idCard;

    /**
     * 地址
     */
    @TableField(value = "address")
    private String address;


}
