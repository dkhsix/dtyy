package com.rj.utils;

import lombok.Data;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author DKH
 * @version 1.0.0
 * @ClassName HttpClient.java
 * @Description 请求类
 * @createTime 2021年11月27日 14:15:00
 */
@Data
@SuppressWarnings("all")
public class HttpClient {

    private static volatile HttpClient hc;

    private HttpClient(){}

    public static HttpClient getInstance(){
        if (hc == null) {
            synchronized (HttpClient.class) {
                if (hc == null) {
                    hc = new HttpClient();
                }
            }
        }
        return hc;
    }

    /**
     *  请求头
     */
    public static Map<String, String> getHeader() {
        Map<String, String> header = new HashMap<>();
        header.put("User-Agent", " Mozilla/5.0 (iPhone; CPU iPhone OS 16_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148 MicroMessenger/8.0.27(0x18001b37) NetType/4G Language/zh_CN");
        header.put("content-type", "application/x-www-form-urlencoded");
        header.put("Host", "qdapp.hbsi.edu.cn");
        header.put("Referer", "https://servicewechat.com/wx4fc40b2404f46250/5/page-frame.html");
        return header;
    }

    /**
     * post请求
     */
    public String post(String myUrl,Map<String,String> params)  {
        try {
            HttpPost post = new HttpPost(myUrl);
            List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
            // 请求参数
            if (params != null) {
                for (String param:params.keySet()) {
                    list.add(new BasicNameValuePair(param, params.get(param)));
                }
                post.setEntity(new UrlEncodedFormEntity(list, "utf-8") );
            }
            // 请求头
            getHeader().forEach(post::addHeader);
            CloseableHttpClient client = HttpClients.createDefault();
            //启动执行请求，并获得返回值
            CloseableHttpResponse response = client.execute(post);
            HttpEntity entity = response.getEntity();
            //把实体对象转换为string
            return EntityUtils.toString(entity, "utf-8");
        }  catch (IOException e) {
            e.getMessage();
        }
        return "";
    }
    /**
     * 上传临时素材
     */
//    public static String postUpload(String  filePath,String fileName,String type){
//        HttpPost post = new HttpPost(BaseUrl.UPLOAD_1.replace("ACCESS_TOKEN",new MessageUtil().getAccess_token()).replace("TYPE",type));
//        File file = new File(filePath);
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        HttpEntity entity = null;
//        HttpResponse response = null;
//        List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
//        String BoundaryStr = "------------7da2e536604c8";
//        post.addHeader("Connection", "keep-alive");
//        post.addHeader("Accept", "*/*");
//        post.addHeader("Content-Type", "multipart/form-data;boundary=" + BoundaryStr);
//        post.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
//        list.add(new BasicNameValuePair("media", params.get(param)));
//           post.setEntity();
//    }

    /**
     * get请求
     * @return
     */
    public String get(String myUrl) {
        HttpGet get = new HttpGet(myUrl);
        CloseableHttpClient client = HttpClients.createDefault();
        //启动执行请求，并获得返回值
        CloseableHttpResponse response = null;
        try {
            // 请求头
            getHeader().forEach(get::addHeader);
            response = client.execute(get);
            HttpEntity entity = response.getEntity();
            //把实体对象转换为string
            return EntityUtils.toString(entity, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


}
