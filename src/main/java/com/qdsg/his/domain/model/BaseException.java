package com.qdsg.his.domain.model;

/**
 * @Author zhouligang
 * @Date 2023/3/6 9:50
 * @Desc 基础异常类
 */
public class BaseException extends RuntimeException{
    private Integer code;
    private String message;

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
    }
    public BaseException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
