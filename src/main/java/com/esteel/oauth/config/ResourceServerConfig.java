package com.esteel.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import javax.sql.DataSource;

/**
 * ESTeel
 * Description:
 * User: zhangxiuzhi
 * Date: 2017-10-30
 * Time: 11:43
 */
@Configuration
@EnableResourceServer
@EnableWebSecurity
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;

    @Autowired
    public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select code as username,password,1 from opm_user where code =?")

                .authoritiesByUsernameQuery("select u.code as username ,r.name as authority from opm_role r, opm_user_role ru, opm_user u where r.id = ru.roleid and ru.userid=u.id and u.code=?  ")
                .passwordEncoder(new EsteelPasswordEncoder());
        ;

//        auth.inMemoryAuthentication().withUser("user").password("123456").roles("USER");
//        auth.authenticationProvider()
    }
}
