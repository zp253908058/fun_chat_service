package com.swpu.funchat.util;

import com.swpu.funchat.oauth.exception.*;

/**
 * Class description:
 *
 * @author zp
 * @version 1.0
 * @see Check
 * @since 2019-06-19
 */
public class Check {

    public static void checkUsername(String username) {
        if (username.equals("")) {
            throw new EmptyUsernameException();
        }
    }

    public static void checkPhone(String phone) {
        if (!Validator.isMobileNumber(phone)) {
            throw new IllegalPhoneNumberException();
        }
    }

    public static void checkPassword(String password) {
        if (password.equals("")) {
            throw new EmptyPasswordException();
        }
        if (password.length() < 6) {
            throw new PasswordTooShortException();
        }
    }

    public static void checkPassword(String p1, String p2) {
        if (!p1.equals(p2)) {
            throw new DifferentPasswordException();
        }
    }
}
