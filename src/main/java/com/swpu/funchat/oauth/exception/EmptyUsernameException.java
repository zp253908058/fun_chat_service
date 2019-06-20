package com.swpu.funchat.oauth.exception;

/**
 * Class description:
 *
 * @author zp
 * @version 1.0
 * @see EmptyUsernameException
 * @since 2019-06-19
 */
public class EmptyUsernameException extends RuntimeException {
    public EmptyUsernameException() {
        super("username is empty.");
    }
}
