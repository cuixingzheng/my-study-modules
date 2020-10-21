package com.java.study.jdbc;


import com.alibaba.fastjson.JSONObject;
import com.java.study.util.ObjectUtils;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public abstract class AbstractDataSource<T> {
    protected String host;

    protected int port;

    protected String dbName;

    protected String userName;

    protected String password;

    private String taskId = "未知";

    private String lastUpdateUser = "未知";

    private String datasourceUserName = "未知";


    protected int defaultBatchNum = 1000;

    public AbstractDataSource(String host, int port, String dbName, String userName, String password) {
        this.host = host;
        this.port = port;
        this.dbName = dbName;
        this.userName = userName;
        this.password = password;
    }

    /**
     * 受保护(只允许子类调用) 不得更改(有意设计)
     *
     * @return
     * @throws Exception
     */
    protected abstract T getConnection() throws Exception;

    /**
     * 受保护(只允许子类调用) 不得更改(有意设计)
     */
    protected abstract void close();

    public abstract void closeConnect();

    /**
     * 执行计划
     *
     * @param sql
     * @return List<JSONObject>
     * @throws Exception
     */
    public abstract List<JSONObject> validateAndExplain(String sql) throws Exception;


    public List<JSONObject> explain(String sql) throws Exception {
        if (validate(sql)) {
            return validateAndExplain(sql);
        }
        return null;
    }

    /**
     * 方法：query
     * 描述：此方法先验证sql的安全性
     * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin
     *
     * @param sql :
     * @return : java.util.List<com.alibaba.fastjson.JSONObject>
     * @date: 2020年07月14日 11:50 上午
     */
    public List<JSONObject> query(String... sql) throws Exception {
        return this.query(false, sql);
    }


    public CommonResultSet queryBatch(Long batchSize,String... sql) throws Exception {
        return this.queryBatch(batchSize,false, sql);
    }


    /**
     * 方法：query
     * 描述：此方法先验证sql的安全性
     * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin
     *
     * @param isMasking :
     * @param sql       :
     * @return : java.util.List<com.alibaba.fastjson.JSONObject>
     * @date: 2020年07月14日 11:49 上午
     */
    public List<JSONObject> query(boolean isMasking, String... sql) throws Exception {
        if (validate(sql)) {
            return executeQuery(isMasking, sql);
        }
        return null;
    }

    public CommonResultSet queryBatch(Long batchSize,boolean isMasking, String... sql) throws Exception {
        if (validate(sql)) {
            return executeQueryBatch(batchSize,isMasking, sql);
        }
        return null;
    }

//    public CommonResultSet nextBatch(long batchSize,boolean isMasking, String... sql) throws Exception {
//        if (validate(sql)) {
//            return executeQueryBatch(batchSize,isMasking, sql);
//        }
//        return null;
//    }


    /**
     * 查询数据并返回结果集 只验证sql关键字
     *
     * @param isMasking
     * @param sql
     * @return List<JSONObject>
     * @throws Exception
     */
    public List<JSONObject> queryValidateSql(boolean isMasking, String... sql) throws Exception{
        if (validateSql(sql)) {
            return executeQuery(isMasking, sql);
        }
        return null;
    }
    /**
     * 查询数据并返回结果集 只验证数据源用户名
     *
     * @param isMasking
     * @param sql
     * @return List<JSONObject>
     * @throws Exception
     */
    public List<JSONObject> queryValidateUserName(boolean isMasking, String... sql) throws Exception{
        if (validateUser(this.userName)) {
            return executeQuery(isMasking, sql);
        }
        return null;
    }
    /**
     * 查询数据并返回结果集
     *
     * @param isMasking
     * @param sql
     * @return List<JSONObject>
     * @throws Exception
     */
    protected abstract List<JSONObject> executeQuery(boolean isMasking, String... sql) throws Exception;

    protected abstract CommonResultSet executeQueryBatch(Long batchSize,boolean isMasking, String... sql) throws Exception;
    protected abstract CommonResultSet nextQuery(CommonResultSet commonResultSet) throws Exception;

    /**
     * 查询数据并返回结果集
     *
     * @param sql
     * @return List<JSONObject>
     * @throws Exception
     */
    public abstract List<JSONObject> query(int sampleCount, String sql) throws Exception;

    /**
     * 检测是否可以链接通
     *
     * @return
     */
    public abstract JSONObject isCheckConnection();

    /**
     * @param sql         需要查询的sql
     * @param sampleCount 取样的数量 最小为1 最大为5
     * @return
     * @throws Exception
     */
    public abstract JSONObject getTableColumns(String sql, int sampleCount) throws Exception;

    /**
     * 创建表
     *
     * @param createSql {tableName:"test",columns:[{cname:"a",ctype:"varcher",isNull:1,default:"小明",ccomment:"备注说明"}],indexs:[{iname:"in_a",columns:["a","b"],unique:1}]}
     * @param isDrop    如果表存在是否删除后在创建
     * @throws Exception
     */
    public void createTable(JSONObject createSql, Boolean isDrop) throws Exception {
        throw new Exception("未实现此方法");
    }

    /**
     * 单条插入数据
     *
     * @param tableName   插入数据的表名
     * @param json        要插入的数据对象
     * @param appendField 添加对象追加数据
     * @throws Exception
     */
    public void insert(String tableName, JSONObject json, JSONObject appendField) throws Exception {
        throw new Exception("未实现此方法");
    }

    /**
     * 批量插入数据
     *
     * @param tableName   插入数据的表名
     * @param batchNum    批量插入的条数
     * @param list        要插入的数据集合
     * @param appendField 添加对象追加数据
     * @param threadUuid  线程uuid 用于中断线程
     * @throws Exception
     */
    public void insertBatch(String tableName, Integer batchNum, List<JSONObject> list, JSONObject appendField, String threadUuid) throws Exception {
        throw new Exception("未实现此方法");
    }

    public void update() throws Exception {
        throw new Exception("未实现此方法");
    }

    public void delete(String sql) throws Exception {
        throw new Exception("未实现此方法");
    }

    protected int getSampleCount(int sampleCount) {
        if (sampleCount < 1) {
            sampleCount = 1;
        } else if (sampleCount > 5) {
            sampleCount = 5;
        }
        return sampleCount;
    }


    private String javaToColumns(String javaType) {

        if (javaType == null || javaType.trim().length() == 0) {
            return javaType;
        }
        javaType = javaType.toLowerCase();
        switch (javaType) {
            case "string":
                return "varchar";
            case "byte":
                return "blob";
            case "long":
                return "bigint";
            case "integer":
            case "int":
                return "int";
            case "boolean":
                return "bit";
            case "fload":
            case "double":
            case "bigdecimal":
                return "decimal";
            case "date":
                return "datetime";
            case "Timestamp":
                return "timestamp";
            default:
                return "未知";
        }
    }

    protected abstract boolean validateSql(String... sql);

    protected boolean validateUser(String userName) {
        Properties p = new Properties();
        //从输入流中读取属性列表（键和元素对)
//        try {
//            p.load(this.getClass().getResourceAsStream("/sql_security.properties"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        String securityUser = p.getProperty("security.user");
        String[] securityUsers = null;
        if (ObjectUtils.isNotEmpty(securityUser)) {
            if (securityUser.contains(",")) {
                securityUsers = securityUser.split(",");
            } else {
                securityUsers = new String[]{securityUser};
            }
            for (String userItem : securityUsers) {
                if (userName.equalsIgnoreCase(userItem)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean validate(String... sql) {
//        if (!validateUser(this.userName)) {
//            //sendDingDing(sql);
//            return false;
//        } else if (!validateSql(sql)) {
//            //sendDingDing(sql);
//            return false;
//        }
        return true;
    }

    public void setTaskInfo(String taskId, String lastUpdateUser, String datasourceUserName) {
        if (ObjectUtils.isNotEmpty(taskId)) {
            this.taskId = taskId;
        }
        if (ObjectUtils.isNotEmpty(lastUpdateUser)) {
            this.lastUpdateUser = lastUpdateUser;
        }
        if (ObjectUtils.isNotEmpty(datasourceUserName)) {
            this.datasourceUserName = datasourceUserName;
        }
    }


}
