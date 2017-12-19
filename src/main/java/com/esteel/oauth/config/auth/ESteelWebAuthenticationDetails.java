package com.esteel.oauth.config.auth;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

/**
 * ESTeel
 * Description:
 * User: zhangxiuzhi
 * Date: 2017-12-15
 * Time: 16:12
 */
public class ESteelWebAuthenticationDetails extends WebAuthenticationDetails {

    private  String code ="";

    /**
     * Records the remote address and will also set the session Id if a session already
     * exists (it won't create one).
     *
     * @param request that the authentication request was received from
     */
    public ESteelWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        code = request.getParameter("code");
    }
}
