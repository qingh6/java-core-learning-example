package org.javacore.security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;

/**
 * Created by lqh on 2018/9/16.
 */
public class AesSecurity2 {
    private static String type = "AES";
    private static String secretKey = "12345678";
    public static void main(String[] args) throws Exception {
        String content = "1111111111111";
        // 加密
        System.out.println("加密前：" + content);
        String encryptResult = encryptStr(content,secretKey);
        System.out.println("加密后：" + encryptResult);
        // 解密
//        byte[] decryptResult = decryptStr(encryptResult,secretKey);
        String decryptResult = decryptStr(encryptResult,secretKey);
        System.out.println("解密后：" + decryptResult);
    }

    /**
     * 加密
     * @param srcFile
     * @param secretKey
     * @return
     */
    public static String encryptStr(String srcFile,String secretKey) throws Exception{

        //生成指定字符串的密钥
        Key key = getKey(secretKey);
        //创建密码器
        Cipher cipher = Cipher.getInstance(type + "/ECB/PKCS5Padding");
        byte[] byteContent = srcFile.getBytes("utf-8");
        // 初始化
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] result = cipher.doFinal(byteContent);
        String encryptResultStr = parseByte2HexStr(result);
        //返回密文
        return encryptResultStr;
    }

    /**
     *解密
     * @param srcFile
     * @param secretKey
     * @return
     */
    public static String decryptStr(String srcFile,String secretKey)throws Exception{
        byte[] decryptFrom = parseHexStr2Byte(srcFile);
        //生成指定字符串的密钥
        Key key = getKey(secretKey);
        //创建密码器
        Cipher cipher = Cipher.getInstance(type + "/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] result = cipher.doFinal(decryptFrom);
        String decryptString = new String(result);
        return decryptString;
    }
    /**
     * 生成指定字符串的密钥
     * @param secret        要生成密钥的字符串
     * @return secretKey    生成后的密钥
     */
    private static Key getKey(String secret) throws Exception {
//        logger.info("CipherUtil.getKey Start ......");
        KeyGenerator kgen = KeyGenerator.getInstance(type);
        kgen.init(128, new SecureRandom(secret.getBytes()));
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
//        logger.info("CipherUtil.getKey End ......");
        return key;
    }


    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }
}
