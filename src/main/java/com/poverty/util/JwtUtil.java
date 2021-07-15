package com.poverty.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;
import io.jsonwebtoken.impl.DefaultJwsHeader;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/4/16 19:00
 */
@Component
public class JwtUtil {

    private static final Key PUBLIC_KEY = new SecretKeySpec(
            "9d5532ed-6ad7-4754-9815-209f424eddbe".getBytes(StandardCharsets.UTF_8),
            SignatureAlgorithm.HS256.getJcaName());

    /**
     * 创建jwtToken
     *
     * @param id 用户id
     * @return String
     */
    public static String createJwtToken(String id) {
        DefaultClaims claims = new DefaultClaims();

        // 保存jwtToken的id
        claims.setId(UUID.randomUUID().toString());
        // token的使用者
        claims.setAudience(id);
        // token的发行者
        claims.setIssuer("Li");
        // 发布时间
        claims.setIssuedAt(new Date(System.currentTimeMillis()));
        // 有效起始时间
        claims.setNotBefore(new Date(System.currentTimeMillis()));
        // 主题
        claims.setSubject("Subject");

        DefaultJwsHeader header = new DefaultJwsHeader();
        header.setType("JWT");
        header.setAlgorithm("HS256");

        return Jwts.builder()
                .setClaims(claims)
                .setHeader((Map<String, Object>) header)
                .signWith(PUBLIC_KEY).compact();
    }

    public static Claims getClaims(String token) {
        // 获取荷载
        return (Claims) Jwts.parserBuilder().setSigningKey(PUBLIC_KEY).build().parse(token).getBody();
    }
}

