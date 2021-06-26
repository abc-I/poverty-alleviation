package com.poverty.configure;

import com.poverty.entity.po.User;
import com.poverty.entity.pojo.JwtToken;
import com.poverty.mapper.RoleMapper;
import com.poverty.mapper.UserMapper;
import com.poverty.util.JedisUtil;
import lombok.SneakyThrows;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/4/7 13:24
 */
@Component
public class JwtRealm extends AuthorizingRealm {

    @Resource
    private RoleMapper rolesMapper;
    @Resource
    private UserMapper userMapper;

    /**
     * 预先执行
     *
     * @param token 前端传来的token
     * @return boolean
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        // 判断token是不是JwtToken
        return token instanceof JwtToken;
    }

    /**
     * 获取权限信息
     *
     * @param principalCollection doGetAuthenticationInfo中采集的信息
     * @return AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 获取用户id
        String id = (String) principalCollection.getPrimaryPrincipal();
        // 获取权限信息
        Set<String> roles = rolesMapper.selectRolesByUserId(id);
        // 封装权限信息
        info.setRoles(roles);

        return info;
    }

    /**
     * 获取认证信息
     *
     * @param authenticationToken 前端传的token
     * @return AuthenticationInfo
     * @throws AuthenticationException 登录异常
     */
    @SneakyThrows
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        // 获取用户id
        String id = (String) authenticationToken.getPrincipal();
        // 判断JwtToken是否存在用户id
        if (id == null) {
            throw new AccountException("JWT Token参数异常！");
        }
        // 获取用户信息
        User user = userMapper.selectOne(id);
        // 判读是否成功获取用户信息
        if (user == null) {
            throw new UnknownAccountException("用户不存在！");
        }
        // 判读是否封号
        if (user.getIsLocked()) {
            throw new LockedAccountException("账户被锁定！");
        }
        // 封装信息
        return new SimpleAuthenticationInfo(id, JedisUtil.get(id), "jwtRealm");
    }
}