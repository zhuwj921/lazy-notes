package com.zhuwj.auth.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * Title: token 管理
 * Description: 生成 获取 token
 *
 * @author zhuwj
 * @version V1.0
 * @date 2020-05-15
 */

public class TokenProvider {

    private String KEY = "lazy_codes";

    /**
     * iss（Issuser） - 签发者
     * sub Subject 面向主体
     * aud Audience 接收方
     * exp Expiration time 过期时间戳
     * nbf Not Before, 开始生效时间戳
     * iat(Issued at) 签发时间
     * jti(JWT ID)： 唯一标识
     * @param authentication
     * @return
     */
    public String createToken(Authentication authentication) {
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime.plusHours(2);
        return JWT.create()
                .withExpiresAt(Date.from( localDateTime.atZone( ZoneId.systemDefault()).toInstant()))
                .withSubject("user")
                .withAudience("web")
                .withJWTId("1")
                .sign(Algorithm.HMAC256(KEY));
    }

    public void decodeToken(String token){
       String payLoad =  JWT.decode(token).getPayload();

    }

    public void verifyToken(String token){
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(KEY)).build();
        jwtVerifier.verify(token);
    }
}
