package com.esteel.oauth.config.auth;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ESTeel
 * Description:
 * User: zhangxiuzhi
 * Date: 2017-12-15
 * Time: 16:19
 */
public class ESteelAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//
//        System.out.println("000000000000000");
//        System.out.println("000000000000000");
//        System.out.println("000000000000000");
//
//        Object details = authentication.getDetails();
//        System.out.println(details.getClass().getName());
//
//        return authentication;
//
////        return null;
//    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

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
//        return (authentication instanceof UsernamePasswordAuthenticationToken);
       return  (UsernamePasswordAuthenticationToken.class
                .isAssignableFrom(authentication));

    }
}
