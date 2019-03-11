package org.javacore.security;

import java.util.Random;

/**
 * Created by lqh on 2018-11-2.
 */
public class GenerateString {
    public static final String ALLCHAR="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCdPKoFAaFDsAwYeluBmcMJV0fo7K40AVXkQcNZPYIr2MGvhY8xn3r6T6mE/ppQ2gpJTBVMtKjw7QE2QUjqrLA26orOwoo7qLKRVO3+QTe00I8hXztv7GpUbdhop6uHq0z6zhvWaJqicZOSMw7Z9cNny7b/+aHDWnx3VSmqOuSdUwIDAQAB";

    public static void main(String[] args){
        String getString = generateString(150);
    }

    public static String generateString(int length){

        StringBuffer sb = new StringBuffer();
        Random randomd  = new Random();
        for(int i = 0;i<length;i++){
            sb.append(ALLCHAR.charAt(randomd.nextInt(ALLCHAR.length())));
        }
        return sb.toString();
    }

}
