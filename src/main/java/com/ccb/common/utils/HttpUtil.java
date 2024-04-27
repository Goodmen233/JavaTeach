package com.ccb.common.utils;

import cn.hutool.core.map.MapUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description: http请求工具类
 * @Author: CCB
 * @Date: 2023/2/10 10:53
 */
public class HttpUtil {
    private static final Logger log = LoggerFactory.getLogger(HttpUtil.class);
    private static HttpClientBuilder httpBuilder = null;
    private static RequestConfig requestConfig = null;

    /**
     * 最大连接连接数量
     */
    private static final int MAX_CONNECTION = 100;
    /**
     * 最大并发请求数量
     */
    private static final int DEFAULT_MAX_CONNECTION = 50;

    static {
        // 设置http的状态参数
        requestConfig = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(10000)
                .setConnectionRequestTimeout(10000).build();

        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(MAX_CONNECTION);
        connectionManager.setDefaultMaxPerRoute(DEFAULT_MAX_CONNECTION);
        httpBuilder = HttpClients.custom();
        httpBuilder.setConnectionManager(connectionManager);
    }

    /**
     * 获取http客户端连接
     *
     * @return http客户端连接
     */
    public static CloseableHttpClient getConnection() {
        return httpBuilder.build();
    }

    /**
     * http post请求，利用http请求池
     *
     * @param url       请求url
     * @param paramsMap 请求参数
     * @return 请求结果
     * @throws Exception 异常
     */
    public static String httpPost(String url, Map<String, String> paramsMap) throws Exception {
        List<NameValuePair> params = new ArrayList<>();

        for (Map.Entry<String, String> e : paramsMap.entrySet()) {
            NameValuePair pair = new BasicNameValuePair(e.getKey(), e.getValue());
            params.add(pair);
        }

        HttpUriRequest postMethod = RequestBuilder.post().setUri(url)
                .addParameters(params.toArray(new BasicNameValuePair[params.size()])).setConfig(requestConfig).build();

        HttpResponse response = getConnection().execute(postMethod);

        return EntityUtils.toString(response.getEntity());
    }

    /**
     * http post请求，利用http请求池
     *
     * @param url       请求url
     * @param paramsMap 请求参数
     * @param urlParams url请求参数
     * @return 请求结果
     * @throws Exception 异常
     */
    public static String httpPost(String url, Map<String, String> paramsMap, Map<String, Object> urlParams) throws Exception {
        List<NameValuePair> params = new ArrayList<>();

        for (Map.Entry<String, String> e : paramsMap.entrySet()) {
            NameValuePair pair = new BasicNameValuePair(e.getKey(), e.getValue());
            params.add(pair);
        }
        StringBuilder sb = new StringBuilder("?");
        for (Map.Entry<String, Object> e : urlParams.entrySet()) {
            sb.append(e.getKey()).append("=").append(e.getValue()).append("&");
        }
        if (urlParams!= null&&urlParams.size()!=0){
            url = url + sb.toString();
        }
        HttpUriRequest postMethod = RequestBuilder.post().setUri(url)
                .addParameters(params.toArray(new BasicNameValuePair[params.size()])).setConfig(requestConfig).build();

        HttpResponse response = getConnection().execute(postMethod);

        return EntityUtils.toString(response.getEntity());
    }

    /**
     * http post请求，利用http请求池
     *
     * @param url     请求url
     * @param jsonStr json字符串
     * @return 请求结果
     * @throws Exception 异常
     */
    public static String httpPostJson(String url, String jsonStr) throws Exception {

        HttpUriRequest postMethod = RequestBuilder.post().setUri(url)
                .setHeader("Content-Type", "application/json;charset=utf-8").setHeader("Accept", "application/json")
                .setEntity(new StringEntity(jsonStr, Charset.forName("UTF-8"))).setConfig(requestConfig).build();
        HttpResponse response = getConnection().execute(postMethod);

        return EntityUtils.toString(response.getEntity());
    }

    /**
     * http post请求，利用http请求池,设置head内容
     *
     * @param url     请求url
     * @param jsonStr json字符串
     * @param head    head内容
     * @return 请求结果
     * @throws Exception 异常
     */
    public static String httpPostJson(String url, String jsonStr, Map<String, String> head) throws Exception {
        if (MapUtil.isNotEmpty(head)) {
            RequestBuilder requestBuilder = RequestBuilder.post().setUri(url)
                    .setHeader("Content-Type", "application/json;charset=utf-8")
                    .setHeader("Accept", "application/json");

            for (Map.Entry<String, String> entry : head.entrySet()) {
                requestBuilder.setHeader(entry.getKey(), entry.getValue());
            }

            HttpUriRequest postMethod = requestBuilder.setEntity(new StringEntity(jsonStr, Charset.forName("UTF-8")))
                    .setConfig(requestConfig).build();

            HttpResponse response = getConnection().execute(postMethod);

            return EntityUtils.toString(response.getEntity());
        } else {
            return httpPostJson(url, jsonStr);
        }

    }

    /**
     * http post请求，利用http请求池,设置head内容
     *
     * @param url     请求url
     * @param jsonStr json字符串
     * @param head    head内容
     * @return 请求结果
     * @throws Exception 异常
     */
    public static String httpPostJson(String url, String jsonStr, Map<String, String> head,  Map<String, Object> urlParams) throws Exception {
        if (MapUtil.isNotEmpty(head)) {

            StringBuilder sb = new StringBuilder("?");
            for (Map.Entry<String, Object> e : urlParams.entrySet()) {
                sb.append(e.getKey()).append("=").append(e.getValue()).append("&");
            }
            if (urlParams!= null&&urlParams.size()!=0){
                url = url + sb.toString();
            }
            RequestBuilder requestBuilder = RequestBuilder.post().setUri(url)
                    .setHeader("Content-Type", "application/json;charset=utf-8")
                    .setHeader("Accept", "application/json");
            for (Map.Entry<String, String> entry : head.entrySet()) {
                requestBuilder.setHeader(entry.getKey(), entry.getValue());
            }

            HttpUriRequest postMethod = requestBuilder.setEntity(new StringEntity(jsonStr, Charset.forName("UTF-8")))
                    .setConfig(requestConfig).build();

            HttpResponse response = getConnection().execute(postMethod);

            return EntityUtils.toString(response.getEntity());
        } else {
            return httpPostJson(url, jsonStr);
        }

    }

    /**
     * http get请求，利用http请求池
     *
     * @param url 请求url
     * @return 请求结果
     * @throws Exception 异常
     */
    public static String httpGet(String url) throws Exception {
        HttpUriRequest getMethod = RequestBuilder.get().setUri(url).setConfig(requestConfig).build();

        HttpResponse response = getConnection().execute(getMethod);

        return EntityUtils.toString(response.getEntity());
    }

    /**
     * http get请求，利用http请求池
     *
     * @param url       请求url
     * @param paramsMap 请求参数
     * @return 请求结果
     * @throws Exception 异常
     */
    public static String httpGet(String url, Map<String, String> paramsMap) throws Exception {
        List<NameValuePair> params = new ArrayList<>();

        for (Map.Entry<String, String> e : paramsMap.entrySet()) {
            NameValuePair pair = new BasicNameValuePair(e.getKey(), e.getValue());
            params.add(pair);
        }

        HttpUriRequest getMethod = RequestBuilder.get().setUri(url)
                .addParameters(params.toArray(new BasicNameValuePair[params.size()])).setConfig(requestConfig).build();

        HttpResponse response = getConnection().execute(getMethod);

        return EntityUtils.toString(response.getEntity());
    }

    /**
     * http get请求，利用http请求池 设置head内容
     *
     * @param url       请求url
     * @param paramsMap 请求参数
     * @param head      head内容
     * @return 请求结果
     * @throws Exception 异常
     */
    public static String httpGet(String url, Map<String, String> paramsMap, Map<String, String> head) throws Exception {
        List<NameValuePair> params = new ArrayList<>();

        for (Map.Entry<String, String> e : paramsMap.entrySet()) {
            NameValuePair pair = new BasicNameValuePair(e.getKey(), e.getValue());
            params.add(pair);
        }
        RequestBuilder requestBuilder = RequestBuilder.get().setUri(url);
        for (Map.Entry<String, String> entry : head.entrySet()) {
            requestBuilder.setHeader(entry.getKey(), entry.getValue());
        }
        HttpUriRequest getMethod = requestBuilder.addParameters(params.toArray(new BasicNameValuePair[params.size()]))
                .setConfig(requestConfig).build();

        HttpResponse response = getConnection().execute(getMethod);

        return EntityUtils.toString(response.getEntity());
    }

    /**
     * http post 请求,每次创建请求客户端
     *
     * @param url    url
     * @param params 请求参数
     * @return 请求返回值
     */
    public static String httpPostNoPool(String url, Map<String, String> params) {
        CloseableHttpClient closeableHttpClient = null;
        try {
            HttpPost httpPost = new HttpPost(url);

            if (params != null) {
                List<NameValuePair> form = new ArrayList<>();

                for (String name : params.keySet()) {
                    form.add(new BasicNameValuePair(name, params.get(name)));
                }

                httpPost.setEntity(new UrlEncodedFormEntity(form, HTTP.UTF_8));
            }

            closeableHttpClient = HttpClients.createDefault();
            CloseableHttpResponse httpResponse = closeableHttpClient.execute(httpPost);
            HttpEntity entry = httpResponse.getEntity();
            return EntityUtils.toString(entry);
        } catch (Exception e) {
            log.error("HttpUtil.httpPost failed!", e);
        } finally {
            if (null != closeableHttpClient) {
                try {
                    closeableHttpClient.close();
                } catch (IOException e) {
                    log.error("closeableHttpClient.close failed!", e);
                }
            }
        }

        return null;
    }

    /**
     * 使用httpclint 发送文件
     *
     * @param file 上传的文件
     * @return 响应结果
     */
    public static String uploadFile(String url, MultipartFile file, String fileParamName,
                                    Map<String, String> headerParams, Map<String, String> otherParams) {

        CloseableHttpClient closeableHttpClient = null;
        String result = "";
        try {
            String fileName = file.getOriginalFilename();
            HttpPost httpPost = new HttpPost(url);
            // 添加header
            for (Map.Entry<String, String> e : headerParams.entrySet()) {
                httpPost.addHeader(e.getKey(), e.getValue());
            }
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.setCharset(Charset.forName("utf-8"));
            // 加上此行代码解决返回中文乱码问题
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            // 文件流
            builder.addBinaryBody(fileParamName, file.getInputStream(), ContentType.MULTIPART_FORM_DATA, fileName);
            for (Map.Entry<String, String> e : otherParams.entrySet()) {
                // 类似浏览器表单提交，对应input的name和value
                builder.addTextBody(e.getKey(), e.getValue());
            }
            HttpEntity entity = builder.build();
            httpPost.setEntity(entity);

            closeableHttpClient = HttpClients.createDefault();
            // 执行提交
            HttpResponse response = closeableHttpClient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();

            if (responseEntity != null) {
                // 将响应内容转换为字符串
                result = EntityUtils.toString(responseEntity, Charset.forName("UTF-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != closeableHttpClient) {
                try {
                    closeableHttpClient.close();
                } catch (IOException e) {
                    log.error("closeableHttpClient.close failed!", e);
                }
            }
        }
        return result;
    }

}
