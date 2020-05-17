package com.zhuwj.auth.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @title: security 配置
 * @description: 安全配置信息
 * @author: zhuwj
 * @create: 2020-05-16 14:37
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class SecurityProperties {

    private String header;

    private String tokenPrefix;

    private String key;

    private Integer expiresAt;

    private String audience;
}
