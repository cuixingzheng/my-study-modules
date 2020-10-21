/**
 * 项目名：duia-tiku-api <br>
 * 包名：com.duia.tiku.common.data <br>
 * 文件名：GlobalHttpClientConfiguration.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2018年3月6日-下午3:45:14<br>
 * Copyright (c) 2018 赵增斌-版权所有<br>
 */
package com.springcloud.consumer.config;

import com.springcloud.consumer.util.LoggerUtils;
import com.springcloud.consumer.util.ObjectUtils;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

/**
 * 类名称：GlobalHttpClientConfiguration <br>
 * 类描述：HttpClient <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2018年3月6日 下午3:45:14 <br>
 * 修改备注：TODO <br>
 */
@Configuration
@ConditionalOnClass(ConfigHttpClient.class)
public class GlobalHttpClientConfiguration {
    /**
     * 日志
     */
    private static final Logger LOGGER = Logger.getLogger(ConfigHttpClient.class);

    @Autowired
    private ConfigHttpClient configHttpClient;

    /**
     * 方法：httpRequestRetryHandler <br>
     * 描述：HttpClient的重试处理机制 <br>
     * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
     * weibo:http://weibo.com/zhaozengbin <br>
     * 日期： 2018年3月6日 下午3:51:31 <br>
     *
     * @return
     */
    @Bean
    public HttpRequestRetryHandler httpRequestRetryHandler() {
        // 请求重试
        final int retryTime = this.configHttpClient.getRetryTime();
        return new HttpRequestRetryHandler() {
            public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
                // Do not retry if over max retry count,如果重试次数超过了retryTime,则不再重试请求
                if (executionCount >= retryTime) {
                    return false;
                }
                // 服务端断掉客户端的连接异常
                if (exception instanceof NoHttpResponseException) {
                    return true;
                }
                // time out 超时重试
                if (exception instanceof InterruptedIOException) {
                    return true;
                }
                // Unknown host
                if (exception instanceof UnknownHostException) {
                    return false;
                }
                // Connection refused
                if (exception instanceof ConnectTimeoutException) {
                    return false;
                }
                // SSL handshake exception
                if (exception instanceof SSLException) {
                    return false;
                }
                HttpClientContext clientContext = HttpClientContext.adapt(context);
                HttpRequest request = clientContext.getRequest();
                if (!(request instanceof HttpEntityEnclosingRequest)) {
                    return true;
                }
                return false;
            }
        };
    }

    /**
     * 方法：poolingClientConnectionManager <br>
     * 描述：连接池管理 <br>
     * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
     * weibo:http://weibo.com/zhaozengbin <br>
     * 日期： 2018年3月6日 下午3:53:15 <br>
     *
     * @return
     */
    @Bean
    public PoolingHttpClientConnectionManager poolingClientConnectionManager() {
        if (ObjectUtils.isNotEmpty(configHttpClient) && ObjectUtils.isNotEmpty(configHttpClient.getConnectRequestTimeout())) {

            PoolingHttpClientConnectionManager poolHttpcConnManager = new PoolingHttpClientConnectionManager(60,
                    TimeUnit.SECONDS);
            // 最大连接数
            poolHttpcConnManager.setMaxTotal(this.configHttpClient.getConnMaxTotal());
            // 路由基数
            poolHttpcConnManager.setDefaultMaxPerRoute(this.configHttpClient.getMaxPerRoute());
            return poolHttpcConnManager;
        }
        return null;
    }

    /**
     * 方法：connectionKeepAliveStrategy <br>
     * 描述：连接保持策略 <br>
     * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
     * weibo:http://weibo.com/zhaozengbin <br>
     * 日期： 2018年3月6日 下午3:54:30 <br>
     *
     * @return
     */
    @Bean("connectionKeepAliveStrategy")
    public ConnectionKeepAliveStrategy connectionKeepAliveStrategy() {
        if (ObjectUtils.isNotEmpty(configHttpClient) && ObjectUtils.isNotEmpty(configHttpClient.getConnectRequestTimeout())) {
            return new ConnectionKeepAliveStrategy() {
                public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
                    // Honor 'keep-alive' header
                    HeaderElementIterator it = new BasicHeaderElementIterator(
                            response.headerIterator(HTTP.CONN_KEEP_ALIVE));
                    while (it.hasNext()) {
                        HeaderElement he = it.nextElement();
                        String param = he.getName();
                        String value = he.getValue();
                        if (value != null && param.equalsIgnoreCase("timeout")) {
                            try {
                                return Long.parseLong(value) * 1000;
                            } catch (NumberFormatException ignore) {
                            }
                        }
                    }
                    return 30 * 1000;
                }
            };
        }
        return null;
    }

    /**
     * 方法：defaultProxyRoutePlanner <br>
     * 描述：HttpClient代理 <br>
     * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
     * weibo:http://weibo.com/zhaozengbin <br>
     * 日期： 2018年3月6日 下午3:56:05 <br>
     *
     * @return
     */
    @Bean
    public DefaultProxyRoutePlanner defaultProxyRoutePlanner() {
        if (ObjectUtils.isNotEmpty(this.configHttpClient.getProxyHost()) && ObjectUtils.isNotEmpty(this.configHttpClient.getProxyPort())) {
            HttpHost proxy = new HttpHost(this.configHttpClient.getProxyHost(), this.configHttpClient.getProxyPort());
            return new DefaultProxyRoutePlanner(proxy);
        }
        return null;
    }

    /**
     * 方法：config <br>
     * 描述：TODO <br>
     * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
     * weibo:http://weibo.com/zhaozengbin <br>
     * 日期： 2018年3月6日 下午3:57:48 <br>
     *
     * @return
     */
    @Bean
    public RequestConfig config() {
        if (ObjectUtils.isNotEmpty(configHttpClient) && ObjectUtils.isNotEmpty(configHttpClient.getConnectRequestTimeout())) {
            return RequestConfig.custom().setConnectionRequestTimeout(this.configHttpClient.getConnectRequestTimeout())
                    .setConnectTimeout(this.configHttpClient.getConnectTimeout())
                    .setSocketTimeout(this.configHttpClient.getSocketTimeout()).build();
        }
        return null;
    }

    /**
     * 方法：restTemplate <br>
     * 描述：创建restTemplate <br>
     * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
     * weibo:http://weibo.com/zhaozengbin <br>
     * 日期： 2018年3月6日 下午3:57:48 <br>
     *
     * @return
     */
    @Bean
    public RestTemplate restTemplate() {
        if (ObjectUtils.isNotEmpty(configHttpClient) && ObjectUtils.isNotEmpty(configHttpClient.getConnectRequestTimeout())) {
            RestTemplate restTemplate = new RestTemplate(httpRequestFactory());
            return restTemplate;
        }
        return null;
    }

    /**
     * 方法：httpRequestFactory <br>
     * 描述：创建http请求工厂 <br>
     * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
     * weibo:http://weibo.com/zhaozengbin <br>
     * 日期： 2018年3月6日 下午3:57:48 <br>
     *
     * @return
     */
    @Bean
    public ClientHttpRequestFactory httpRequestFactory() {
        if (ObjectUtils.isNotEmpty(configHttpClient) && ObjectUtils.isNotEmpty(configHttpClient.getConnectRequestTimeout())) {
            ClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient());
            return clientHttpRequestFactory;
        }
        return null;
    }

    /**
     * 方法：httpClient <br>
     * 描述：创建httpclient <br>
     * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
     * weibo:http://weibo.com/zhaozengbin <br>
     * 日期： 2018年3月6日 下午3:57:48 <br>
     *
     * @return
     */
    @Bean
    public HttpClient httpClient() {
        if (ObjectUtils.isNotEmpty(configHttpClient) && ObjectUtils.isNotEmpty(configHttpClient.getConnectRequestTimeout())) {
            LoggerUtils.info(LOGGER, "读取到configHttpClient配置:" + configHttpClient.toString());
            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.getSocketFactory())
                    .register("https", SSLConnectionSocketFactory.getSocketFactory())
                    .build();
            PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(registry);
            connectionManager.setMaxTotal(this.configHttpClient.getConnMaxTotal());
            connectionManager.setDefaultMaxPerRoute(this.configHttpClient.getMaxPerRoute());

            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(this.configHttpClient.getSocketTimeout())
                    .setConnectTimeout(this.configHttpClient.getConnectTimeout())
                    .setConnectionRequestTimeout(this.configHttpClient.getConnectRequestTimeout())
                    .build();
            HttpClient httpClient = HttpClientBuilder.create()
                    .setDefaultRequestConfig(requestConfig)
                    .setConnectionManager(connectionManager)
                    .build();
            return httpClient;
        }
        return null;
    }
}
