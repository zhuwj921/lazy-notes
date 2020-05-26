package com.zhuwj.bootstrap;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Description: 项目启动类入口
 *
 * @author zhuwj
 * @version V1.0
 * @date 2020-05-26
 */
@ComponentScan(basePackages = {"com.zhuwj"})
@MapperScan("com.zhuwj.*.mapper")
@SpringBootApplication
public class BootstrapApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootstrapApplication.class, args);
    }

}
