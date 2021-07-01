package com.poverty.mapper;

import com.poverty.entity.dto.UserInformationDTO;
import com.poverty.entity.po.UserInformation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/23 16:09
 */
@Mapper
public interface UserInformationMapper {

    /**
     * 保存用户信息
     *
     * @param userInformation JSON{"id":"用户id","username":"用户昵称","realName":"用户真名","phone":"电话号",
     *                        "email":"邮箱","idCard":"身份证号","address":"地址","birthday":"生日"}
     * @return int
     */
    int insertOne(UserInformation userInformation);

    boolean updateUserInformation(UserInformationDTO userInformationDTO);
}
