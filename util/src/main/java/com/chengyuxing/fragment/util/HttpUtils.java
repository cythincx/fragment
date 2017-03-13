package com.chengyuxing.fragment.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: mt-chengyuxing
 * Date: 2017/3/13
 * Time: 下午5:57
 * Desc:
 */
public class HttpUtils {
    private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    private static CloseableHttpClient httpClient;

    private static String defaultChaset = "UTF-8";

    public static final int defaultSocketTimeout = 2000;

    public static final int defaultConnectTimeout = 2000;

    private static final RequestConfig defaultConfig = RequestConfig.custom().setSocketTimeout(defaultSocketTimeout).setConnectTimeout(defaultConnectTimeout).build();

    static{
        httpClient = HttpClients.createDefault();
    }

    /**
     * get 不带参数
     * @param url
     * @return
     */
    public static String get(String url){
        String res = "";
        HttpGet get = new HttpGet(url);
        get.setConfig(defaultConfig);
        res = baseGet(get);
        return res;
    }

    /**
     * get 带参数
     * @param url
     * @param params
     * @return
     */
    public static String get(String url, Map<String, String> params){
        url = getUrl(url, params);
        return get(url);
    }

    /**
     * post(以json格式)
     * @param url
     * @param jsonObject
     * @return
     */
    public static String postJson(String url, JSONObject jsonObject){
        HttpPost post = new HttpPost(url);
        StringEntity entity = getPostJsonEntity(jsonObject);
        post.setEntity(entity);
        post.setConfig(defaultConfig);
        return basePost(post);
    }

    /**
     * post(以json格式)
     * @param url
     * @param jsonObject
     * @return
     */
    public static String postJson(String url, Map<String, String> headers, JSONObject jsonObject){
        HttpPost post = new HttpPost(url);
        setHeader(post, headers);
        StringEntity entity = getPostJsonEntity(jsonObject);
        post.setEntity(entity);
        post.setConfig(defaultConfig);
        return basePost(post);
    }

    /**
     * post(以表单格式)
     * @param url
     * @param params
     * @return
     */
    public static String postForm(String url, Map<String, String> params){
        HttpPost post = new HttpPost(url);
        StringEntity entity = getPostFormEntity(params);
        if(null != entity){
            post.setEntity(entity);
        }
        post.setConfig(defaultConfig);
        return basePost(post);
    }

    /**
     * post(以表单格式)
     * @param url
     * @param headers
     * @param params
     * @return
     */
    public static String postForm(String url, Map<String, String> headers,  Map<String, String> params){
        HttpPost post = new HttpPost(url);
        setHeader(post, headers);
        StringEntity entity = getPostFormEntity(params);
        if(null != entity){
            post.setEntity(entity);
        }
        post.setConfig(defaultConfig);
        return basePost(post);
    }

    private static String baseGet(HttpGet get){
        String res = "";
        CloseableHttpResponse httpResponse = null;
        try{
            httpResponse = httpClient.execute(get);
            HttpEntity responseEntity = httpResponse.getEntity();
            if( null != responseEntity){
                res = EntityUtils.toString(responseEntity);
            }
            EntityUtils.consume(responseEntity);
        }catch (IOException e){
            logger.error("http get failed!",e);
        }finally {
            if(null != httpResponse){
                try {
                    httpResponse.close();
                }catch(IOException e){
                    logger.error("close http response failed!", e);
                }
            }
        }
        return res;
    }

    private static String basePost(HttpPost post){
        String res = "";
        CloseableHttpResponse httpResponse = null;
        try{
            httpResponse = httpClient.execute(post);
            HttpEntity responseEntity = httpResponse.getEntity();
            if(responseEntity != null){
                res = EntityUtils.toString(responseEntity);
            }
            EntityUtils.consume(responseEntity);
        }catch (IOException e){
            logger.error("http post failed!",e);
        }finally {
            if(null != httpResponse){
                try {
                    httpResponse.close();
                }catch(IOException e){
                    logger.error("close http response failed!", e);
                }
            }
        }
        return res;
    }

    private static StringEntity getPostJsonEntity(JSONObject jsonObject){
        StringEntity entity = new StringEntity(jsonObject.toString(), defaultChaset);
        entity.setContentEncoding(defaultChaset);
        entity.setContentType("application/json");
        return entity;
    }

    private static StringEntity getPostFormEntity(Map<String, String> params){
        StringEntity entity = null;
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        if( null != params && params.size() > 0){
            for (Map.Entry<String, String> entry : params.entrySet()) {
                list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            try {
                entity = new UrlEncodedFormEntity(list, defaultChaset);
            }catch (UnsupportedEncodingException e){
                logger.error("Unsupported Encoding Exception!",e);
            }
        }
        return entity;
    }

    private static void setHeader(HttpRequest request, Map<String, String> headers){
        if(null == request)
            return;
        if(headers != null && headers.size() > 0){
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                request.setHeader(entry.getKey(), entry.getValue());
            }
        }
    }

    private static String getUrl(String url, Map<String, String> params){
        String result = url;
        String suffix = "";
        if( params != null && params.size() > 0){
            for (Map.Entry<String, String> entry : params.entrySet()) {
                suffix += entry.getKey() + "=" + entry.getValue() + "&";
            }
        }
        if(suffix.length() > 0){
            suffix = suffix.substring(0, suffix.length() -1 );
            if(result.indexOf("?")>0){
                result += "&" + suffix;
            }else{
                result += "?" + suffix;
            }
        }
        return result;
    }
}
