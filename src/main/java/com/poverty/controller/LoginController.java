package com.poverty.controller;

import com.poverty.entity.Result;
import com.poverty.entity.dto.Login;
import com.poverty.entity.dto.PostId;
import com.poverty.entity.dto.SignUp;
import com.poverty.service.LoginService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/23 19:35
 */
@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("/login")
    public Result login(@RequestBody Login login) {
        return loginService.login(login);
    }

    @DeleteMapping("/logout")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "JwtToken", value = "JwtToken",
                    required = true, paramType = "header", dataType = "String", dataTypeClass = String.class)
    })
    public Result logout(@RequestBody PostId id) {
        return loginService.logout(id);
    }

    @PostMapping("/signUpUser")
    public Result signUpUser(@RequestBody SignUp signUp) {
        try {
            return loginService.signUpUser(signUp);
        } catch (Exception e) {
            return Result.result500("注册失败！");
        }
    }

    @PostMapping("/signUpAdmin")
    public Result signUpAdmin(@RequestBody SignUp signUp) {
        try {
            return loginService.signUpAdmin(signUp);
        } catch (Exception e) {
            return Result.result500("注册失败！");
        }
    }
}