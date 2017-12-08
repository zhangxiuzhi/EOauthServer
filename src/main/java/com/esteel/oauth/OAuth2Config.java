package com.esteel.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;
import java.security.KeyPair;

/**
 * ESTeel
 * Description:
 * User: zhangxiuzhi
 * Date: 2017-10-16
 * Time: 17:09
 */

@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;

    @Autowired
    JedisConnectionFactory jedisConnectionFactory;


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(this.tokenStore()).tokenEnhancer(this.jwtTokenEnhancer()).authenticationManager(authenticationManager);
//        endpoints.tokenStore(this.tokenStore()).authenticationManager(authenticationManager);

    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()
                .withClient("acme")
                .secret("acmesecret")
                .authorizedGrantTypes("authorization_code", "refresh_token", "implicit", "password", "client_credentials")
                .scopes("webshop")
                .accessTokenValiditySeconds(20)
                .refreshTokenValiditySeconds(20)

                .autoApprove("webshop")
        ;

//        clients.jdbc(dataSource).clients()

    }

    @Bean
    protected JwtAccessTokenConverter jwtTokenEnhancer() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        KeyPair keyPair = new KeyStoreKeyFactory(
                new ClassPathResource("keystore1.jks"), "123456".toCharArray())
                .getKeyPair("zxz");
        converter.setKeyPair(keyPair);

        return converter;
    }

    @Bean
    public TokenStore tokenStore() {
//        return new RedisTokenStore(jedisConnectionFactory);
        return new JwtTokenStore(jwtTokenEnhancer());
    }
}
