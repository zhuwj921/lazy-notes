package com.zhuwj.common.exception;


import com.zhuwj.common.enums.ErrorCodeEnum;

/**
 * Description: 权限异常定义
 * Date:      2020/5/13
 * author     zhuwj
 * version    V1.0
 */
public class AuthException extends RuntimeException {

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误消息
     */
    private String message;

    /**
     * 异常
     */
    private Exception exception;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    /**
     *
     * @param code 错误码
     * @param message 错误消息
     * @param exception 异常
     */
    public AuthException(String code, String message, Exception exception) {
        this.code = code;
        this.message = message;
        this.exception = exception;
    }

    /**
     *
     * @param code  错误码
     * @param message 错误消息
     */
    public AuthException(String code, String message) {
        this.code = code;
        this.message = message;
    }


    /**
     * 错误枚举类
     * @param codeEnum
     */
    public AuthException(ErrorCodeEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMsg();
    }
    public AuthException() {
    }
}
