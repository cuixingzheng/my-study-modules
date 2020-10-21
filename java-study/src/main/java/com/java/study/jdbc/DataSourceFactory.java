package com.java.study.jdbc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 类名称：DataSourceFactory
 * 类描述：
 * 创建人：杨骞
 * 修改人：杨骞
 * 修改时间：2020/5/20 10:03
 * 修改备注：
 */
public class DataSourceFactory {


    public static <T extends AbstractDataSource> T getDataSource(Class<T> clazz, String host, int port, String dbName, String userName, String password) {
        Constructor<T> constructor = null;
        try {
            constructor = clazz.getConstructor(String.class, int.class, String.class, String.class, String.class);
            return constructor.newInstance(host, port, dbName, userName, password);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
