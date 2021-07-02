package com.poverty.controller;

import com.poverty.entity.Result;
import com.poverty.entity.dto.UserInformationDTO;
import com.poverty.entity.po.UserInformation;
import com.poverty.service.UserInformationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Zhu
 * @version 1.0
 * @date Created in 2021/7/1 10:40
 */

@RestController
@Api(tags = "用户信息接口")
@RequestMapping("/userInformation")
@RequiresRoles(value = {"user", "admin","administrator"}, logical = Logical.OR)
@ApiImplicitParams(value = {
        @ApiImplicitParam(name = "JwtToken", value = "JwtToken",
                required = true, paramType = "header", dataType = "String", dataTypeClass = String.class)
})
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
    public Result updateUserInformation(@RequestBody UserInformationDTO userInformationDTO) {
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
    public Result selectUserInformation(@PathVariable String id) {
        return userInformationService.selectUserInformation(id);
    }
}
