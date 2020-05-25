package com.zhuwj.event;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Description: 事件启动类
 *
 * @author zhuwj
 * @version V1.0
 * @date 2020-05-25
 */
@EnableAsync
@ComponentScan(basePackages={"com.zhuwj"})
@MapperScan("com.zhuwj.*.mapper")
@SpringBootApplication
public class EventAppliaction {
    public static void main(String[] args) {
        SpringApplication.run(EventAppliaction.class, args);
    }

}
