package org.javacore.xml2json;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.javacore.utils.XMLUtil_1;
import org.javacore.xml2json.domain.ZhiMaWatchListDetailXml;
import org.javacore.xml2json.domain.ZmWatchListDetail;
import org.javacore.xml2json.domain.ZmWatchListResponse;
import org.javacore.xml2json.domain.ZmWatchXml;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * xml转换成json
 */
public class Xml2JsonMain {

    public static void main(String[] args) {

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
            xml2Json(response);
        } catch (Exception e) {
            System.out.println("错误！");
        }
//         testJson2String();
    }

    public static void xml2Json(String response) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        ZmWatchXml xml = XMLUtil_1.fromXML(ZmWatchXml.class, response);
        if (xml != null) {
            ZmWatchListResponse zmResponse = new ZmWatchListResponse();
            zmResponse.setSuccess(true);
            zmResponse.setBizNo(xml.getZmWatchList().getBizNo());
            zmResponse.setIsMatched("Y".equals(xml.getZmWatchList().getIsMatched()) ? true : false);

//            if(!CollectionUtils.isEmpty(xml.getZmWatchList().getZhiMaWatchListDetails())){
            if (1 == 1) {
                List<ZmWatchListDetail> codes = new ArrayList<>();
                for (int i = 0; i < xml.getZmWatchList().getZhiMaWatchListDetails().size(); i++) {
                    ZhiMaWatchListDetailXml zhiMaWatchListDetailXml = xml.getZmWatchList().getZhiMaWatchListDetails().get(i);
                    String date = zhiMaWatchListDetailXml.getRefreshTime();
//                    logger.info("时间：{}",date);
                    ZmWatchListDetail zmWatchListDetail = new ZmWatchListDetail(zhiMaWatchListDetailXml.getBizCode(),
                        zhiMaWatchListDetailXml.getCode(),
                        zhiMaWatchListDetailXml.getZhiMaWatchListExtendInfos(),
                        zhiMaWatchListDetailXml.getLevel(),
                        zhiMaWatchListDetailXml.getRefreshTime(),
                        "Y".equals(zhiMaWatchListDetailXml.getSettlement()) ? true : false,
                        zhiMaWatchListDetailXml.getStatement(),
                        zhiMaWatchListDetailXml.getStatus(),
                        zhiMaWatchListDetailXml.getType());
                    codes.add(zmWatchListDetail);
                }
                zmResponse.setDetails(codes);

            }

            response = objectMapper.writeValueAsString(zmResponse);
        }
    }

    public String testJson2String() throws Exception {
        String response = JSON.parseObject(IOUtils.toString(getClass().getResourceAsStream("/testRuleDetailResult.json"), Charset.forName("UTF-8")), String.class);
        return response;
    }

    static class Xml {
        public String testJson2String() throws Exception {
            String response = JSON.parseObject(IOUtils.toString(getClass().getResourceAsStream("/testRuleDetailResult.json"), Charset.forName("UTF-8")), String.class);
            return response;
        }
    }


}
