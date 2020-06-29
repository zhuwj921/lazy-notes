package com.zhuwj.dict;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class DictApplication {

    public static void main(String[] args) {
        SpringApplication.run(DictApplication.class, args);
    }

}
