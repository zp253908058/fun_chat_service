package com.swpu.funchat.oauth.exception;

/**
 * Class description:
 *
 * @author zp
 * @version 1.0
 * @see EmptyPasswordException
 * @since 2019-06-19
 */
public class EmptyPasswordException  extends RuntimeException {
    public EmptyPasswordException() {
        super("password is empty.");
    }
}