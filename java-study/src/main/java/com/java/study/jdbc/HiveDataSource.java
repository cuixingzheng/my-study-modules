package com.java.study.jdbc;

import com.alibaba.fastjson.JSONObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：HiveDataSource
 * 类描述：
 * 创建人：杨骞
 * 修改人：杨骞
 * 修改时间：2020/5/25 11:12
 * 修改备注：
 */
public class HiveDataSource extends ParentDataSource {

    private String urls;
    public HiveDataSource(String host, int port, String dbName, String userName, String password) {
        super(null, -1,"", userName, password);
        this.urls = host;
    }




    /**
     * @author xiaoyu
     * @createTime 2020/5/25 11:12
     * @return
     * @throws Exception
     */
    @Override
    protected Connection getConnection() throws Exception {
        String url = "jdbc:hive2://%s";
        String urlEnd = String.format(url, urls);
        //注册驱动
        Class.forName("org.apache.hive.jdbc.HiveDriver");
        return DriverManager.getConnection(urlEnd, super.userName,super.password);
    }

    /**
     * @author xiaoyu
     * @createTime 2020/5/25 11:12
     * @param sql
     * @return
     * @throws Exception
     */
    @Override
    public List<JSONObject> query(String... sql) throws Exception {
        try {
            this.conn = this.getConnection();
            if (sql==null || sql.length<=0){
                return null;
            }
            for (int i = 0; i < sql.length - 1; i++) {
                if(sql[i]!=null&&!"".equals(sql[i].trim())){
                    execute(sql[i]);
                }
            }
           /* if (sql.length==1){
                return queryFinally(sql[0]);
            }
            for (int i = 0; i < sql.length - 1; i++) {
                execute(sql[i]);
            }*/
            return queryFinally(sql[sql.length-1]);
        } catch (Exception e) {
            throw e;
        } finally {
            this.close();
        }
    }

    /**
     * 执行sql
     * @author xiaoyu
     * @createTime 2020/5/25 11:12
     * @param sql
     * @throws SQLException
     */
    private void execute(String sql) throws SQLException {
        //获取执行sql的对象
        st = conn.createStatement();
        //执行sql
        st.execute(sql);
    }

    /**
     * 最后结果查询
     * @author xiaoyu
     * @createTime 2020/5/25 11:12
     * @param sql
     * @return
     * @throws Exception
     */
    private List<JSONObject> queryFinally(String sql) throws SQLException {
        List<JSONObject> resultList = null;
        //获取执行sql的对象
        st = conn.createStatement();
        //执行sql
        rs = st.executeQuery(sql);
        if (rs != null) {
            resultList = new ArrayList<JSONObject>();
            ResultSetMetaData rsmd = rs.getMetaData();
            int count = rsmd.getColumnCount();
            while (rs.next()) {
                JSONObject result = new JSONObject();
                for (int i = 1; i <= count; i++) {
                    String key = rsmd.getColumnName(i);
                    Object value = rs.getObject(i);
                    result.put(key, value);
                }
                resultList.add(result);
            }
        }
        return resultList;
    }

    @Override
    public void insert(String tableName, JSONObject json,JSONObject appendField) throws Exception {
        throw new Exception("未实现此方法");
    }
    /*@Override
    public List<JSONObject> explain(String sql) throws Exception {
        return validateAndExplain(sql);
    }*/

    @Override
    public void insertBatch(String tableName, Integer batchNum, List<JSONObject> list,JSONObject appendField,String threadUuid) throws Exception {
        throw new Exception("未实现此方法");
    }

    @Override
    public void createTable(JSONObject createSql, Boolean isDrop) throws Exception {
        throw new Exception("未实现此方法");
    }
    @Override
    public void delete(String sql) throws Exception {
        throw new Exception("未实现此方法");
    }

    @Override
    protected boolean validateUser(String userName) {
        return true;
    }


    @Override
    public void setBatchType(Statement st,Long batchSize) throws Exception {
        st.setFetchSize(batchSize != null?(int) batchSize.longValue():50000);
    }
}
