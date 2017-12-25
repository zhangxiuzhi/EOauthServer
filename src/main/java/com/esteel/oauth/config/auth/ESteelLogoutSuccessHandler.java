package com.esteel.oauth.config.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ESTeel
 * Description: 退出登录成功后，返回登录程序
 * User: zhangxiuzhi
 * Date: 2017-12-21
 * Time: 16:32
 */
public class ESteelLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String target = request.getParameter("target");

        response.sendRedirect(target);
    }
}
