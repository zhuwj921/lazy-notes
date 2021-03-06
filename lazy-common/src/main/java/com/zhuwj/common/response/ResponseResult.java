package com.zhuwj.common.response;


import com.zhuwj.common.enums.ErrorCodeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @desc：返回处理结果
 * @author：zhuwj
 * @date：2020.05.10
 * @version：1.0.0
 */
@Data
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 8992436576262574064L;

    private String code;

    private String msg;

    private T result;

    private Long timestamp;


    /**
     * 系统定义的枚举错误返回结果
     *
     * @param errorCodeEnum
     * @return
     */
    public static <T> ResponseResult<T> error(ErrorCodeEnum errorCodeEnum) {
        return error(errorCodeEnum.getCode(), errorCodeEnum.getMsg(), null);
    }

    /**
     * 系统定义的枚举错误返回结果,并传入自定 result
     *
     * @param errorCodeEnum
     * @return
     */
    public static <T> ResponseResult<T> error(ErrorCodeEnum errorCodeEnum, T result) {
        return error(errorCodeEnum.getCode(), errorCodeEnum.getMsg(), result);
    }


    /**
     * 全部自定义消息 与错误码
     *
     * @param code
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> error(String code, String message, T result) {
        return new ResponseResult<T>()
                .result(result)
                .putTimeStamp()
                .code(code).msg(message);
    }

    /**
     * 自定义消息 与错误码
     *
     * @param code
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> error(String code, String message) {
        return new ResponseResult<T>()
                .putTimeStamp()
                .code(code).msg(message);
    }

    /**
     * 请求成功  默认code为0 掺入对应的返回结果
     *
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> ok() {
        return new ResponseResult<T>()
                .result(null)
                .putTimeStamp()
                .code(ErrorCodeEnum.OK.getCode()).msg(ErrorCodeEnum.OK.getMsg());
    }

    /**
     * 请求成功  默认code为0 掺入对应的返回结果
     *
     * @param result
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> ok(T result) {
        return new ResponseResult<T>()
                .result(result)
                .putTimeStamp()
                .code(ErrorCodeEnum.OK.getCode()).msg(ErrorCodeEnum.OK.getMsg());
    }

    public ResponseResult() {

    }

    private ResponseResult<T> putTimeStamp() {
        this.timestamp = System.currentTimeMillis();
        return this;
    }


    public ResponseResult<T> result(T result) {
        this.result = result;
        return this;
    }

    public ResponseResult<T> code(String code) {
        this.code = code;
        return this;
    }

    public ResponseResult<T> msg(String msg) {
        this.msg = msg;
        return this;
    }
}
