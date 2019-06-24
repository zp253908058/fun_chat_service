package com.swpu.funchat.oauth.exception;

/**
 * Description: funchat
 * Created by Zhu Peng on 2019/6/23
 */
public class IllegalPhoneNumberException extends RuntimeException {
    public IllegalPhoneNumberException() {
        super("phone number is illegal.");
    }
}
