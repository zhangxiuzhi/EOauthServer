package com.esteel.oauth;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * ESTeel
 * Description:
 * User: zhangxiuzhi
 * Date: 2017-10-24
 * Time: 11:44
 */
public class EsteelPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
     return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {

        if (encodedPassword==null||rawPassword==null){
            return false;
        }

        try {
            MessageDigest md5= MessageDigest.getInstance("MD5");


            byte[] out = md5.digest(rawPassword.toString().getBytes());

            return encodedPassword.equals(Base64.getEncoder().encodeToString(out));


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        System.out.println("in encode ...::" +rawPassword);

        System.out.println(rawPassword);
        System.out.println(encodedPassword);
        return false;
    }


}
