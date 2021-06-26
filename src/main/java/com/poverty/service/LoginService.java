package com.poverty.service;

import com.poverty.entity.Result;
import com.poverty.entity.dto.Login;
import com.poverty.entity.dto.PostId;
import com.poverty.entity.dto.SignUp;

/**
 * @author  LI
 */
public interface LoginService {

    /**
     * 登录
     *
     * @param login JSON{"account":"账号","password":"密码"}
     * @return JSON{"status":"状态码","message":"状态信息","object":"返回数据"}
     */
    Result login(Login login);

    /**
     * 登出
     *
     * @param id JSON{"id":"用户id"}
     * @return JSON{"status":"状态码","message":"状态信息","object":"返回数据"}
     */
    Result logout(PostId id);

    /**
     * 注册用户
     *
     * @param signUp JSON{"username":"用户名","realName":"真名","phone":"电话号","email":"邮箱",
     *               "idCard":"身份证号","address":"地址","password":"密码"}
     * @return JSON{"status":"状态码","message":"状态信息","object":"返回数据"}
     * @throws  Exception 注册异常
     */
    Result signUpUser(SignUp signUp) throws Exception;

    /**
     * 注册管理员
     *
     * @param signUp JSON{"username":"用户名","realName":"真名","phone":"电话号","email":"邮箱",
     *               "idCard":"身份证号","address":"地址","password":"密码"}
     * @return JSON{"status":"状态码","message":"状态信息","object":"返回数据"}
     * @throws Exception 注册异常
     */
    Result signUpAdmin(SignUp signUp) throws Exception;
}
