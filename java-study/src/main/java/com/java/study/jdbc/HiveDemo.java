package com.java.study.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author: cxz
 * @create: 2020/8/21 18:09
 * @description:
 **/
public class HiveDemo {

    public static void main(String[] args) {
        HiveDataSource mysqlDataSource = new HiveDataSource("42.62.16.75:10004",-1,"default","root","duia.com");
        try {
            Connection connection = mysqlDataSource.getConnection();

            String sql = "select year,month,week,day,hour from api_track_csv where detail_day=20181220";
//            String sql = "SELECT" +
//                    "  id" +
//                    ", platform" +
//                    ", channel" +
//                    ", sku_code" +
//                    ", scene\n" +
//                    ", `position`" +
//                    ", click_entry_consult_count" +
//                    ", valid_consult_count" +
//                    ", time_hour" +
//                    ", time_day" +
//                    ", time_week" +
//                    ", time_month" +
//                    " FROM result_app_consult_statistics_1 ";
            Statement pstmt = connection.createStatement();
            pstmt.setFetchSize(2000);
            ResultSet rs = pstmt.executeQuery(sql);
            int col = rs.getMetaData().getColumnCount();
            System.out.println("============================");
            int count = 0;
            while (rs.next()) {
                count ++;
//                for (int i = 1; i <= col; i++) {
//                    System.out.print(rs.getObject(i));
//                }
                //System.out.println("");
            }
            System.out.println("count = " + count);
            System.out.println("============================");

            connection.close();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
