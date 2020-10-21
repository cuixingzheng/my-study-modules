/**
 * 项目名：duia-tiku-api <br>
 * 包名：com.duia.tiku.common.config <br>
 * 文件名：ConfigHttpClient.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2017年5月5日-上午10:17:05<br>
 * Copyright (c) 2017 赵增斌-版权所有<br>
 */
package com.springcloud.consumer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
@PropertySource(value = "classpath:httpclient.properties", ignoreResourceNotFound = true)
@ConfigurationProperties(prefix = "httpclient.config")
public class ConfigHttpClient {

    /**
     * 重试时间
     */
    private Integer retryTime;

    /**
     * 连接池最大连接数
     */
    private Integer connMaxTotal;

    /**
     * 路由的默认最大连接
     */
    private Integer maxPerRoute;

    /**
     * 连接存活时间，单位为s
     */
    private Integer timeToLive;

    /**
     * 保持时间
     */
    private Integer keepAliveTime;

    // 代理的host地址
    private String proxyHost;

    // 代理的端口号
    private Integer proxyPort;

    /**
     * 链接超时时间
     */
    private Integer connectTimeout;

    /**
     * 链接请求时间
     */
    private Integer connectRequestTimeout;

    /**
     * socket链接时间
     */
    private Integer socketTimeout;

    /**
     * @retrun the retryTime <br>
     * <p>
     * 时间: 2018年3月6日 下午3:43:36 <br>
     */

    public Integer getRetryTime() {
        return retryTime;
    }

    /**
     * @param retryTime the retryTime to set <br>
     *                  <p>
     *                  时间: 2018年3月6日 下午3:43:36
     */
    public void setRetryTime(Integer retryTime) {
        this.retryTime = retryTime;
    }

    /**
     * @retrun the connMaxTotal <br>
     * <p>
     * 时间: 2018年3月6日 下午3:43:36 <br>
     */

    public Integer getConnMaxTotal() {
        return connMaxTotal;
    }

    /**
     * @param connMaxTotal the connMaxTotal to set <br>
     *                     <p>
     *                     时间: 2018年3月6日 下午3:43:36
     */
    public void setConnMaxTotal(Integer connMaxTotal) {
        this.connMaxTotal = connMaxTotal;
    }

    /**
     * @retrun the maxPerRoute <br>
     * <p>
     * 时间: 2018年3月6日 下午3:43:36 <br>
     */

    public Integer getMaxPerRoute() {
        return maxPerRoute;
    }

    /**
     * @param maxPerRoute the maxPerRoute to set <br>
     *                    <p>
     *                    时间: 2018年3月6日 下午3:43:36
     */
    public void setMaxPerRoute(Integer maxPerRoute) {
        this.maxPerRoute = maxPerRoute;
    }

    /**
     * @retrun the timeToLive <br>
     * <p>
     * 时间: 2018年3月6日 下午3:43:36 <br>
     */

    public Integer getTimeToLive() {
        return timeToLive;
    }

    /**
     * @param timeToLive the timeToLive to set <br>
     *                   <p>
     *                   时间: 2018年3月6日 下午3:43:36
     */
    public void setTimeToLive(Integer timeToLive) {
        this.timeToLive = timeToLive;
    }

    /**
     * @retrun the keepAliveTime <br>
     * <p>
     * 时间: 2018年3月6日 下午3:43:36 <br>
     */

    public Integer getKeepAliveTime() {
        return keepAliveTime;
    }

    /**
     * @param keepAliveTime the keepAliveTime to set <br>
     *                      <p>
     *                      时间: 2018年3月6日 下午3:43:36
     */
    public void setKeepAliveTime(Integer keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }

    /**
     * @retrun the proxyHost <br>
     * <p>
     * 时间: 2018年3月6日 下午3:43:36 <br>
     */

    public String getProxyHost() {
        return proxyHost;
    }

    /**
     * @param proxyHost the proxyHost to set <br>
     *                  <p>
     *                  时间: 2018年3月6日 下午3:43:36
     */
    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    /**
     * @retrun the proxyPort <br>
     * <p>
     * 时间: 2018年3月6日 下午3:43:36 <br>
     */

    public Integer getProxyPort() {
        return proxyPort;
    }

    /**
     * @param proxyPort the proxyPort to set <br>
     *                  <p>
     *                  时间: 2018年3月6日 下午3:43:36
     */
    public void setProxyPort(Integer proxyPort) {
        this.proxyPort = proxyPort;
    }

    /**
     * @retrun the connectTimeout <br>
     * <p>
     * 时间: 2018年3月6日 下午3:43:36 <br>
     */

    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    /**
     * @param connectTimeout the connectTimeout to set <br>
     *                       <p>
     *                       时间: 2018年3月6日 下午3:43:36
     */
    public void setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    /**
     * @retrun the connectRequestTimeout <br>
     * <p>
     * 时间: 2018年3月6日 下午3:43:36 <br>
     */

    public Integer getConnectRequestTimeout() {
        return connectRequestTimeout;
    }

    /**
     * @param connectRequestTimeout the connectRequestTimeout to set <br>
     *                              <p>
     *                              时间: 2018年3月6日 下午3:43:36
     */
    public void setConnectRequestTimeout(Integer connectRequestTimeout) {
        this.connectRequestTimeout = connectRequestTimeout;
    }

    /**
     * @retrun the socketTimeout <br>
     * <p>
     * 时间: 2018年3月6日 下午3:43:36 <br>
     */

    public Integer getSocketTimeout() {
        return socketTimeout;
    }

    /**
     * @param socketTimeout the socketTimeout to set <br>
     *                      <p>
     *                      时间: 2018年3月6日 下午3:43:36
     */
    public void setSocketTimeout(Integer socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    /**
     * 方法：toString <br>
     * 描述：TODO <br>
     *
     * @return
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "ConfigHttpClient [retryTime=" + retryTime + ", connMaxTotal=" + connMaxTotal + ", maxPerRoute="
                + maxPerRoute + ", timeToLive=" + timeToLive + ", keepAliveTime=" + keepAliveTime + ", proxyHost="
                + proxyHost + ", proxyPort=" + proxyPort + ", connectTimeout=" + connectTimeout
                + ", connectRequestTimeout=" + connectRequestTimeout + ", socketTimeout=" + socketTimeout + "]";
    }

}
