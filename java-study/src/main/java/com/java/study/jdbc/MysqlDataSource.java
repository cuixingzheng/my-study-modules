package com.java.study.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MysqlDataSource extends ParentDataSource {
    public MysqlDataSource(String host, int port, String dbName, String userName, String password) {
        super(host, port, dbName, userName, password);
    }

    @Override
    protected Connection getConnection() throws Exception {
        String url = "jdbc:mysql://%s:%s/%s?useUnicode=true&amp;characterEncoding=UTF-8&amp;autoReconnect=true&amp;failOverReadOnly=false&amp;serverTimezone=Asia/Shanghai&amp;useCursorFetch=true";
        String urlEnd = String.format(url, super.host, super.port, super.dbName);
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(urlEnd, super.userName, super.password);
    }

    @Override
    public void setBatchType(Statement st,Long batchSize) throws Exception {
        if(st != null)
            st.setFetchSize(Integer.MIN_VALUE);
    }
}
