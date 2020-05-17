package com.zhuwj.auth.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * @description: 密码加密验证工具
 * @author: zhuwj
 * @create: 2020-05-16 18:10
 **/
public class PasswordEncodeUtil {

    public static String encode(String passowrd) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(passowrd);
    }

    public static boolean validatePassword(String password, String oldPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(password, oldPassword);
    }
}
