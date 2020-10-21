/**
 * 项目名：duia-statistic-api <br>
 * 包名：com.duia.statistic.common.util <br>
 * 文件名：LoggerUtils.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2017年5月4日-下午12:14:11<br>
 * Copyright (c) 2017 赵增斌-版权所有<br>
 */
package com.springcloud.consumer.util;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;

/**
 * 类名称：LoggerUtils <br>
 * 类描述：日志工具类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2017年5月4日 下午12:14:11 <br>
 * 修改备注：TODO <br>
 */
public class LoggerUtils {

    public static final Logger ERROR = Logger.getLogger("error");

    public static final Logger DEBUG = Logger.getLogger("debug");

    public static final Logger INFO = Logger.getLogger("info");

    /**
     * 方法：kafka消费者log <br>
     * 描述：kafka生产日志 <br>
     * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
     * weibo:http://weibo.com/zhaozengbin <br>
     * 日期： 2017年5月4日 下午12:17:55 <br>
     *
     * @param logger
     * @param msg
     */
    public static void specifiedLog(Logger logger, String msg) {
        logger.info(msg);
    }

    /**
     * 方法：kafkaConsumelog <br>
     * 描述：kafka消费日志 <br>
     * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
     * weibo:http://weibo.com/zhaozengbin <br>
     * 日期： 2017年5月4日 下午12:17:55 <br>
     *
     * @param logger
     * @param msg
     */
    public static void kafkaProduce(Logger logger, String msg) {
        logger.info(msg);
    }

    /**
     * 方法：kafka消费者log <br>
     * 描述：kafka生产日志 <br>
     * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
     * weibo:http://weibo.com/zhaozengbin <br>
     * 日期： 2017年5月4日 下午12:17:55 <br>
     *
     * @param logger
     * @param msg
     */
    public static void kafkaConsumelog(Logger logger, String msg) {
        logger.info(msg);
    }

    /**
     * 方法：info <br>
     * 描述：TODO <br>
     * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
     * weibo:http://weibo.com/zhaozengbin <br>
     * 日期： 2017年5月4日 下午12:17:55 <br>
     *
     * @param logger
     * @param obj
     */
    public static void info(Logger logger, Object obj) {
        logger.info("-------------------- " + JSON.toJSONString(obj) + " --------------------");
    }

    /**
     * 方法：info <br>
     * 描述：TODO <br>
     * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
     * weibo:http://weibo.com/zhaozengbin <br>
     * 日期： 2017年5月4日 下午12:17:55 <br>
     *
     * @param logger
     * @param message
     */
    public static void info(Logger logger, String message) {
        logger.info("-------------------- " + message + " --------------------");
    }

    /**
     * 方法：info <br>
     * 描述：TODO <br>
     * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
     * weibo:http://weibo.com/zhaozengbin <br>
     * 日期： 2017年5月4日 下午12:17:55 <br>
     *
     * @param logger
     * @param message
     * @param e
     */
    public static void info(Logger logger, String message, Throwable e) {
        logger.info("-------------------- " + message + " --------------------", e);
    }

    /**
     * 方法：debug <br>
     * 描述：TODO <br>
     * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
     * weibo:http://weibo.com/zhaozengbin <br>
     * 日期： 2017年5月4日 下午12:17:55 <br>
     *
     * @param logger
     * @param message
     */
    public static void debug(Logger logger, String message) {
        logger.debug("-------------------- " + message + " --------------------");
    }

    /**
     * 方法：debug <br>
     * 描述：TODO <br>
     * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
     * weibo:http://weibo.com/zhaozengbin <br>
     * 日期： 2017年5月4日 下午12:17:55 <br>
     *
     * @param logger
     * @param message
     * @param e
     */
    public static void debug(Logger logger, String message, Throwable e) {
        logger.debug("-------------------- " + message + " --------------------", e);
    }

    /**
     * 方法：warn <br>
     * 描述：TODO <br>
     * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
     * weibo:http://weibo.com/zhaozengbin <br>
     * 日期： 2017年5月4日 下午12:17:55 <br>
     *
     * @param logger
     * @param message
     */
    public static void warn(Logger logger, String message) {
        logger.warn("-------------------- " + message + " --------------------");
    }

    /**
     * 方法：warn <br>
     * 描述：TODO <br>
     * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
     * weibo:http://weibo.com/zhaozengbin <br>
     * 日期： 2017年5月4日 下午12:17:55 <br>
     *
     * @param logger
     * @param message
     * @param e
     */
    public static void warn(Logger logger, String message, Throwable e) {
        logger.warn("-------------------- " + message + " --------------------", e);
    }

    /**
     * 方法：error <br>
     * 描述：TODO <br>
     * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
     * weibo:http://weibo.com/zhaozengbin <br>
     * 日期： 2017年5月4日 下午12:17:55 <br>
     *
     * @param logger
     * @param message
     */
    public static void error(Logger logger, String message) {
        logger.error("-------------------- " + message + " --------------------");
    }

    /**
     * 方法：error <br>
     * 描述：TODO <br>
     * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
     * weibo:http://weibo.com/zhaozengbin <br>
     * 日期： 2017年5月4日 下午12:17:55 <br>
     *
     * @param logger
     * @param message
     * @param e
     */
    public static void error(Logger logger, String message, Throwable e) {
        logger.error("-------------------- " + message + " --------------------", e);
    }

    /**
     * 方法：getExceptionAllinformation <br>
     * 描述：获取异常信息 <br>
     * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
     * weibo:http://weibo.com/zhaozengbin <br>
     * 日期： 2017年10月18日 下午6:31:42 <br>
     *
     * @param ex
     * @return
     */
    public static String getExceptionAllinformation(Exception ex) {
        String sOut = "";
        StackTraceElement[] trace = ex.getStackTrace();
        for (StackTraceElement s : trace) {
            sOut += s + " ";
        }
        return sOut;
    }

    public static String printCallStatck(Throwable ex) {
        String sOut = "";
        StackTraceElement[] stackElements = ex.getStackTrace();// 通过Throwable获得堆栈信息
        if (stackElements != null) {
            for (int i = 0; i < stackElements.length; i++) {
                sOut += stackElements[i].getClassName() + " ";
                // 打印classname
                sOut += stackElements[i].getFileName() + " ";
                // 打印filename
                sOut += stackElements[i].getLineNumber() + " ";
                // 打印linenumber
                sOut += stackElements[i].getMethodName() + " ";
            }
        }
        return sOut;
    }
}
