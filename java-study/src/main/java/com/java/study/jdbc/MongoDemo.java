package com.java.study.jdbc;

import java.util.Objects;

/**
 * @author: cxz
 * @create: 2020/9/2 13:54
 * @description:
 **/
public class MongoDemo <T extends AbstractDataSource> {

    public static void main(String[] args) {
        //Class<T> sClazz=EDataSource.eDataSourceByType(beginSoutce.getType()).getaClass();
        //"tiku.mongo.test.duia.com", 27017, "data_statistics", "tiku", null);
        //Class sClazz= Objects.requireNonNull(EDataSource.eDataSourceByType(2)).getaClass();
//        MongodbDataSource t = DataSourceFactory.getDataSource(MongodbDataSource.class,"tiku.mongo.test.duia.com",27017,
//                "data_statistics", "tiku",null);
//
//        MongoDemo<MongodbDataSource> mongoDemo = new MongoDemo<>();
//        mongoDemo.execute(MongodbDataSource.class,"tiku.mongo.test.duia.com",27017,
//                "data_statistics", "tiku",null);
       // MysqlDataSource mysqlDataSource = new MysqlDataSource("localhost",3306,"data_statistics","root","123456");

//                MysqlDataSource t = DataSourceFactory.getDataSource(MysqlDataSource.class,"localhost",3306,
//                "data_statistics", "root","123456");

        //String sql = "";
//        String sql = "SELECT" +
//                "  id" +
//                ", platform" +
//                ", channel" +
//                ", sku_code" +
//                ", scene\n" +
//                ", `position`" +
//                ", click_entry_consult_count" +
//                ", valid_consult_count" +
//                ", time_hour" +
//                ", time_day" +
//                ", time_week" +
//                ", time_month" +
//                " FROM result_app_consult_statistics_1_002 ";
//        MongoDemo<MysqlDataSource> mongoDemo = new MongoDemo<>();
//        mongoDemo.execute(MysqlDataSource.class,"localhost",3306,
//                "data_statistics", "root","123456",sql);

//HiveDataSource mysqlDataSource = new HiveDataSource("42.62.16.75:10004",-1,"default","root","duia.com");
        String sql = "select year,month,week,day,hour from api_track_csv where detail_day=20181220";
        MongoDemo<HiveDataSource> mongoDemo = new MongoDemo<>();
        mongoDemo.execute(HiveDataSource.class,"42.62.16.75:10004",-1,"default","root","duia.com",sql);

    }

    public void execute(Class<T> clazz, String host, int port, String dbName, String userName, String password,String sql){
       T t = DataSourceFactory.getDataSource(clazz,host,port,
                dbName, userName,password);
        try {
            //String sql = "{ \"aggregate\" : \"api_track_register_first\", \"pipeline\" : [{ \"$match\" : {count:{$gt:1} } }] }";
            int all = 0;
            CommonResultSet commonResultSet = t.queryBatch(50000L,sql);
            all += commonResultSet.getResult().size();
            System.out.println("all :" + all);
            while (commonResultSet.isHasNext()){
                commonResultSet = t.nextQuery(commonResultSet);
                all += commonResultSet.getResult().size();
                System.out.println("all :" + all);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            t.closeConnect();
        }

    }



}
