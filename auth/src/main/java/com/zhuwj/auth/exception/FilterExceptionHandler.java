package com.zhuwj.auth.exception;

import com.zhuwj.common.enums.ErrorCodeEnum;
import com.zhuwj.common.response.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 处理拦截器异常控制器
 * @author: zhuwj
 * @create: 2020-05-17 19:41
 **/
@RestController
public class FilterExceptionHandler {

    @RequestMapping("tokenExpiredException")
    public ResponseResult hanldeTokenExpiredException() {
        return ResponseResult.error(ErrorCodeEnum.TOKEN_OVERDUE);
    }

    @RequestMapping("jwtVerificationException")
    public ResponseResult hanldeJwtVerificationException() {
        return ResponseResult.error(ErrorCodeEnum.TOKEN_VALIDATE_FAIL);
    }
}
