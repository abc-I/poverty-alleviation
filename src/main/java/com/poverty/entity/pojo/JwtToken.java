package com.poverty.entity.pojo;

import com.poverty.util.JwtUtil;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/4/16 20:19
 */
public class JwtToken implements AuthenticationToken {

    private static final long serialVersionUID = -8176448743649432242L;

    /**
     * jwtToken
     */
    private final String token;

    /**
     * 用户id
     */
    private final String id;

    public JwtToken(String token) {
        this.token = token;
        this.id = JwtUtil.getClaims(token).getAudience();
    }

    @Override
    public Object getPrincipal() {
        return id;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
