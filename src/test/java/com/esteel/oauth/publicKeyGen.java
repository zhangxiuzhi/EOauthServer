package com.esteel.oauth;

import org.springframework.core.io.ClassPathResource;

import javax.security.cert.X509Certificate;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Base64;

/**
 * ESTeel
 * Description:
 * User: zhangxiuzhi
 * Date: 2017-10-20
 * Time: 23:10
 */
public class publicKeyGen {



    public static void main(String[] args) {

        try {
            KeyStore keyStore = KeyStore.getInstance("jks");

            ClassPathResource resource = new ClassPathResource("keystore1.jks");


            keyStore.load(resource.getInputStream(),"123456".toCharArray());

            Certificate zxz = keyStore.getCertificate("zxz");
            PublicKey publicKey = zxz.getPublicKey();

            byte[] encoded = publicKey.getEncoded();

            String public_key = Base64.getEncoder().encodeToString(encoded);

            Key key = keyStore.getKey("zxz", "123456".toCharArray());

            byte[] keyEncoded = key.getEncoded();

            String private_key = Base64.getEncoder().encodeToString(keyEncoded);

            System.out.println("private_key");
            System.out.println(private_key);

            System.out.println("public_key");
            System.out.println(public_key);


            ClassPathResource publicResource = new ClassPathResource("public.cer");


            X509Certificate cert = null;
            try {
                cert = X509Certificate.getInstance(publicResource.getInputStream());
            } catch (javax.security.cert.CertificateException e) {
                e.printStackTrace();
            }
            PublicKey pKey = cert.getPublicKey();

            String publicKeyString = Base64.getEncoder().encodeToString(publicKey.getEncoded());
            System.out.println("-----------------公钥--------------------");
            System.out.println(publicKeyString);
            System.out.println("-----------------公钥--------------------");

        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        }

    }
}
