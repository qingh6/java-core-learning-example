package org.javacore.ipMac;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * 获取本地电脑的IP地址和Mac地址
 */
public class GetIp_Mac {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        InetAddress ip;
        String hostIpAddress = "";
        try {
            // 这种IP容易拿错
//            System.out.println("Current IP address : " +
//                InetAddress.getLocalHost().getHostAddress());
            // 正确的IP拿法
            hostIpAddress = getLocalHostLANAddress().getHostAddress();
            ip = InetAddress.getByName(hostIpAddress);
            System.out.println("get LocalHost LAN Address : " + getLocalHostLANAddress().getHostAddress());

            getLocalMacFromIp(ip);
        } catch (UnknownHostException e) {

            e.printStackTrace();

        }
    }

    // 正确的IP拿法，即优先拿site-local地址
    private static InetAddress getLocalHostLANAddress() throws UnknownHostException {
        try {
            InetAddress candidateAddress = null;
            // 遍历所有的网络接口
            for (Enumeration ifaces = NetworkInterface.getNetworkInterfaces(); ifaces.hasMoreElements(); ) {
                NetworkInterface iface = (NetworkInterface) ifaces.nextElement();
                // 在所有的接口下再遍历IP
                for (Enumeration inetAddrs = iface.getInetAddresses(); inetAddrs.hasMoreElements(); ) {
                    InetAddress inetAddr = (InetAddress) inetAddrs.nextElement();
                    if (!inetAddr.isLoopbackAddress()) {// 排除loopback类型地址
                        if (inetAddr.isSiteLocalAddress()) {
                            // 如果是site-local地址，就是它了
                            return inetAddr;
                        } else if (candidateAddress == null) {
                            // site-local类型的地址未被发现，先记录候选地址
                            candidateAddress = inetAddr;
                        }
                    }
                }
            }
            if (candidateAddress != null) {
                return candidateAddress;
            }
            // 如果没有发现 non-loopback地址.只能用最次选的方案
            InetAddress jdkSuppliedAddress = InetAddress.getLocalHost();
            if (jdkSuppliedAddress == null) {
                throw new UnknownHostException("The  JDK InetAddress.getLocalHost() method unexpectedly returned null.");
            }
            return jdkSuppliedAddress;
        } catch (Exception e) {
            UnknownHostException unknownHostException = new UnknownHostException(
                "Failed to determine LAN address: " + e);
            unknownHostException.initCause(e);
            throw unknownHostException;
        }
    }

    private static void getLocalMacFromIp(InetAddress ia) {
        // TODO Auto-generated method stub
        try {

            //获取网卡，获取地址
            byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
            System.out.println("mac数组长度：" + mac.length);
            StringBuffer sb = new StringBuffer("");
            for (int i = 0; i < mac.length; i++) {
                if (i != 0) {
                    sb.append("-");
                }
                //字节转换为整数
                int temp = mac[i] & 0xff;
                //10进制数转成16进制
                String str = Integer.toHexString(temp);
                System.out.println("每8位:" + str);
                //如果遇到单字符，前置0占位补满两格
                if (str.length() == 1) {
                    sb.append("0" + str);
                } else {
                    sb.append(str);
                }
            }
            System.out.println("本机MAC地址为:" + sb.toString().toUpperCase());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
