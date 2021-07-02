package com.poverty.controller;

import com.poverty.entity.Result;
import com.poverty.entity.dto.UserInformationDTO;
import com.poverty.entity.po.UserInformation;
import com.poverty.service.UserInformationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Zhu
 * @version 1.0
 * @date Created in 2021/7/1 10:40
 */

@RestController("/userInformation")
@Api(tags = "用户信息接口")
public class UserInformationController {
    @Resource
    private UserInformationService userInformationService;
    /**
     * 修改用户信息
     *
     * @param userInformationDTO
     * @return Result
     */
    @PostMapping("/updateUserInformation")
    @ApiOperation("/修改用户信息")
    public Result updateUserInformation(@RequestBody UserInformationDTO userInformationDTO){
        return userInformationService.updateUserInformation(userInformationDTO);
    }

    /**
     * 查询用户信息
     *
     * @param id 用户id
     * @return Result
     */
    @GetMapping("/selectUserInformation/{id}")
    @ApiOperation("/查询用户信息")
    public Result selectUserInformation(@PathVariable UserInformation id){
        return userInformationService.selectUserInformation(id);
    }
}
