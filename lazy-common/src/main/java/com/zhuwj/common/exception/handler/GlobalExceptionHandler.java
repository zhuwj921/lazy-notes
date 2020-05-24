package com.zhuwj.common.exception.handler;

import com.zhuwj.common.enums.ErrorCodeEnum;
import com.zhuwj.common.exception.AuthException;
import com.zhuwj.common.exception.BusinessException;
import com.zhuwj.common.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @description: 全局异常处理
 * @author: zhuwj
 * @create: 2020-05-17 18:56
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 未定义的异常
     */
    @ExceptionHandler(Throwable.class)
    public ResponseResult handleException(Throwable e) {
        // 打印堆栈信息
        log.error("Throwable handleException", e);
        return ResponseResult.error(ErrorCodeEnum.ERROR, e.getMessage());
    }

    /**
     * 所有业务异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseResult handleBusinessException(BusinessException e) {
        // 打印堆栈信息
        log.error("Throwable handleException", e);
        return ResponseResult.error(e.getCode(), e.getMessage());
    }

    /**
     * 授权异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(AuthException.class)
    public ResponseResult handleAuthException(BusinessException e) {
        // 打印堆栈信息
        log.error("Throwable AuthException", e);
        return ResponseResult.error(e.getCode(), e.getMessage());
    }

}
