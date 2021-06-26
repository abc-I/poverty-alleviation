package com.poverty.mapper;

import com.poverty.entity.po.UserInformation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/23 16:09
 */
@Mapper
public interface UserInformationMapper {
    int insertOne(UserInformation userInformation);
}
