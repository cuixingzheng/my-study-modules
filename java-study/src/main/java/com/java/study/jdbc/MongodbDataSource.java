package com.java.study.jdbc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.*;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.json.JsonWriterSettings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MongodbDataSource extends AbstractDataSource<MongoDatabase> {
    MongoClient mongoClient = null;
    private MongoDatabase db = null;

    public MongodbDataSource(String host, int port, String dbName, String userName, String password) {
        super(host, port, dbName, userName, password);
    }

    @Override
    protected MongoDatabase getConnection() throws Exception {
        // 组装权限对象
        final List<MongoCredential> credentialsLists = new ArrayList<MongoCredential>();
        if (userName != null && password != null && !"".equals(userName.trim()) && !"".equals(password.trim())) {
            MongoCredential credential = MongoCredential.createCredential(userName,
                    dbName, super.password.toCharArray());
            credentialsLists.add(credential);
        }

        if (credentialsLists.size() > 0) {
            mongoClient = new MongoClient(new ServerAddress(host, port), credentialsLists);
        } else {
            mongoClient = new MongoClient(new ServerAddress(host, port));
        }
        return mongoClient.getDatabase(dbName);
    }

    @Override
    protected void close() {
        try {
            if (mongoClient != null) {
                mongoClient.close();
                mongoClient = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void closeConnect() {
        close();
    }

    @Override
    public List<JSONObject> validateAndExplain(String sql) throws Exception {
        JSONObject result = null;
        try {
            db = this.getConnection();
            BasicDBObject bdr = BasicDBObject.parse(sql);
            if (!bdr.containsField("explain")) {
                bdr.put("explain", true);
            }
            if (!bdr.containsField("cursor")) {
                bdr.put("cursor", new BasicDBObject("batchSize", 2147483647));
            }
            result = JSON.parseObject(db.runCommand(bdr).toJson(JsonWriterSettings.builder().build()));
        } catch (Exception e) {
            throw e;
        } finally {
            this.close();
        }
        List<JSONObject> results = new ArrayList<>();
        results.add(result);
        return results;
    }

    @Override
    public JSONObject isCheckConnection() {
        JSONObject json = new JSONObject();
        try {
            db = this.getConnection();
            db.runCommand(BasicDBObject.parse("{aggregate:'testtesttest',pipeline:[],cursor:{batchSize:1}}"));
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
        BasicDBObject bdr = BasicDBObject.parse(sql);
        BasicDBObject skip = new BasicDBObject("$skip", 0);
        BasicDBObject limit = new BasicDBObject("$limit", getSampleCount(sampleCount));
        if (!bdr.containsField("pipeline")) {
            bdr.put("pipeline", Arrays.asList(skip, limit));
        } else {
            List<BasicDBObject> pipeline = (List<BasicDBObject>) bdr.get("pipeline");
            pipeline.add(skip);
            pipeline.add(limit);

        }
        return query(true, bdr.toJson());
    }

    private static boolean hasNext(Document commandResult) {
        if (!commandResult.containsKey("cursor")) {
            return false;
        } else {
            Object next = getNextBatchId(commandResult);
            return next != null && ((Number)next).longValue() != 0L;
        }
    }

    private static Object getNextBatchId(Document commandResult) {
        return ((Document)commandResult.get("cursor")).get("id");
    }


    @Override
    protected List<JSONObject> executeQuery(boolean isMasking, String... sql) throws Exception {
        List<JSONObject> resultList = null;
        try {
            db = this.getConnection();
            String sq = sql[sql.length - 1];
            BasicDBObject bdr = BasicDBObject.parse(sq);
            if (!bdr.containsField("cursor")) {
                bdr.put("cursor", new BasicDBObject("batchSize", 2147483647));
            }
            Document documentResult = db.runCommand(bdr);
            int count =0;
            resultList = getDataToJson(documentResult);
            count = resultList.size();
            while (hasNext(documentResult)){
                BasicDBObject newBdr = new BasicDBObject("getMore",getNextBatchId(documentResult)).append("collection", bdr.get("aggregate")).append("batchSize", 2147483647);
                documentResult = db.runCommand(newBdr);
                count += getDataToJson(documentResult).size();
            }
            System.out.println("count = " + count);
        } catch (Exception e) {
            throw e;
        } finally {
            this.close();
        }
        return resultList;
    }

    protected CommonResultSet executeQueryBatch(Long batchSize,boolean isMasking, String... sql) throws Exception {
            db = this.getConnection();
            String sq = sql[sql.length - 1];
            BasicDBObject bdr = BasicDBObject.parse(sq);
            if (!bdr.containsField("cursor")) {
                bdr.put("cursor", new BasicDBObject("batchSize", 2147483647));
            }
            Document documentResult = db.runCommand(bdr);
            CommonResultSet commonResultSet = CommonResultSet.initInstance();
            commonResultSet.setDocument(documentResult);
            commonResultSet.setResult(getDataToJson(documentResult));
            commonResultSet.setBasicDBObject(bdr);
            commonResultSet.setHasNext(true);
            return commonResultSet;
    }

    protected CommonResultSet nextQuery(CommonResultSet commonResultSet) throws Exception {
        if(hasNext(commonResultSet.getDocument())){
            if(db == null)
                throw new NullPointerException("MongoDatabase is null");
            BasicDBObject newBdr = new BasicDBObject("getMore", getNextBatchId(commonResultSet.getDocument())).append("collection", commonResultSet.getBasicDBObject().get("aggregate")).append("batchSize",2147483647);
            commonResultSet.setDocument(db.runCommand(newBdr));
            commonResultSet.setResult(getDataToJson(commonResultSet.getDocument()));
            commonResultSet.setHasNext(true);
            return commonResultSet;
        }
        commonResultSet.setHasNext(false);
        commonResultSet.setResult(new ArrayList<>());
        commonResultSet.setDocument(null);
        return commonResultSet;
    }






    private List<JSONObject> getDataToJson(Document documentResult){
        List<JSONObject> resultList = null;
        JSONObject commandResult = JSON.parseObject(documentResult.toJson(JsonWriterSettings.builder().build()));
        if (!commandResult.containsKey("cursor")) {
            resultList = (List<JSONObject>) commandResult.get("result");
        } else {
            //新版本mongodb3.4以上版本
            JSONObject cursor = commandResult.getJSONObject("cursor");
            if (cursor.containsKey("firstBatch")) {
                resultList = (List<JSONObject>) cursor.get("firstBatch");
            } else {
                resultList = (List<JSONObject>) cursor.get("nextBatch");
            }
        }
        return resultList;
    }



    @Override
    protected boolean validateSql(String... sql) {
        String[] unDoSqls = new String[]{"drop", "remove"};
        for (String sqlItem : sql) {
            if (sqlItem!=null&&sqlItem.toLowerCase().indexOf('*') > 0) {
                return false;
            }

            for (String unDoSql : unDoSqls) {
                if (sqlItem!=null&&sqlItem.toLowerCase().indexOf(unDoSql) > 0) {
                    return false;
                }
            }
        }
        return true;
    }




    public static void main(String[] args) {
        MongodbDataSource mongodbDataSource = DataSourceFactory.getDataSource(MongodbDataSource.class,
                "tiku.mongo.test.duia.com", 27017, "data_statistics", "tiku", null);
        try {

            mongodbDataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        CommandResult commResult = mongodbDataSource.mongoClient.getDB("data_statistics")
//                .doEval("function query() {\n" +
//                        "    var result = [];\n" +
//                        "    for (i = 1; i <= 5; i++) {\n" +
//                        "        var c = db.getCollection('api_track_all_first_' + i).find({}).limit(10);\n" +
//                        "        while(c.hasNext()) {\n" +
//                        "            result.push(c.next());\n" +
//                        "        }\n" +
//                        "    }\n" +
//                        "    return result;\n" +
//                        "}");
//        BasicDBList basicDBList = (BasicDBList) commResult.get("retval");
//        BasicDBObject basicDBObject = (BasicDBObject) basicDBList.get(0);
//        System.out.println(basicDBObject);




        try {
            //List<JSONObject> query = mongodbDataSource.query("db.getCollection('api_track_register_first').find({})");
            String sql = "{ \"aggregate\" : \"api_track_register_first\", \"pipeline\" : [{ \"$match\" : {count:{$gt:1} } }] }";
            //List<JSONObject> query = mongodbDataSource.query(sql);
            CommonResultSet commonResultSet = mongodbDataSource.queryBatch(1000L,false,sql);
            while (commonResultSet.isHasNext()){
                commonResultSet = mongodbDataSource.nextQuery(commonResultSet);
            }
        } catch (Exception e) {
            mongodbDataSource.close();
            e.printStackTrace();
        }

    }

}
