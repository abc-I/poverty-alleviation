package com.poverty.service.impl;

import com.poverty.entity.Result;
import com.poverty.entity.dto.Login;
import com.poverty.entity.dto.PostId;
import com.poverty.entity.dto.SignUp;
import com.poverty.entity.po.User;
import com.poverty.entity.po.UserInformation;
import com.poverty.entity.po.UserRole;
import com.poverty.entity.pojo.JwtToken;
import com.poverty.mapper.UserInformationMapper;
import com.poverty.mapper.UserMapper;
import com.poverty.mapper.UserRoleMapper;
import com.poverty.service.LoginService;
import com.poverty.util.JedisUtil;
import com.poverty.util.JwtUtil;
import com.poverty.util.MD5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author chocolili
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private UserInformationMapper userInformationMapper;

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

    @Override
    public Result logout(PostId id) {
        if (JedisUtil.delete(id.getId())) {
            return Result.result200("退出成功！");
        }
        return Result.result500("退出失败！");
    }

    @Override
    public Result signUpUser(SignUp signUp) throws Exception {
        return setInformation(signUp, "user");
    }

    @Override
    public Result signUpAdmin(SignUp signUp) throws Exception {
        return setInformation(signUp, "admin");
    }

    private Result setInformation(SignUp signUp,String s) throws Exception {
        String userId = UUID.randomUUID().toString().replace("-", "");

        long max = 9999999999999L;
        long min = 1;

        String account;
        do {
            account = String.valueOf((long) (Math.random() * (max - min) + min));
        } while (userMapper.selectIdByAccount(account) != null);

        String salt = UUID.randomUUID().toString().replace("-", "");
        String pass = MD5Util.parse10(signUp.getPassword(), salt);
        User user = new User(userId, account, pass, salt);
        int userLen = userMapper.insertOne(user);

        if (userLen > 0) {
            UserInformation userInformation =
                    new UserInformation(userId, signUp.getUsername(), signUp.getRealName(), signUp.getPhone(),
                            signUp.getEmail(), signUp.getIdCard(), signUp.getAddress());

            int len = userInformationMapper.insertOne(userInformation);

            String role = "user";
            UserRole userRole;
            if (len > 0) {
                userRole = role.equals(s) ? setRoleUser(userId) : setRoleAdmin(userId);

                int ur = userRoleMapper.insertOne(userRole);
                if (ur > 0) {
                    return Result.result200(account);
                }
            }
        }
        throw new Exception("注册失败！");
    }

    private UserRole setRoleUser(String id) {
        UserRole userRole = new UserRole();
        userRole.setUser(id);
        return userRole;
    }

    private UserRole setRoleAdmin(String id) {
        UserRole userRole = new UserRole();
        userRole.setAdmin(id);
        return userRole;
    }
}
