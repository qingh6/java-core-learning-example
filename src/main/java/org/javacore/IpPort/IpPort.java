package org.javacore.IpPort;

import java.util.HashMap;
import java.util.Map;

/**
 * IP地址和port端口号，映射到指定的IP和端口号
 */
public class IpPort {

    private String origIP_Port_1="11.111.0.51:8081";
    private String origIP_Port_2="11.112.0.52:8082";
    private String origIP_Port_3="11.113.0.53:8083";
    private String origIP_Port_4="11.114.0.54:8084";

    private String destIP_Port_1="66.111.0.61:19901";
    private String destIP_Port_2="66.112.0.62:19902";
    private String destIP_Port_3="66.113.0.63:19903";
    private String destIP_Port_4="66.114.0.64:19904";
    public static void main(String[] args) {

        String httpString = "http://11.112.0.5:8083/v1/v3333333/4444555/ttttttttttttt666gfdsgfdsgfdshsj/fgdsgfdsgdfgdfds";
        String sssString ="";
        if (httpString.contains("11.112.0.5:8083")){


        }
        origIp2destIp("11.112.0.53:8083");
    }
    public static String origIp2destIp(String ip_port){

        //原始的IP和端口
        Map<String, String> origMap = new HashMap();
        origMap.put("origIP_Port_1","11.111.0.51:8081");
        origMap.put("origIP_Port_2","11.112.0.52:8082");
        origMap.put("origIP_Port_3","11.113.0.53:8083");
        origMap.put("origIP_Port_4","11.114.0.54:8084");
        //目标的IP和 端口号
        Map<String, String> destMap = new HashMap();
        destMap.put("destIP_Port_1","66.111.0.61:19901");
        destMap.put("destIP_Port_2","66.112.0.62:19902");
        destMap.put("destIP_Port_3","66.113.0.63:19903");
        destMap.put("destIP_Port_4","66.114.0.64:19904");
        //原始的ip和目标的ip映射关系
        Map<String, String> origDestMap = new HashMap();
        origDestMap.put("origIP_Port_1","destIP_Port_1");
        origDestMap.put("origIP_Port_2","destIP_Port_2");
        origDestMap.put("origIP_Port_3","destIP_Port_3");
        origDestMap.put("origIP_Port_4","destIP_Port_4");
        String origMapString="";
        String destMapString="";
        for(String key:origMap.keySet()) {
            System.out.println("origMap key="+key+" value="+origMap.get(key));
            if(ip_port.equals(origMap.get(key))){
                System.out.println("origMap key="+key+" value="+origMap.get(key));
                origMapString = key;
                break;
            }
        }
        String origDestString = origDestMap.get(origMapString);
        destMapString = destMap.get(origDestString);
        System.out.println("destMapString = "+destMapString);
        return destMapString;
    }

}
