package org.javacore.ioio;

/**
 * 字节和字符串之间 互相转换
 *1：中文字符—>字节  GBK编码 一个汉字2个字节
 *   中文字符—>字节  UTF-8编码 一个汉字3个字节
 *
 *2：数字字符—>字节  GBK编码 一个数据1个字节
 *   数字字符—>字节  UTF-8编码 一个数据1个字节
 *
 *3：英文字符—>字节  GBK编码 一个英文1个字节
 *   英文字符—>字节  UTF-8编码 一个英文1个字节
 */
public class Bytes2String {

    public static void main(String[] args){
        String strBook ="艺";
        String strNumber ="12367";
        String strZifu ="abZ";
        byte[] bookBytes;
        byte[] numberBytes;
        byte[] zifuBytes;
        try{
            bookBytes = strBook.getBytes("UTF-8");
            System.out.println("中文如下:");
            for (int i=0;i<bookBytes.length;i++){
                System.out.print(bookBytes[i] + " ");
            }

            numberBytes = strNumber.getBytes("GBK");
            System.out.println("数字如下:");
            for (int i=0;i<numberBytes.length;i++){
                System.out.print(numberBytes[i] + " ");
            }

            zifuBytes = strZifu.getBytes("GBK");
            System.out.println("字符如下:");
            for (int i=0;i<zifuBytes.length;i++){

                System.out.print(zifuBytes[i] + " ");
            }
            //字节转换成字符串
            System.out.println();
            String customerId = new String(numberBytes, 1, 3, "GBK").trim();
            System.out.println("customerId的字符串："+customerId);
        }catch(Exception e){

        }
    }
}
