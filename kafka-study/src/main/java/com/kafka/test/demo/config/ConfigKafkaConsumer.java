/**
 * 项目名：duia-statistic-api <br>
 * 包名：com.duia.statistic.common.config <br>
 * 文件名：ConfigKafkaConsumer.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2017年5月5日-下午2:33:20<br>
 * Copyright (c) 2017 赵增斌-版权所有<br>
 */
package com.kafka.test.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 *
 * 类名称：ConfigKafkaConsumer <br>
 * 类描述：Kafka配置文件 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2017年5月5日 下午2:33:20 <br>
 * 修改备注：TODO <br>
 *
 */
@Component
@PropertySource(value = "classpath:/kafka.properties")
@ConfigurationProperties(prefix = "spring.kafka.consumer", ignoreUnknownFields = false)
public class ConfigKafkaConsumer {

    /** 用于建立与kafka集群连接的host/port组 */
    private String bootstrap_servers;

    /**
     * true时，Consumer会在消费消息后将offset同步到zookeeper，这样当Consumer失败后，新的consumer就能从zookeeper获取最新的offset
     */
    private Boolean enable_auto_commit;

    /** 自动提交的时间间隔 */
    private Integer auto_commit_interval_ms;

    /** zookeeper的心跳超时时间，查过这个时间就认为是无效的消费者 */
    private Integer session_timeout_ms;

    /** 消费者的ID，若是没有设置的话，会自增 */
    private String group_id;
    /**
     * 流式计算消费组id
     */
    private String spark_group_id;

    /**
     * 当zookeeper中没有初始的offset时，或者超出offset上限时的处理方式 。 smallest ：重置为最小值 largest:重置为最大值
     * anything else：抛出异常给consumer
     */
    private String auto_offset_reset;


    /**
     * @retrun the bootstrap_servers <br>
     *
     *         时间: 2017年5月12日 下午5:24:54 <br>
     */

    public String getBootstrap_servers() {
        return bootstrap_servers;
    }

    /**
     * @param bootstrap_servers
     *            the bootstrap_servers to set <br>
     *
     *            时间: 2017年5月12日 下午5:24:54
     */
    public void setBootstrap_servers(String bootstrap_servers) {
        this.bootstrap_servers = bootstrap_servers;
    }

    /**
     * @retrun the enable_auto_commit <br>
     *
     *         时间: 2017年5月12日 下午5:24:54 <br>
     */

    public Boolean getEnable_auto_commit() {
        return enable_auto_commit;
    }

    /**
     * @param enable_auto_commit
     *            the enable_auto_commit to set <br>
     *
     *            时间: 2017年5月12日 下午5:24:54
     */
    public void setEnable_auto_commit(Boolean enable_auto_commit) {
        this.enable_auto_commit = enable_auto_commit;
    }

    /**
     * @retrun the auto_commit_interval_ms <br>
     *
     *         时间: 2017年5月12日 下午5:24:54 <br>
     */

    public Integer getAuto_commit_interval_ms() {
        return auto_commit_interval_ms;
    }

    /**
     * @param auto_commit_interval_ms
     *            the auto_commit_interval_ms to set <br>
     *
     *            时间: 2017年5月12日 下午5:24:54
     */
    public void setAuto_commit_interval_ms(Integer auto_commit_interval_ms) {
        this.auto_commit_interval_ms = auto_commit_interval_ms;
    }

    /**
     * @retrun the session_timeout_ms <br>
     *
     *         时间: 2017年5月12日 下午5:24:54 <br>
     */

    public Integer getSession_timeout_ms() {
        return session_timeout_ms;
    }

    /**
     * @param session_timeout_ms
     *            the session_timeout_ms to set <br>
     *
     *            时间: 2017年5月12日 下午5:24:54
     */
    public void setSession_timeout_ms(Integer session_timeout_ms) {
        this.session_timeout_ms = session_timeout_ms;
    }

    /**
     * @retrun the group_id <br>
     *
     *         时间: 2017年5月12日 下午5:24:54 <br>
     */

    public String getGroup_id() {
        return group_id;
    }

    /**
     * @param group_id
     *            the group_id to set <br>
     *
     *            时间: 2017年5月12日 下午5:24:54
     */
    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getSpark_group_id() {
        return spark_group_id;
    }

    public void setSpark_group_id(String spark_group_id) {
        this.spark_group_id = spark_group_id;
    }

    /**
     * @retrun the auto_offset_reset <br>
     *
     *         时间: 2017年5月12日 下午5:24:54 <br>
     */

    public String getAuto_offset_reset() {
        return auto_offset_reset;
    }

    /**
     * @param auto_offset_reset
     *            the auto_offset_reset to set <br>
     *
     *            时间: 2017年5月12日 下午5:24:54
     */
    public void setAuto_offset_reset(String auto_offset_reset) {
        this.auto_offset_reset = auto_offset_reset;
    }

    /**
     * @retrun the topic_statistics_data <br>
     *
     *         时间: 2017年5月24日 上午10:01:16 <br>
     */


    /**
     * 方法：toString <br>
     * 描述：TODO <br>
     *
     * @return
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "ConfigKafkaConsumer [bootstrap_servers=" + bootstrap_servers + ", enable_auto_commit="
                + enable_auto_commit + ", auto_commit_interval_ms=" + auto_commit_interval_ms + ", session_timeout_ms="
                + session_timeout_ms + ", group_id=" + group_id + ", auto_offset_reset=" + auto_offset_reset + "]";
    }

}
