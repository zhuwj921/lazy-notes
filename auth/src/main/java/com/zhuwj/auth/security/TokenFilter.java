package com.zhuwj.auth.security;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.zhuwj.auth.config.SecurityProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Title: token拦截器
 * Description: token的拦截器 处理凭证token验证
 *
 * @author zhuwj
 * @version V1.0
 * @date 2020-05-15
 */
@Slf4j
@RequiredArgsConstructor
public class TokenFilter extends GenericFilterBean {

    private final TokenProvider tokenProvider;

    private final SecurityProperties properties;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //获取token 得到authentication
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String token = resolveToken(httpServletRequest);
        if (StrUtil.isNotBlank(token)) {
            Authentication authentication = null;
            try {
                authentication = tokenProvider.getAuthentication(token);
            } catch (TokenExpiredException e) {
                log.debug("jwt TokenExpiredException",e);
                servletRequest.getRequestDispatcher("/tokenExpiredException").forward(servletRequest, servletResponse);
            }catch (JWTVerificationException e){
                log.debug("jwt JWTVerificationException",e);
                servletRequest.getRequestDispatcher("/jwtVerificationException").forward(servletRequest, servletResponse);

            }
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    /**
     * 获取去除前缀的token
     *
     * @param request
     * @return
     */
    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(properties.getHeader());
        if (StrUtil.isNotBlank(bearerToken) && bearerToken.startsWith(properties.getTokenPrefix())) {
            return bearerToken.replace(properties.getTokenPrefix(), "").trim();
        }
        return null;
    }
}
