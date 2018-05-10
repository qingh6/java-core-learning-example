package org.javacore.random;

import java.util.Random;

/**
 * 随机数的产生
 */
public class RanDomMain {

    public static void main(String args[]) {

        for(int i=0;i<1000;i++){
            int random = new Random().nextInt(4); //随机数的产生范围为[0,4);
            System.out.println("100以内的随机数:"+random);
        }

    }
}
