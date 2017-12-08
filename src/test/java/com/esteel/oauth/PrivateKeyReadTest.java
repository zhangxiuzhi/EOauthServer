package com.esteel.oauth;

import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.io.IOException;
import java.security.KeyPair;

/**
 * ESTeel
 * Description:
 * User: zhangxiuzhi
 * Date: 2017-12-07
 * Time: 下午9:44
 */
public class PrivateKeyReadTest {




    public static void main(String[] args) {

        ClassPathResource classPathResource = new ClassPathResource("keystore.jks");

        try {
            System.out.println(classPathResource.getURL().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        KeyPair keyPair = new KeyStoreKeyFactory(
                new ClassPathResource("keystore.jks"), "123456".toCharArray())
                .getKeyPair("zxz");

    }
}
