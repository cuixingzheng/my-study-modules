package com.java.study.jdbc;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * 类名称：ParentDataSource
 * 类描述：
 * 创建人：杨骞
 * 修改人：杨骞
 * 修改时间：2020/5/27 11:09
 * 修改备注：
 */
public abstract class ParentDataSource extends AbstractDataSource<Connection> {
    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public ParentDataSource(String host, int port, String dbName, String userName, String password) {
        super(host, port, dbName, userName, password);
    }

    @Override
    protected Connection getConnection() throws Exception {
        return null;
    }


    @Override
    protected void close() {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (st != null) {
                st.close();
                st = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public JSONObject isCheckConnection() {
        JSONObject json = new JSONObject();
        try {
            conn = this.getConnection();
            json.put("code", 200);
            json.put("msg", "成功");
        } catch (Exception e) {
            json.put("code", 500);
            json.put("msg", e.getMessage());
        } finally {
            this.close();
            return json;
        }
    }

    /**
     * 创建表
     *
     * @param createSql {tableName:"test",columns:[{cname:"a",ctype:"varcher",isNull:1,default:"小明",ccomment:"备注说明"}],indexs:[{iname:"in_a",columns:["a","b"],unique:1}]}
     * @param isDrop    如果表存在是否删除后在创建
     * @throws Exception
     */
    @Override
    public void createTable(JSONObject createSql, Boolean isDrop) throws Exception {
        try {
            String tableName = createSql.getString("tableName");
            JSONArray columns = createSql.getJSONArray("columns");
            StringBuffer sql = new StringBuffer();
            sql.append("CREATE TABLE IF NOT EXISTS ").append(tableName);
            sql.append("(id int(11) NOT NULL AUTO_INCREMENT,");
            for (int j = 0; j < columns.size(); j++) {
                //`update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '对啊数据更新时间'
                JSONObject json = columns.getJSONObject(j);
                sql.append(json.getString("cname"));
                sql.append(" ").append(json.getString("ctype"));
                if ("1".equals(json.getString("isNull"))) {
                    sql.append(" NOT NULL");
                }
                if (null != json.getString("default") && !"".equals(json.getString("default").trim())) {
                    sql.append(" DEFAULT '").append(json.getString("default")).append("'");
                } else if (!"1".equals(json.getString("isNull"))) {
                    sql.append(" DEFAULT NULL");
                }
                if (null != json.getString("ccomment")) {
                    sql.append(" COMMENT '").append(json.getString("ccomment")).append("',");
                }
            }
            sql.append("PRIMARY KEY (id) USING BTREE");
            JSONArray indexs = createSql.getJSONArray("indexs");
            for (int k = 0; k < indexs.size(); k++) {
                JSONObject json = indexs.getJSONObject(k);
                String col = JSONObject.parseArray(json.getJSONArray("columns").toJSONString(), String.class).toString();
                col = col.replace("[", "(").replace("]", ")");
                if ("1".equals(json.getString("unique"))) {
                    sql.append(",UNIQUE KEY ");
                } else {
                    sql.append(",KEY ");
                }
                sql.append(json.getString("iname"))
                        .append(" ").append(col).append(" USING BTREE");
            }

            sql.append(" ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ");
            conn = this.getConnection();
            //设置自动提交关闭
            conn.setAutoCommit(false);
            st = conn.createStatement();
            if (null != isDrop && isDrop) {
                String dropSql = "DROP TABLE IF EXISTS " + tableName;
                st.addBatch(dropSql);
            }
            st.addBatch(sql.toString());
            st.executeBatch();
            conn.commit();
            st.clearBatch();
        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            this.close();
        }
    }

    @Override
    public JSONObject getTableColumns(String sql, int sampleCount) throws Exception {
//        JSONObject json = new JSONObject();
//        List<JSONObject> resultList = query(sampleCount, sql);
//        if (null != resultList && resultList.size() > 0) {
//            json.put("code", 200);
//            json.put("msg", "成功");
//            json.put("data", getFields(resultList, resultList.size()));
//        } else {
//            json.put("code", 500);
//            json.put("msg", "无数据");
//        }
        return null;
    }

    @Override
    public List<JSONObject> query(int sampleCount, String sql) throws Exception {
        if (sql.trim().endsWith(";")) {
            sql = sql.substring(0, sql.length() - 1);
        }
        String sqls = sql.contains("limit") ? sql : sql + " limit 0," + getSampleCount(sampleCount);
        return query(true, sqls);
    }

    @Override
    public List<JSONObject> validateAndExplain(String sql) throws Exception {
        List<JSONObject> jsonObjectList = query(false, "EXPLAIN " + sql);
        if (jsonObjectList != null && jsonObjectList.size() > 0) {
            return jsonObjectList;
        }
        return null;
    }

    @Override
    protected List<JSONObject> executeQuery(boolean isMasking, String... sql) throws Exception {
//        List<JSONObject> resultList = null;
//        try {
//            String sq = sql[sql.length - 1];
//            conn = this.getConnection();
//            //获取执行sql的对象
//            st = conn.createStatement();
//            //执行sql
//            rs = st.executeQuery(sq);
//            if (rs != null) {
//                resultList = new ArrayList<JSONObject>();
//                ResultSetMetaData rsmd = rs.getMetaData();
//                int count = rsmd.getColumnCount();
//                while (rs.next()) {
//                    JSONObject result = new JSONObject();
//                    for (int i = 1; i <= count; i++) {
//                        String key = StringUtils.isNotBlank(rsmd.getColumnLabel(i)) ? rsmd.getColumnLabel(i) : rsmd.getColumnName(i);
//                        Object value = rs.getObject(i);
//                        value = DataSecurityUtils.decode(value);
//                        //数据脱敏
//                        if (isMasking) {
//                            value = DataSecurityUtils.masking(value);
//                        }
//                        result.put(key, value == null ? "" : value);
//                    }
//                    resultList.add(result);
//                }
//            }
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            this.close();
//        }
        return null;
    }

    @Override
    public void insert(String tableName, JSONObject json, JSONObject appendField) throws Exception {
//        try {
//            StringBuffer colStr = new StringBuffer();
//            StringBuffer colValueStr = new StringBuffer();
//            for (Map.Entry<String, Object> entry : json.entrySet()) {
//                colStr.append(",").append(entry.getKey());
//                colValueStr.append(",'").append(entry.getValue()).append("'");
//            }
//            if (appendField != null) {
//                for (Map.Entry<String, Object> entry : appendField.entrySet()) {
//                    colStr.append(",").append(entry.getKey());
//                    Object value = entry.getValue();
//                    colValueStr.append(",'").append(DataSecurityUtils.encode(value)).append("'");
//                }
//            }
//            String insertSql = "INSERT INTO %s (%s) VALUES(%s)";
//            insertSql = String.format(insertSql, tableName, colStr.toString().substring(1), colValueStr.toString().substring(1));
//            conn = this.getConnection();
//            st = conn.createStatement();
//            boolean i = st.execute(insertSql);
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            this.close();
//        }
    }

    @Override
    public void insertBatch(String tableName, Integer batchNum, List<JSONObject> list, JSONObject appendField, String threadUuid) throws Exception {
//        try {
//            if (null == batchNum) {
//                batchNum = defaultBatchNum;
//            } else if (batchNum < 1) {
//                batchNum = 1;
//            } else if (batchNum > 5000) {
//                batchNum = 5000;
//            }
//            JSONObject threadjson = (JSONObject) LockUtil.getInstance().get(threadUuid);
//            conn = this.getConnection();
//            //设置自动提交关闭
//            conn.setAutoCommit(false);
//            st = conn.createStatement();
//            for (int k = 0; k < list.size(); k++) {
//                JSONObject json = list.get(k);
//                StringBuffer colStr = new StringBuffer();
//                StringBuffer colValueStr = new StringBuffer();
//                for (Map.Entry<String, Object> entry : json.entrySet()) {
//                    colStr.append(",").append(entry.getKey());
//                    colValueStr.append(",'").append(entry.getValue()).append("'");
//                }
//                if (appendField != null) {
//                    for (Map.Entry<String, Object> entry : appendField.entrySet()) {
//                        colStr.append(",").append(entry.getKey());
//                        colValueStr.append(",'").append(entry.getValue()).append("'");
//                    }
//                }
//                String insertSql = "INSERT INTO %s (%s) VALUES(%s)";
//                insertSql = String.format(insertSql, tableName, colStr.toString().substring(1), colValueStr.toString().substring(1));
//                st.addBatch(insertSql);
//                if (k % batchNum == 0) {
//                    if (threadjson != null && null != threadjson.getString("kill") && !"".equals(threadjson.getString("kill").trim())) {
//                        st.clearBatch();
//                        throw new MyTreadException("收到线程终止命令");
//                    }
//                    st.executeBatch();
//                    conn.commit();
//                    st.clearBatch();
//                }
//            }
//            if ((list.size() - 1) % batchNum != 0) {
//                if (threadjson != null && null != threadjson.getString("kill") && !"".equals(threadjson.getString("kill").trim())) {
//                    st.clearBatch();
//                    throw new MyTreadException("收到线程终止命令");
//                }
//                st.executeBatch();
//                conn.commit();
//                st.clearBatch();
//            }
//
//        } catch (Exception e) {
//            conn.rollback();
//            throw e;
//        } finally {
//            this.close();
//        }
    }

    @Override
    public void delete(String sql) throws Exception {
        try {
            conn = this.getConnection();
            //获取执行sql的对象
            st = conn.createStatement();
            //执行sql
            int num = st.executeUpdate(sql);

        } catch (Exception e) {
            throw e;
        } finally {
            this.close();
        }
    }

    public List<String> queryTableNames() throws Exception {
        try {
            conn = this.getConnection();
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet tables = metaData.getTables(null, null, null, null);
            List<String> tableNames = new ArrayList<>();
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                tableNames.add(tableName);
            }
            return tableNames;
        } catch (Exception e) {
            throw e;
        } finally {
            this.close();
        }
    }

    public JSONObject queryTableNameAndColNames(String... tableNames) throws Exception {
        ExecutorService exec = null;
        try {
            conn = this.getConnection();
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet tables = metaData.getTables(null, null, null, null);
            JSONObject jsonObject = new JSONObject();
            exec = new ThreadPoolExecutor(10, 50, 10, TimeUnit.SECONDS,
                    new ArrayBlockingQueue<>(2));
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                if (tableNames != null && tableNames.length > 0) {
                    if (Arrays.asList(tableNames).contains(tableName)) {
                        Future<JSONArray> result = exec.submit(new QueryTableInfoCallable(tableName, metaData));
                        jsonObject.put(tableName, result.get());
                    } else {
                        continue;
                    }
                } else {
                    Future<JSONArray> result = exec.submit(new QueryTableInfoCallable(tableName, metaData));
                    jsonObject.put(tableName, result.get());
                }
            }
            return jsonObject;
        } catch (Exception e) {
            throw e;
        } finally {
            if (exec != null || exec.isShutdown()) {
                exec.shutdown();
            }
            this.close();
        }
    }

    public class QueryTableInfoCallable implements Callable<JSONArray> {
        private String tableName;

        private DatabaseMetaData metaData;

        public QueryTableInfoCallable(String tableName, DatabaseMetaData metaData) {
            this.tableName = tableName;
            this.metaData = metaData;
        }

        @Override
        public JSONArray call() throws Exception {
            ResultSet columns = metaData.getColumns(null, "%", tableName, "%");
            JSONArray jsonArray = new JSONArray();
            while (columns.next()) {
                jsonArray.add(columns.getString("COLUMN_NAME"));
            }
            return jsonArray;
        }
    }

    @Override
    protected boolean validateSql(String... sql) {
        String[] unDoSqls = new String[]{"*", "alter", "drop", "truncate", "comment", "rename", "insert",
                "delete", "merge", "call", "lock table", "grant", "revoke", "commit", "rollback", "savepoint", "set transaction"};
        ;
        for (String sqlItem : sql) {
            for (String unDoSql : unDoSqls) {
                if (sqlItem.toLowerCase().indexOf(unDoSql) > 0) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void closeConnect() {
        close();
    }

    @Override
    protected CommonResultSet executeQueryBatch(Long batchSize,boolean isMasking, String... sql) throws Exception {
        String sq = sql[sql.length - 1];
        conn = this.getConnection();
        //获取执行sql的对象
        st = conn.createStatement();
        //st.setFetchSize(Integer.MIN_VALUE);
        setBatchType(st,batchSize);
        //执行sql
        rs = st.executeQuery(sq);
        ResultSetMetaData rsmd = rs.getMetaData();
        int count = rsmd.getColumnCount();
        CommonResultSet commonResultSet = CommonResultSet.initInstance();
        commonResultSet.setBatchSize(batchSize);
        commonResultSet.setColumnCount(count);
        commonResultSet.setRsmd(rsmd);
        commonResultSet.setResultSet(rs);
        return nextQuery(commonResultSet);
    }

    @Override
    protected CommonResultSet nextQuery(CommonResultSet commonResultSet) throws Exception {
        ResultSet resultSet = commonResultSet.getResultSet();
        ResultSetMetaData rsmd = commonResultSet.getRsmd();
        int columnCount = commonResultSet.getColumnCount();
        List<JSONObject> resultList = new ArrayList<>();
        while (true){
            if(resultSet.next()){
                JSONObject result = new JSONObject();
                for (int i = 1; i <= columnCount; i++) {
                    String key = StringUtils.isNotBlank(rsmd.getColumnLabel(i)) ? rsmd.getColumnLabel(i) : rsmd.getColumnName(i);
                    Object value = rs.getObject(i);
                    result.put(key, value == null ? "" : value);
                }
                resultList.add(result);
                if(resultList.size() >= commonResultSet.getBatchSize()){
                    commonResultSet.setHasNext(true);
                    break;
                }
            }else {
                commonResultSet.setHasNext(false);
                break;
            }
        }
        commonResultSet.setResult(resultList);
        commonResultSet.setResultSet(rs);
        return commonResultSet;
    }

    public abstract void setBatchType(Statement st,Long batchSize) throws Exception;

}
