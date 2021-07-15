package com.poverty.configure;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import com.poverty.util.JedisUtil;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/4/17 14:50
 */
public class JwtCredentialsMatcher implements CredentialsMatcher {
    /**
     * 密码匹配
     *
     * @param authenticationToken 前端传来的token
     * @param authenticationInfo 后端查出的token
     * @return boolean
     */
    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
        // 获取token
        String clientToken = (String) authenticationToken.getCredentials();
        String redisToken = (String) authenticationInfo.getCredentials();
        // 获取用户id
        String account = (String) authenticationToken.getPrincipal();

        // 匹配token
        if (clientToken.equals(redisToken)) {
            // 刷新token过期时间
            return JedisUtil.refresh(account, 60 * 60 * 24);
        } else {
            return false;
        }
    }
}