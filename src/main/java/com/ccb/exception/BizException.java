package com.ccb.exception;

/**
 * @Description: 自定义异常
 * @Author: CCB
 * @Date: 2023/2/7 14:42
 */
public class BizException extends RuntimeException {

    public BizException() {

    }

    public BizException(String message) {
        super(message);
    }
}
