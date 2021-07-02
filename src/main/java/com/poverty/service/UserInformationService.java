package com.poverty.service;

import com.poverty.entity.Result;
import com.poverty.entity.dto.UserInformationDTO;
import com.poverty.entity.po.UserInformation;

/**
 * @author Zhu
 * @version 1.0
 * @date Created in 2021/7/1 10:45
 */
public interface UserInformationService {
    /**
     * 修改用户信息
     */
    Result updateUserInformation(UserInformationDTO userInformationDTO);

    Result selectUserInformation(String id);
}
