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

    /**
     * 登录
     *
     * @param login JSON{"account":"账号","password":"密码"}
     * @return JSON{"status":"状态码","message":"状态信息","object":"返回数据"}
     */
    @Override
    public Result login(Login login) {
        String account = login.getAccount();
        String password = login.getPassword();

        // 通过账号获取用户id
        String id = userMapper.selectIdByAccount(account);
        // 封装登录认证token
        UsernamePasswordToken token = new UsernamePasswordToken(id, password);

        Subject subject = SecurityUtils.getSubject();
        try {
            // 登录
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

        // 获取jwtToken
        String jwtToken = JwtUtil.createJwtToken(id);
        // 保存token
        boolean bool = JedisUtil.set(id, jwtToken, 1000 * 60 * 60 * 24);
        // 判读是否登录成功
        if (bool) {
            return Result.result200(new JwtToken(jwtToken));
        } else {
            return Result.result401("Fail：登录失败！");
        }
    }

    /**
     * 登出
     *
     * @param id JSON{"id":"用户id"}
     * @return JSON{"status":"状态码","message":"状态信息","object":"返回数据"}
     */
    @Override
    public Result logout(PostId id) {
        // 删除redis中的token
        if (JedisUtil.delete(id.getId())) {
            return Result.result200("退出成功！");
        }
        return Result.result500("退出失败！");
    }

    /**
     * 注册用户
     *
     * @param signUp JSON{"username":"用户名","realName":"真名","phone":"电话号","email":"邮箱",
     *               "idCard":"身份证号","address":"地址","password":"密码"}
     * @return JSON{"status":"状态码","message":"状态信息","object":"返回数据"}
     * @throws Exception 注册异常
     */
    @Override
    public Result signUpUser(SignUp signUp) throws Exception {
        return setInformation(signUp, "user");
    }

    /**
     * 注册管理员
     *
     * @param signUp JSON{"username":"用户名","realName":"真名","phone":"电话号","email":"邮箱",
     *               "idCard":"身份证号","address":"地址","password":"密码"}
     * @return JSON{"status":"状态码","message":"状态信息","object":"返回数据"}
     * @throws Exception 注册异常
     */
    @Override
    public Result signUpAdmin(SignUp signUp) throws Exception {
        return setInformation(signUp, "admin");
    }

    /**
     * 保存用户信息
     *
     * @param signUp JSON{"username":"用户名","realName":"真名","phone":"电话号","email":"邮箱",
     *               "idCard":"身份证号","address":"地址","password":"密码"}
     * @param s 权限名
     * @return JSON{"status":"状态码","message":"状态信息","object":"返回数据"}
     * @throws Exception 保存信息异常
     */
    private Result setInformation(SignUp signUp,String s) throws Exception {
        // 随机参数用户id
        String userId = UUID.randomUUID().toString().replace("-", "");

        // 随机产生账号
        long max = 9999999999999L;
        long min = 1;
        String account;
        do {
            account = String.valueOf((long) (Math.random() * (max - min) + min));
            // 如果账号存在，继续随机产生账号
        } while (userMapper.selectIdByAccount(account) != null);

        // 产生加密盐
        String salt = UUID.randomUUID().toString().replace("-", "");
        // 加密密码
        String pass = MD5Util.parse10(signUp.getPassword(), salt);
        // 封装账号信息
        User user = new User(userId, account, pass, salt);
        // 保存账号信息
        int userLen = userMapper.insertOne(user);

        if (userLen > 0) {
            // 封装用户信息
            UserInformation userInformation =
                    new UserInformation(userId, signUp.getUsername(), signUp.getRealName(), signUp.getPhone(),
                            signUp.getEmail(), signUp.getIdCard(), signUp.getAddress());

            // 保存用户信息
            int len = userInformationMapper.insertOne(userInformation);

            // 保存权限信息
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

    /**
     * 封装用户权限信息
     *
     * @param id 用户id
     * @return JSON{"userId":"用户id","roleId":"角色id"}
     */
    private UserRole setRoleUser(String id) {
        UserRole userRole = new UserRole();
        userRole.setUser(id);
        return userRole;
    }

    /**
     * 封装管理员权限信息
     *
     * @param id 用户id
     * @return JSON{"userId":"用户id","roleId":"角色id"}
     */
    private UserRole setRoleAdmin(String id) {
        UserRole userRole = new UserRole();
        userRole.setAdmin(id);
        return userRole;
    }
}
