package com.zhuwj.auth.security;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.Payload;
import com.zhuwj.auth.config.SecurityProperties;
import com.zhuwj.auth.entity.SysUser;
import com.zhuwj.auth.service.SysUserService;
import com.zhuwj.common.security.dto.SecurityUserDTO;
import com.zhuwj.common.security.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Title: token 管理
 * Description: 生成 获取 token
 *
 * @author zhuwj
 * @version V1.0
 * @date 2020-05-15
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class TokenProvider {

    private static final String AUTH_KEY = " authorities";

    private final SecurityProperties properties;

    private final SysUserService sysUserService;


    /**
     * iss（Issuser） - 签发者
     * sub Subject 面向主体
     * aud Audience 接收方
     * exp Expiration time 过期时间戳
     * nbf Not Before, 开始生效时间戳
     * iat(Issued at) 签发时间
     * jti(JWT ID)： 唯一标识
     *
     * @param authentication
     * @return
     */
    public String createToken(Authentication authentication) {
        List<String> authorities = sysUserService.getAllPermissCodeByUsername(authentication.getName());
        Date date = DateUtil.offsetMinute(new Date(), properties.getExpiresAt());
        return JWT.create()
                .withExpiresAt(date)
                .withNotBefore(new Date())
                .withSubject(authentication.getName())
                .withAudience(properties.getAudience())
                .withArrayClaim(AUTH_KEY, authorities.toArray(new String[authorities.size()]))
                .withJWTId(IdUtil.randomUUID())
                .sign(Algorithm.HMAC256(properties.getKey()));
    }

    public Payload decodeToken(String token) {
        Payload payLoad = JWT.decode(token);
        return payLoad;
    }

    public void verifyToken(String token) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(properties.getKey())).build();

        jwtVerifier.verify(token);
    }

    public Authentication getAuthentication(String token) {
        verifyToken(token);
        Payload payload = decodeToken(token);
        Claim authoritiesClaim = payload.getClaim(AUTH_KEY);
        List<String> authoritieList = authoritiesClaim.asList(String.class);
        List<GrantedAuthority> authorities = authoritieList.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        UserDTO userDTO = new UserDTO();
        SysUser sysUser = sysUserService.findByUsername(payload.getSubject());
        BeanUtil.copyProperties(sysUser, userDTO);
        SecurityUserDTO principal = new SecurityUserDTO(userDTO, authorities);
        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }


}
