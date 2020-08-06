package com.cybertek.jdbc.day1;

import com.cybertek.jdbc.day2.DB_Utility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GettingMoreInfoAboutResultSet {
    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@34.207.121.25:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(connectionStr, username, password);
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmnt.executeQuery("SELECT * From employees");

        //ResultSetMetadata is dsts about the ResultSet like column count, name
        //any many more info

        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        System.out.println(columnCount);

        //find out column name according to thr index

        String secondColumName = rsmd.getColumnName(2);
        System.out.println("secondColumName = " + secondColumName);

        //How to list all the column names from the ResultSet
        //you know how many column we have using getColumnCount method
        //you know how to get column name from index getColumnName method

        for (int i=1;i<=columnCount;i++){
            System.out.println(rsmd.getColumnName(i));
        }

        //store the column names in the list
        List<String> columnNameList = new ArrayList<>();
        for (int i=1;i<=columnCount;i++){
            columnNameList.add(rsmd.getColumnName(i));
        }
        System.out.println(columnNameList);
        DB_Utility.destroy();
    }
}
