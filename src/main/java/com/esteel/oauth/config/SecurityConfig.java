package com.esteel.oauth.config;

import com.esteel.oauth.config.auth.ESteelAuthenticationProvider;
import com.esteel.oauth.config.auth.ESteelLogoutSuccessHandler;
import com.esteel.oauth.config.auth.ESteelWebAuthenticationDetailsSource;
import com.esteel.oauth.config.auth.EsteelLoginUrlAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    @Bean // share AuthenticationManager for web and oauth
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {



       http.authenticationProvider(new ESteelAuthenticationProvider())
               .formLogin()
               .and().antMatcher("/**").authorizeRequests().antMatchers("/ulogin").permitAll().anyRequest().authenticated()
               .and()
               .exceptionHandling().authenticationEntryPoint(new EsteelLoginUrlAuthenticationEntryPoint("/ulogin"))
//                .formLogin()
//                .loginPage("/ulogin")
//                .loginProcessingUrl("/login")
//                .defaultSuccessUrl("/userInfo")

//                .authenticationDetailsSource(new ESteelWebAuthenticationDetailsSource())
//                .permitAll()
                .and()
               .logout().logoutSuccessHandler(new ESteelLogoutSuccessHandler())
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and().rememberMe()
                .and().csrf().disable()
        ;

    }
}
