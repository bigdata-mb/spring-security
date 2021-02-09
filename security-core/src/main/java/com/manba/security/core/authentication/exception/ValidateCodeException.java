package com.manba.security.core.authentication.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * descriptions: 验证码校验
 * author: clark
 * date: 2021-02-09
 */
public class ValidateCodeException extends AuthenticationException {
    public ValidateCodeException(String msg, Throwable t) {
        super(msg, t);
    }

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
