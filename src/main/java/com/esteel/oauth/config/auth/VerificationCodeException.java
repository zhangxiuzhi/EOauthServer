package com.esteel.oauth.config.auth;


import org.springframework.security.core.AuthenticationException;

/**
 * ESTeel
 * Description: 用于标记验证验证失败的登录
 * User: zhangxiuzhi
 * Date: 2017-12-21
 * Time: 15:41
 */
public class VerificationCodeException extends AuthenticationException {
    public VerificationCodeException(String msg) {
        super(msg);
    }
}
