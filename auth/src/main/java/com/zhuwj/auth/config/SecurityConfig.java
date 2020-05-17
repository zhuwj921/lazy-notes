package com.zhuwj.auth.config;

import com.zhuwj.auth.security.SecurityAccessDeniedHandler;
import com.zhuwj.auth.security.SecurityAuthenticationEntryPoint;
import com.zhuwj.auth.security.TokenFilter;
import com.zhuwj.auth.security.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Spring security 配置
 * EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true) 开启注解权限
 *
 * @author zhuwj
 * @since 2020-05-15
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final SecurityAccessDeniedHandler securityAccessDeniedHandler;

    private final SecurityAuthenticationEntryPoint securityAuthenticationEntryPoint;

    private final SecurityProperties securityProperties;

    private final TokenProvider tokenProvider;
    /**
     * 去掉ROLE_ 前缀
     *
     * @return
     */
    @Bean
    GrantedAuthorityDefaults grantedAuthorityDefaults() {
        return new GrantedAuthorityDefaults("");
    }

    /**
     * 密码加密方式
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 配置Spring Security的过滤器
     * 忽略spring Security 对静态资源控制
     *
     * @param web
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/static");
    }

    /**
     * 配置userDetail服务
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
    }

    /**
     * 配置过滤器如何处理请求（登入方式，授权方式，url是否鉴权）
     *
     * @param http
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http    .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests().antMatchers("/auth/login").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .and().authorizeRequests().anyRequest().authenticated()
                .and().exceptionHandling().authenticationEntryPoint(securityAuthenticationEntryPoint).accessDeniedHandler(securityAccessDeniedHandler)
                .and().addFilterBefore(new TokenFilter(tokenProvider,securityProperties), UsernamePasswordAuthenticationFilter.class);
    }
}
