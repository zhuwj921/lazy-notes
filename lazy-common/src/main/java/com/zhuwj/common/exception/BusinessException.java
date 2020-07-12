package com.zhuwj.common.exception;


import com.zhuwj.common.enums.ErrorCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Description: 业务异常定义
 * Date:      2020/5/13
 * author     zhuwj
 * version    V1.0
 */
@AllArgsConstructor
@Data
public class BusinessException extends RuntimeException {

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


    /**
     * 错误枚举类
     *
     * @param codeEnum
     */
    public BusinessException(ErrorCodeEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMsg();
    }

}
