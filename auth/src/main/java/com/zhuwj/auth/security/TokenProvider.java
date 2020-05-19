package com.zhuwj.auth.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.Payload;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhuwj.auth.config.SecurityProperties;
import com.zhuwj.auth.entity.SysResource;
import com.zhuwj.auth.entity.SysUser;
import com.zhuwj.auth.entity.SysUserRole;
import com.zhuwj.auth.model.dto.SecurityUserDTO;
import com.zhuwj.auth.model.dto.UserDTO;
import com.zhuwj.auth.service.ISysResourceService;
import com.zhuwj.auth.service.ISysUserRoleService;
import com.zhuwj.auth.service.ISysUserService;
import com.zhuwj.common.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
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
public class TokenProvider {

    @Autowired
    private SecurityProperties properties;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysResourceService sysResourceService;
    @Autowired
    private ISysUserRoleService sysUserRoleService;

    private static final String AUTH_KEY = " authorities";

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
        List<String> authorities = sysResourceService.findResourceByUsername(authentication.getName()).stream().map(SysResource::getPermission).collect(Collectors.toList());
        Date date = DateUtils.addMinutes(new Date(), properties.getExpiresAt());
        return JWT.create()
                .withExpiresAt(date)
                .withNotBefore(new Date())
                .withSubject(authentication.getName())
                .withAudience(properties.getAudience())
                .withArrayClaim(AUTH_KEY, authorities.toArray(new String[authorities.size()]))
                .withJWTId(IdUtil.get4UUID())
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
        Collection<GrantedAuthority> authorities = authoritieList.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(authorities);
        //自定义添加属性 可多个
        UserDTO userDTO = new UserDTO();
        SysUser sysUser = userService.findByUsername(payload.getSubject());

        userDTO.init(sysUser);
        SecurityUserDTO principal = new SecurityUserDTO(userDTO, CollectionUtils.isNotEmpty(grantedAuthorities) ? grantedAuthorities : new ArrayList<>());
        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }


}
