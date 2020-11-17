/**
 * 项目名：duia-statistic <br>
 * 包名：com.duia.statistic.common.config <br>
 * 文件名：ConfigTikuMysql.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2017年5月5日-上午10:17:05<br>
 * Copyright (c) 2017 赵增斌-版权所有<br>
 */
package com.distributed.lock.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:/redis.properties", ignoreResourceNotFound = true)
@ConfigurationProperties(prefix = "redis")
public class ConfigRedis {

    /** redis主机 */
    private String ip;

    /** redis端口 */
    private Integer port;

    /** redis密码验证 */
    private String password;

    /** redis数据库 */
    private Integer dbName;

    /** redis链接最大空闲数 */
    private Integer maxIdle;

    /** redis最大建立连接等待时间 */
    private Integer maxWait;

    /** 客户端超时时间单位是毫秒 */
    private Integer timeout;

    /** 最大连接数, 默认8个 */
    private Integer maxTotal;

    /** redis最小空闲连接数, 默认0 */
    private Integer minIdle;

    /** redis在获取连接的时候检查有效性, 默认false */
    private Boolean testOnBorrow;

    /** redis cluster */
    private String clusteNodes;

    private Integer clusterMaxRedirects;

    /**
     * @retrun the ip <br>
     *
     *         时间: 2017年7月14日 下午4:57:17 <br>
     */

    public String getIp() {
        return ip;
    }

    /**
     * @param ip
     *            the ip to set <br>
     *
     *            时间: 2017年7月14日 下午4:57:17
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @retrun the port <br>
     *
     *         时间: 2017年5月5日 下午2:07:21 <br>
     */

    public Integer getPort() {
        return port;
    }

    /**
     * @param port
     *            the port to set <br>
     *
     *            时间: 2017年5月5日 下午2:07:21
     */
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * @retrun the password <br>
     *
     *         时间: 2017年5月5日 下午2:07:21 <br>
     */

    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set <br>
     *
     *            时间: 2017年5月5日 下午2:07:21
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @retrun the dbName <br>
     *
     *         时间: 2017年5月20日 下午3:14:54 <br>
     */

    public Integer getDbName() {
        return dbName;
    }

    /**
     * @param dbName
     *            the dbName to set <br>
     *
     *            时间: 2017年5月20日 下午3:14:54
     */
    public void setDbName(Integer dbName) {
        this.dbName = dbName;
    }

    /**
     * @retrun the maxIdle <br>
     *
     *         时间: 2017年5月5日 下午2:07:21 <br>
     */

    public Integer getMaxIdle() {
        return maxIdle;
    }

    /**
     * @param maxIdle
     *            the maxIdle to set <br>
     *
     *            时间: 2017年5月5日 下午2:07:21
     */
    public void setMaxIdle(Integer maxIdle) {
        this.maxIdle = maxIdle;
    }

    /**
     * @retrun the maxWait <br>
     *
     *         时间: 2017年5月5日 下午2:07:21 <br>
     */

    public Integer getMaxWait() {
        return maxWait;
    }

    /**
     * @param maxWait
     *            the maxWait to set <br>
     *
     *            时间: 2017年5月5日 下午2:07:21
     */
    public void setMaxWait(Integer maxWait) {
        this.maxWait = maxWait;
    }

    /**
     * @retrun the timeout <br>
     *
     *         时间: 2017年5月5日 下午2:07:21 <br>
     */

    public Integer getTimeout() {
        return timeout;
    }

    /**
     * @param timeout
     *            the timeout to set <br>
     *
     *            时间: 2017年5月5日 下午2:07:21
     */
    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    /**
     * @retrun the maxTotal <br>
     *
     *         时间: 2017年5月5日 下午2:07:21 <br>
     */

    public Integer getMaxTotal() {
        return maxTotal;
    }

    /**
     * @param maxTotal
     *            the maxTotal to set <br>
     *
     *            时间: 2017年5月5日 下午2:07:21
     */
    public void setMaxTotal(Integer maxTotal) {
        this.maxTotal = maxTotal;
    }

    /**
     * @retrun the minIdle <br>
     *
     *         时间: 2017年5月5日 下午2:07:21 <br>
     */

    public Integer getMinIdle() {
        return minIdle;
    }

    /**
     * @param minIdle
     *            the minIdle to set <br>
     *
     *            时间: 2017年5月5日 下午2:07:21
     */
    public void setMinIdle(Integer minIdle) {
        this.minIdle = minIdle;
    }

    /**
     * @retrun the testOnBorrow <br>
     *
     *         时间: 2017年5月5日 下午2:07:21 <br>
     */

    public Boolean getTestOnBorrow() {
        return testOnBorrow;
    }

    /**
     * @param testOnBorrow
     *            the testOnBorrow to set <br>
     *
     *            时间: 2017年5月5日 下午2:07:21
     */
    public void setTestOnBorrow(Boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    /**
     * @retrun the clusteNodes <br>
     *
     *         时间: 2017年5月5日 下午2:07:21 <br>
     */

    public String getClusteNodes() {
        return clusteNodes;
    }

    /**
     * @param clusteNodes
     *            the clusteNodes to set <br>
     *
     *            时间: 2017年5月5日 下午2:07:21
     */
    public void setClusteNodes(String clusteNodes) {
        this.clusteNodes = clusteNodes;
    }

    /**
     * @retrun the clusterMaxRedirects <br>
     *
     *         时间: 2017年5月5日 下午2:07:21 <br>
     */

    public Integer getClusterMaxRedirects() {
        return clusterMaxRedirects;
    }

    /**
     * @param clusterMaxRedirects
     *            the clusterMaxRedirects to set <br>
     *
     *            时间: 2017年5月5日 下午2:07:21
     */
    public void setClusterMaxRedirects(Integer clusterMaxRedirects) {
        this.clusterMaxRedirects = clusterMaxRedirects;
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
        return "ConfigRedis [ip=" + ip + ", port=" + port + ", password=" + password + ", maxIdle=" + maxIdle
                + ", maxWait=" + maxWait + ", timeout=" + timeout + ", maxTotal=" + maxTotal + ", minIdle=" + minIdle
                + ", testOnBorrow=" + testOnBorrow + ", clusteNodes=" + clusteNodes + ", clusterMaxRedirects="
                + clusterMaxRedirects + "]";
    }

}
