package org.javacore.DES;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
/**
 * DES 对称加密
 */
public class SimpleDESede {
    public static void main(String[] args) throws Exception {
        // TODO 自动生成方法存根
        String testMassage = "this is a 测试.";
        //产生一个TripleDes密钥
        KeyGenerator keyGen = KeyGenerator.getInstance("DESede");
        keyGen.init(168);
        Key key = keyGen.generateKey();
        //用TripleDes密钥初始化cipher
        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] plaiText = testMassage.getBytes("UTF-8");
        //获得加密后的密文

        byte[] cipherText = cipher.doFinal(plaiText);
        System.out.println("加密后密文为：");
        printresult(cipherText);
        //重新初始cipher,使其可以解密模式，此时也可不重新生成Cipher,直接使用 cipher.init(Cipher.DECRYPT_MODE, key);
        Cipher cp1 = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cp1.init(Cipher.DECRYPT_MODE, key);
        System.out.println("原文为：");
        byte[] decryText = cp1.doFinal(cipherText);
        printresult(decryText);
    }

    private static void printresult(byte[] text) throws UnsupportedEncodingException {

        String result = new String(text,"UTF-8");
        System.out.println(result);
    }

}
