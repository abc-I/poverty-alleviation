package com.poverty.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/23 17:18
 */
@Data
@TableName("t_user_information")
public class UserInformation implements Serializable {

    private static final long serialVersionUID = -1797296917778034449L;

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

    public UserInformation(String id,String username,String realName,String phone,
                           String email,String idCard,String address,String birthday) {
        this.id = id;
        this.username = username;
        this.realName = realName;
        this.phone = phone;
        this.email = email;
        this.idCard = idCard;
        this.address = address;
        this.birthday = birthday;
    }
}
