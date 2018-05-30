package org.javacore.ipMac;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * 获取本地电脑的Mac地址
 */
public class GetMacMain {

    public static void main(String[] args) throws UnknownHostException, SocketException {
        // TODO Auto-generated method stub

        //得到IP，输出PC-201309011313/122.206.73.83
        InetAddress ia = InetAddress.getLocalHost();
        System.out.println(ia);
        getLocalMac(ia);
    }
    private static void getLocalMac(InetAddress ia) throws SocketException {
        // TODO Auto-generated method stub
        //获取网卡，获取地址
        byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
        System.out.println("mac数组长度："+mac.length);
        StringBuffer sb = new StringBuffer("");
        for(int i=0; i<mac.length; i++) {
            if(i!=0) {
                sb.append("-");
            }
            //字节转换为整数
            int temp = mac[i]&0xff;
            //10进制数转成16进制
            String str = Integer.toHexString(temp);
            System.out.println("每8位:"+str);
            //如果遇到单字符，前置0占位补满两格
            if(str.length()==1) {
                sb.append("0"+str);
            }else {
                sb.append(str);
            }
        }
        System.out.println("本机MAC地址:"+sb.toString().toUpperCase());
    }
}
