package com.esteel.oauth.config.auth;

import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.http.HttpServletRequest;

/**
 * ESTeel
 * Description:
 * User: zhangxiuzhi
 * Date: 2017-12-15
 * Time: 16:16
 */
public class ESteelWebAuthenticationDetailsSource extends WebAuthenticationDetailsSource {
    @Override
    public WebAuthenticationDetails buildDetails(HttpServletRequest context) {
        return new ESteelWebAuthenticationDetails(context);
    }

}
