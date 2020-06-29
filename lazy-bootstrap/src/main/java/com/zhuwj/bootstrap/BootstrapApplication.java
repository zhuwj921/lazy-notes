package com.zhuwj.bootstrap;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * Description: 项目启动类入口
 *
 * @author zhuwj
 * @version V1.0
 * @date 2020-05-26
 */
@EnableCaching
@ComponentScan(basePackages = {"com.zhuwj"})
@SpringBootApplication
public class BootstrapApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootstrapApplication.class, args);
    }

}
