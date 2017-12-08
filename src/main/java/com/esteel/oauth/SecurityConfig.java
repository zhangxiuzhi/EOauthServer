package com.esteel.oauth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * ESTeel
 * Description:
 * User: zhangxiuzhi
 * Date: 2017-10-16
 * Time: 17:07
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
//                .successForwardUrl("/sucess")

                .permitAll()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and().csrf().disable()
        ;
    }
}
