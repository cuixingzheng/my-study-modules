package com.java.study.jdbc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.BasicDBObject;
import org.bson.Document;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;

/**
 * @author: cxz
 * @create: 2020/9/2 10:42
 * @description:
 **/
public class CommonResultSet {

    private Document document;

    private ResultSet resultSet;

    private List<JSONObject> result;

    private boolean hasNext;

    private Long batchSize;

    private BasicDBObject basicDBObject;

    private ResultSetMetaData rsmd;

    private int columnCount;

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public List<JSONObject> getResult() {
        return result;
    }

    public void setResult(List<JSONObject> result) {
        this.result = result;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public static CommonResultSet initInstance(){
        return new CommonResultSet();
    }

    public Long getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(Long batchSize) {
        this.batchSize = batchSize;
    }

    public BasicDBObject getBasicDBObject() {
        return basicDBObject;
    }

    public void setBasicDBObject(BasicDBObject basicDBObject) {
        this.basicDBObject = basicDBObject;
    }

    public ResultSetMetaData getRsmd() {
        return rsmd;
    }

    public void setRsmd(ResultSetMetaData rsmd) {
        this.rsmd = rsmd;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }
}
