package com.zhuwj.quartz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @description: quartz启动类
 * @author: zhuwj
 * @create: 2020-05-25 21:46
 **/
@ComponentScan(basePackages = {"com.zhuwj"})
@MapperScan("com.zhuwj.*.mapper")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class QuartzApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuartzApplication.class, args);
    }

}
