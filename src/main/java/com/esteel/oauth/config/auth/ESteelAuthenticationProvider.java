package com.esteel.oauth.config.auth;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;

/**
 * ESTeel
 * Description:
 * User: zhangxiuzhi
 * Date: 2017-12-15
 * Time: 16:19
 */
public class ESteelAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {


    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

        //grant_type=code时的处理逻辑 主要是为了增加验证码 支持短信登录等处理
        if (authentication.getDetails() instanceof ESteelWebAuthenticationDetails) {

            ESteelWebAuthenticationDetails details = (ESteelWebAuthenticationDetails) authentication.getDetails();

//        if (1==1){
//            throw new VerificationCodeException("111");
//        }
        }

        //grant_type=password时的处理逻辑
        if (authentication.getDetails() instanceof LinkedHashMap){

        }


        Collection<GrantedAuthority> authorities = authentication.getAuthorities();
        if (authorities == null || authorities.isEmpty()){
            authorities = new ArrayList<>();
        }
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        UserDetails user = new User(username,(String)authentication.getCredentials(), authorities);


        return user;
    }

    @Override
    public boolean supports(Class<?> authentication) {
       return  (UsernamePasswordAuthenticationToken.class
                .isAssignableFrom(authentication));

    }
}
