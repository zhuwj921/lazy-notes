package com.zhuwj.auth.security;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Title: token拦截器
 * Description: token的拦截器 处理凭证token验证
 *
 * @author zhuwj
 * @version V1.0
 * @date 2020-05-15
 */

public class TokenFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //获取token，判断是否生效

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
