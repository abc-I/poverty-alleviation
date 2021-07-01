package com.poverty.service.impl;

import com.poverty.entity.Result;
import com.poverty.entity.dto.UserInformationDTO;
import com.poverty.mapper.UserInformationMapper;
import com.poverty.service.UserInformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Zhu
 * @version 1.0
 * @date Created in 2021/7/1 10:43
 */
@Service
public class UserInformationServiceImpl implements UserInformationService {
    @Resource
    private UserInformationMapper userInformationMapper;
    /**
     * 修改用户
     *
     * @param userInformationDTO
     * @return Result
     */
    @Override
    public Result updateUserInformation(UserInformationDTO userInformationDTO) {
        boolean updateUserInformation = userInformationMapper.updateUserInformation(userInformationDTO);
        if(updateUserInformation){
            return Result.result200("修改成功");
        }else {
            return Result.result500("修改失败");
        }
    }
}
