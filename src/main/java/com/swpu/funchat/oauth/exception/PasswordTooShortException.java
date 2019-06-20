package com.swpu.funchat.oauth.exception;

/**
 * Class description:
 *
 * @author zp
 * @version 1.0
 * @see PasswordTooShortException
 * @since 2019-06-19
 */
public class PasswordTooShortException extends RuntimeException {
    public PasswordTooShortException() {
        super("password is too short, password's length must >= 6.");
    }
}
