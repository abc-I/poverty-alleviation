package com.poverty.service.impl;

import com.poverty.entity.Result;
import com.poverty.entity.dto.Login;
import com.poverty.entity.pojo.JwtToken;
import com.poverty.mapper.UserMapper;
import com.poverty.service.LoginService;
import com.poverty.util.JedisUtil;
import com.poverty.util.JwtUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chocolili
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Result login(Login login) {
        String account = login.getAccount();
        String password = login.getPassword();

        String id = userMapper.selectIdByAccount(account);

        UsernamePasswordToken token = new UsernamePasswordToken(id, password);

        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (UnknownAccountException unknown) {
            return Result.result401("Fail: Unknown Account!");
        } catch (LockedAccountException locked) {
            return Result.result401("Fail: Locked Account!");
        } catch (IncorrectCredentialsException inco) {
            return Result.result401("Fail: Incorrect Credentials!");
        } catch (AuthenticationException auth) {
            return Result.result401("Fail: Authentication Failed!");
        }

        String jwtToken = JwtUtil.createJwtToken(id);

        boolean bool = JedisUtil.set(id, jwtToken, 1000 * 60 * 60 * 24);

        if (bool) {
            return Result.result200(new JwtToken(jwtToken));
        } else {
            return Result.result401("Fail：登录失败！");
        }
    }
}
