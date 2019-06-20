package com.swpu.funchat.oauth.exception;

/**
 * Class description:
 *
 * @author zp
 * @version 1.0
 * @see DifferentPasswordException
 * @since 2019-06-19
 */
public class DifferentPasswordException extends RuntimeException {
    public DifferentPasswordException() {
        super("password is different.");
    }
}
