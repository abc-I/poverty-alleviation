package com.poverty.configure;

import com.poverty.entity.po.User;
import com.poverty.mapper.RoleMapper;
import com.poverty.mapper.UserMapper;
import lombok.SneakyThrows;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/4/7 13:24
 */
@Component
public class MyRealm extends AuthorizingRealm {

    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMapper roleMapper;

    /**
     * 预先执行
     *
     * @param token 前端传来的token
     * @return boolean
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
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
        String account = (String) principalCollection.getPrimaryPrincipal();
        // 获取权限信息
        Set<String> roles = roleMapper.selectRolesByUserAccount(account);
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
        String account = (String) authenticationToken.getPrincipal();
        // 获取用户信息
        User user = userMapper.selectOne(account);
        // 判读是否成功获取用户信息
        if (user == null) {
            throw new UnknownAccountException("用户不存在！");
        }
        // 判读是否封号
        if (user.getIsLocked()) {
            throw new LockedAccountException("账号已被锁定！");
        }
        // 封装随机盐
        ByteSource byteSource = ByteSource.Util.bytes(user.getSalt());

        // 封装信息
        return new SimpleAuthenticationInfo(account, user.getPassword(), byteSource, "myRealm");
    }
}