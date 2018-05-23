package org.javacore.xml2json;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.javacore.utils.XMLUtil_1;
import org.javacore.utils.XMLUtil_2;
import org.javacore.xml2json.domain.ZmWatchListResponse;
import org.javacore.xml2json.domain.ZmWatchXml;

import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;

/**
 * json转换成xml
 */
public class Json2XmlMain {

    public static void main(String[] args) {
        String jsonStr = "{\n" +
            "    \"success\": true,\n" +
            "    \"body\": null,\n" +
            "    \"params\": null,\n" +
            "    \"error_code\": null,\n" +
            "    \"error_message\": null,\n" +
            "    \"biz_no\": \"ea685fa6572e4614afe9339231a392f8\",\n" +
            "    \"details\": [\n" +
            "        {\n" +
            "            \"biz_code\": \"AA\",\n" +
            "            \"code\": \"AA001001\",\n" +
            "            \"extend_info\": [\n" +
            "                {\n" +
            "                    \"description\": \"description11\",\n" +
            "                    \"key\": \"key11\",\n" +
            "                    \"value\": \"value11\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"description\": \"description22\",\n" +
            "                    \"key\": \"key22\",\n" +
            "                    \"value\": \"value22\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"level\": 12,\n" +
            "            \"refresh_time\": \"2018-04-20 00:00:00\",\n" +
            "            \"settlement\": true,\n" +
            "            \"statement\": \"statement11\",\n" +
            "            \"status\": \"status333\",\n" +
            "            \"type\": \"type32\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"biz_code\": \"AA\",\n" +
            "            \"code\": \"AA001001\",\n" +
            "            \"extend_info\": [\n" +
            "                {\n" +
            "                    \"description\": \"description33\",\n" +
            "                    \"key\": \"key33\",\n" +
            "                    \"value\": \"value33\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"level\": 12,\n" +
            "            \"refresh_time\": \"2018-04-21 00:00:00\",\n" +
            "            \"settlement\": true,\n" +
            "            \"statement\": \"statement11\",\n" +
            "            \"status\": \"status333\",\n" +
            "            \"type\": \"type32\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"is_matched\": true\n" +
            "}";

        String response = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<ZmxyResponse>\n" +
            "\t<ZhiMaWatchList>\n" +
            "\t\t<is_matched>Y</is_matched>\n" +
            "\t\t<biz_no>ea685fa6572e4614afe9339231a392f8</biz_no>\n" +
            "\t\t<ZhiMaWatchListDetail>\n" +
            "\t\t\t<biz_code>AA</biz_code>\n" +
            "\t\t\t<code>AA001001</code>\n" +
            "\t\t\t<level>12</level>\n" +
            "\t\t\t<refreshTime>2018-04-20 00:00:00</refreshTime>\n" +
            "\t\t\t<settlement>Y</settlement>\n" +
            "\t\t\t<statement>statement11</statement>\n" +
            "\t\t\t<status>status333</status>\n" +
            "\t\t\t<type>type32</type>\n" +
            "\t\t\t<ZmWatchListExtendInfo>\n" +
            "\t\t\t\t<description>description11</description>\n" +
            "\t\t\t\t<key>key11</key>\n" +
            "\t\t\t\t<value>value11</value>\n" +
            "\t\t\t</ZmWatchListExtendInfo>\n" +
            "\t\t\t\t<ZmWatchListExtendInfo>\n" +
            "\t\t\t\t<description>description22</description>\n" +
            "\t\t\t\t<key>key22</key>\n" +
            "\t\t\t\t<value>value22</value>\n" +
            "\t\t\t</ZmWatchListExtendInfo>\n" +
            "\t\t</ZhiMaWatchListDetail>\n" +
            "\t\t<ZhiMaWatchListDetail>\n" +
            "\t\t\t<biz_code>AA</biz_code>\n" +
            "\t\t\t<code>AA001001</code>\n" +
            "\t\t\t<level>12</level>\n" +
            "\t\t\t<refreshTime>2018-04-21 00:00:00</refreshTime>\n" +
            "\t\t\t<settlement>Y</settlement>\n" +
            "\t\t\t<statement>statement11</statement>\n" +
            "\t\t\t<status>status333</status>\n" +
            "\t\t\t<type>type32</type>\n" +
            "\t\t\t<ZmWatchListExtendInfo>\n" +
            "\t\t\t\t<description>description33</description>\n" +
            "\t\t\t\t<key>key33</key>\n" +
            "\t\t\t\t<value>value33</value>\n" +
            "\t\t\t</ZmWatchListExtendInfo>\n" +
            "\t\t</ZhiMaWatchListDetail>\n" +
            "\t</ZhiMaWatchList>\n" +
            "</ZmxyResponse>";
        try {
            json2Xml(jsonStr);
//            bean2Xml(response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
//            System.out.println("错误！");
        }

    }

    /**
     * 1: xml转换成对象
     * 2：对象转换成 xml
     *
     * @param response
     * @throws Exception
     */
    public static void bean2Xml(String response) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        ZmWatchXml xml = XMLUtil_1.fromXML(ZmWatchXml.class, response);
        String xmlString = "";

        Marshaller marshaller = XMLUtil_2.getMarshaller(ZmWatchXml.class, true, "GBK");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        marshaller.marshal(xml, bos);
        String csReportStr = bos.toString("GBK");

        xmlString = csReportStr;

    }

    /**
     * 1：Json字符串转换成对象
     * 2：对象转换成XML
     *
     * @param jsonStr
     * @throws Exception
     */
    public static void json2Xml(String jsonStr) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        //1:不能深层次解Json数据
        ZmWatchListResponse zmWatchList = JSON.parseObject(jsonStr, ZmWatchListResponse.class);
        int j = 0;
        //2:能够深层解析Json字符串
        ZmWatchListResponse zmWatchListResponse = objectMapper.readValue(jsonStr, ZmWatchListResponse.class);
        String xmlString = "";

        Marshaller marshaller = XMLUtil_2.getMarshaller(ZmWatchListResponse.class, true, "UTF-8");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        marshaller.marshal(zmWatchListResponse, bos);
        String csReportStr = bos.toString("UTF-8");

        xmlString = csReportStr;
    }
}
