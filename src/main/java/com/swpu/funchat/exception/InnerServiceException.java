package com.swpu.funchat.exception;

/**
 * Description: funchat
 * Created by Zhu Peng on 2019/6/23
 */
public class InnerServiceException extends RuntimeException {
    public InnerServiceException() {
        super("服务器内部错误。");
    }
}
