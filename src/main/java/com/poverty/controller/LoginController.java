package com.poverty.controller;

import com.poverty.entity.Result;
import com.poverty.entity.dto.Login;
import com.poverty.entity.dto.PostId;
import com.poverty.entity.dto.SignUp;
import com.poverty.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.io.IOException;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/23 19:35
 */
@RestController
@Api(tags = "登录接口")
public class LoginController {

    @Resource
    private LoginService loginService;

    /**
     * 登录
     *
     * @param login JSON{"account":"账号","password":"密码"}
     * @return JSON{"status":"状态码","message":"状态信息","object":"返回数据"}
     */
    @ApiOperation("登录")
    @PostMapping("/login")
    public Result login(@RequestBody Login login) {
        return loginService.login(login);
    }

    /**
     * 登出
     *
     * @param id JSON{"id":"用户id"}
     * @return JSON{"status":"状态码","message":"状态信息","object":"返回数据"}
     */
    @ApiOperation("登出")
    @RequiresRoles(value = {"administrator", "admin", "user"}, logical = Logical.OR)
    @DeleteMapping("/logout")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "JwtToken", value = "JwtToken",
                    required = true, paramType = "header", dataType = "String", dataTypeClass = String.class)
    })
    public Result logout(@RequestBody PostId id) {
        return loginService.logout(id);
    }

    /**
     * 注册用户
     *
     * @param signUp JSON{"username":"用户名","realName":"真名","phone":"电话号","email":"邮箱",
     *               "idCard":"身份证号","address":"地址","password":"密码","code":"验证码","birthday":"生日"}
     * @return JSON{"status":"状态码","message":"状态信息","object":"返回数据"}
     */
    @ApiOperation("注册用户")
    @PostMapping("/signUpUser")
    public Result signUpUser(@RequestBody SignUp signUp) {
        try {
            return loginService.signUpUser(signUp);
        } catch (Exception e) {
            return Result.result500("注册失败！");
        }
    }

    /**
     * 注册管理员
     *
     * @param signUp JSON{"username":"用户名","realName":"真名","phone":"电话号","email":"邮箱",
     *               "idCard":"身份证号","address":"地址","password":"密码","code":"验证码","birthday":"生日"}
     * @return JSON{"status":"状态码","message":"状态信息","object":"返回数据"}
     */
    @ApiOperation("注册管理员")
    @RequiresRoles(value = {"administrator"}, logical = Logical.OR)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "JwtToken", value = "JwtToken",
                    required = true, paramType = "header", dataType = "String", dataTypeClass = String.class)
    })
    @PostMapping("/signUpAdmin")
    public Result signUpAdmin(@RequestBody SignUp signUp) {
        try {
            return loginService.signUpAdmin(signUp);
        } catch (Exception e) {
            return Result.result500("注册失败！");
        }
    }

    /**
     * 获取验证码
     *
     * @param email 邮件地址
     * @return JSON{"status":"状态码","message":"状态信息","object":"返回数据"}
     */
    @ApiOperation("获取验证码")
    @GetMapping("/getCode/{email}")
    public Result getCode(@PathVariable String email) {
        try {
            return loginService.getCode(email);
        } catch (IOException | MessagingException e) {
            e.printStackTrace();
            return Result.result500("获取验证码失败！");
        }
    }
}