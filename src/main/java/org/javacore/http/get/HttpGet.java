package org.javacore.http.get;

import com.sun.deploy.util.StringUtils;

import java.net.URI;
import java.util.*;

/**
 * HTTP的GET方法
 */
public class HttpGet {

//    private RestTemplate restTemplate;
    public static void main(String args[]){

//     invoke(params);



    }
    public static String invoke(Map<String,Object> params){
//        HttpHeaders requestHeaders = new HttpHeaders();
//        requestHeaders.add(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=UTF-8");
//
//        if(params == null){
//            params = new HashMap<String, Object>();
//        }
//        params.put(AK, bdNiProperties.getAk());
//        params.put(OUTPUT, bdNiProperties.getOutput());
//
//        HttpEntity<String> requestEntity = new HttpEntity<String>(null, requestHeaders);
//        ResponseEntity<String> response = null;
//        BdZhengResponse result = null;
//        String bdRepsponse=null;
//        try{
//            response = this.restTemplate.exchange(buildUri(this.bdNiProperties.getUrl(),params), HttpMethod.GET, requestEntity, String.class);
//            bdRepsponse = response.getBody().toString();
////            result =JSON.parseObject(response.getBody().toString(), BdZhengResponse.class);
//            result =JSON.parseObject(bdRepsponse, BdZhengResponse.class);
//            result = objectMapper.readValue(bdRepsponse, BdZhengResponse.class);
//        }catch (Exception ex){
////            throw new Exception("调用百度地图正向解析异常", ex);
//        }
//
//        if(HttpStatus.SC_OK != response.getStatusCodeValue()){
////            bdniLog.warn("FraudApiInvoker invokeHitRuleDetailForAnalysis error: {}",response.getStatusCodeValue());
//            return null;
//        }
//        if(result == null){
////            bdniLog.warn("FraudApiInvoker invokeHitRuleDetailForAnalysis response is null");
//        }

        return null;
    }

    private URI buildUri(String url, Map parametersMap) {
        if (parametersMap == null || parametersMap.isEmpty()) {
            return URI.create(url);
        }
        List<String> list = new ArrayList<String>();
        Iterator iterator = parametersMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            list.add(entry.getKey().toString().trim() + "=" + entry.getValue().toString().trim());
        }
        return list.isEmpty() ? URI.create(url) : URI.create(url + "?" + StringUtils.join(list, "&"));
    }
}
