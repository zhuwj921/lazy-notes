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

    /**
     * 请求头部
     */
    private String header;
    /**
     * 请求token前缀
     */
    private String tokenPrefix;
    /**
     * 密钥key
     */
    private String key;
    /**
     * token有效期
     */
    private Integer expiresAt;
    /**
     * 接收方
     */
    private String audience;
}
