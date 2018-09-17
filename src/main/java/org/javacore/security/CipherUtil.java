//package org.javacore.security;
//
//
//import javax.crypto.Cipher;
//import javax.crypto.KeyGenerator;
//import javax.crypto.SecretKey;
//import java.io.*;
//import java.security.Key;
//import java.security.SecureRandom;
//
///**
// * @author yahongcai
// * @date 2018.7.30
// * @jdk.version 1.8
// * @desc 对文件进行加、解密工具类
// */
//public class CipherUtil {
//
//    private static String type = "AES";
//
//    /**
//     * 把文件srcFile加密后存储为destFile
//     * @param srcFile     加密前的文件
//     * @param destFile    加密后的文件
//     * @param secretKey  密钥
//     * @throws IOException
//     */
//    public static boolean encryptStr(String srcFile, String destFile, String secretKey) throws Exception, IOException {
////        logger.info("CipherUtil.encryptStr Start ......");
////        logger.info("CipherUtil.encryptStr srcFile="+srcFile+";destFile="+destFile+";secretKey="+secretKey);
//        boolean encryptFlg = true;
//        Key key = getKey(secretKey);
//        Cipher cipher = Cipher.getInstance(type + "/ECB/PKCS5Padding");
//        cipher.init(Cipher.ENCRYPT_MODE, key);
//
//        FileInputStream fis = null;
//        FileOutputStream fos = null;
//        try {
//            fis = new FileInputStream(srcFile);
//            fos = new FileOutputStream(FileUtils.mkdirFiles(destFile));
//
//            cryptStream(fis, fos, cipher);
//        } catch (Exception e) {
////            logger.error(e.getMessage());
//            encryptFlg = false;
//        }  finally {
//            if (fis != null) {
//                fis.close();
//            }
//            if (fos != null) {
//                fos.close();
//            }
//        }
////        logger.info("CipherUtil.encryptStr encryptFlg="+encryptFlg);
////        logger.info("CipherUtil.encryptStr End ......");
//        return encryptFlg;
//    }
//
//    /**
//     * 把文件srcFile解密后存储为destFile
//     * @param srcFile     解密前的文件
//     * @param destFile    解密后的文件
//     * @param secretKey  密钥
//     * @throws Exception
//     */
//    public static boolean decryptStr(String srcFile, String destFile, String secretKey) throws Exception {
////        logger.info("CipherUtil.decryptStr Start ......");
////        logger.info("CipherUtil.decryptStr srcFile="+srcFile+";destFile="+destFile+";secretKey="+secretKey);
//        boolean decryptFlg = true;
//        Key key = getKey(secretKey);
//        Cipher cipher = Cipher.getInstance(type + "/ECB/PKCS5Padding");
//        cipher.init(Cipher.DECRYPT_MODE, key);
//
//        FileInputStream fis = null;
//        FileOutputStream fos = null;
//        try {
//            fis = new FileInputStream(srcFile);
//            fos = new FileOutputStream(FileUtils.mkdirFiles(destFile));
//
//            cryptStream(fis, fos, cipher);
//        } catch (Exception e) {
////            logger.error(e.getMessage());
//            decryptFlg = false;
//        } finally {
//            if (fis != null) {
//                fis.close();
//            }
//            if (fos != null) {
//                fos.close();
//            }
//        }
////        logger.info("CipherUtil.decryptStr decryptFlg="+decryptFlg);
////        logger.info("CipherUtil.decryptStr End ......");
//        return decryptFlg;
//    }
//
//    /**
//     * 加密解密流
//     * @param in        加密解密前的流
//     * @param out       加密解密后的流
//     * @param cipher    加密解密
//     * @throws IOException
//     */
//    private static void cryptStream(InputStream in, OutputStream out, Cipher cipher) throws Exception {
////        logger.info("CipherUtil.cryptStream Start ......");
//        int blockSize = cipher.getBlockSize() * 1000;
//        int outputSize = cipher.getOutputSize(blockSize);
//
//        byte[] inBytes = new byte[blockSize];
//        byte[] outBytes = new byte[outputSize];
//
//        int inLength = 0;
//        boolean more = true;
//        while (more) {
//            inLength = in.read(inBytes);
//            if (inLength == blockSize) {
//                int outLength = cipher.update(inBytes, 0, blockSize, outBytes);
//                out.write(outBytes, 0, outLength);
//            } else {
//                more = false;
//            }
//        }
//        if (inLength > 0){
//            outBytes = cipher.doFinal(inBytes, 0, inLength);
//        } else {
//            outBytes = cipher.doFinal();
//        }
//        out.write(outBytes);
////        logger.info("CipherUtil.cryptStream End ......");
//    }
//
//
//    /**
//     * 生成指定字符串的密钥
//     * @param secret        要生成密钥的字符串
//     * @return secretKey    生成后的密钥
//     */
//    private static Key getKey(String secret) throws Exception {
////        logger.info("CipherUtil.getKey Start ......");
//        KeyGenerator kgen = KeyGenerator.getInstance(type);
//        kgen.init(128, new SecureRandom(secret.getBytes()));
//        SecretKey secretKey = kgen.generateKey();
////        logger.info("CipherUtil.getKey End ......");
//        return secretKey;
//
//    }
//}
