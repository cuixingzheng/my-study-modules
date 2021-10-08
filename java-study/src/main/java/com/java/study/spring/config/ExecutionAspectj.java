//package com.java.study.spring.config;
//
//import com.duia.statistic.common.annotaction.ExecutionAnn;
//import com.duia.statistic.core.constant.ELogLevel;
//import org.apache.log4j.Logger;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.ConcurrentHashMap;
//
//@Aspect
//@Component
//public class ExecutionAspectj {
//    private static final Logger LOGGER = Logger.getLogger(ExecutionAspectj.class);
//    private static final boolean SWITCH = true;
//
//    private static ConcurrentHashMap<String, MethodStats> methodStats = new ConcurrentHashMap<String, MethodStats>();
//
//    private static long statLogFrequency = 10;
//
//    private static long methodWarningThreshold = 5000;
//
//    @Around("execution(* com.duia..*.*(..)) && @annotation(executionAnn)")
//    public Object invoke(ProceedingJoinPoint joinPoint, ExecutionAnn executionAnn) throws Throwable {
//        long start = System.currentTimeMillis();
//        try {
//            return joinPoint.proceed();
//        } finally {
//            if (SWITCH) {
//                try {
//                    String targetClassName = joinPoint.getTarget().getClass().getName();
//                    String targetMethodName = joinPoint.getSignature().getName();
//                    updateStats(executionAnn.logLevel(), targetClassName + "[" + targetMethodName + "]", (System.currentTimeMillis() - start));
//                } catch (Exception e) {
//                }
//            }
//        }
//    }
//
//    private void updateStats(ELogLevel eLogLevel, String methodName, long elapsedTime) {
//        MethodStats stats = methodStats.get(methodName);
//        if (stats == null) {
//            stats = new MethodStats(methodName);
//            methodStats.put(methodName, stats);
//        }
//        stats.count++;
//        stats.totalTime += elapsedTime;
//        if (elapsedTime > stats.maxTime) {
//            stats.maxTime = elapsedTime;
//        }
//        if (elapsedTime > methodWarningThreshold) {
//            LOGGER.warn("method: " + methodName + "(), cnt = " + stats.count + ", lastTime = " + elapsedTime
//                    + ", maxTime = " + stats.maxTime);
//        }
//        if (stats.count % statLogFrequency == 0) {
//            long avgTime = stats.totalTime / stats.count;
//            long runningAvg = (stats.totalTime - stats.lastTotalTime) / statLogFrequency;
//            String logMsg = "method: " + methodName + "(), cnt = " + stats.count + ", lastTime = " + elapsedTime
//                    + ", avgTime = " + avgTime + ", runningAvg = " + runningAvg + ", maxTime = " + stats.maxTime;
//            if (eLogLevel.name().equalsIgnoreCase(ELogLevel.INFO.name())) {
//                LOGGER.info(logMsg);
//            } else {
//                LOGGER.debug(logMsg);
//            }
//            // reset the last total time
//            stats.lastTotalTime = stats.totalTime;
//        }
//    }
//
//    class MethodStats {
//        public String methodName;
//        public long count;
//        public long totalTime;
//        public long lastTotalTime;
//        public long maxTime;
//
//        public MethodStats(String methodName) {
//            this.methodName = methodName;
//        }
//    }
//}
