package com.zhuwj.attachment;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages={"com.zhuwj"})
@SpringBootApplication
public class AttachmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(AttachmentApplication.class, args);
    }

}
