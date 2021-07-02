package com.poverty.service.impl;

import com.poverty.entity.Result;
import com.poverty.entity.dto.UserInformationDTO;
import com.poverty.entity.po.UserInformation;
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

    /**
     * 查询用户
     *
     * @param id    用户id
     * @return Result
     */
    @Override
    public Result selectUserInformation(String id) {
        UserInformation selectUserInformation = userInformationMapper.selectUserInformation(id);
        if (selectUserInformation!=null){
            return Result.result200(selectUserInformation);
        }else{
            return Result.result500(null);
        }
    }
}
