package com.cybertek.jdbc.day2;

import java.sql.*;
import java.util.*;

public class DB_Practice3 {
    public static void main(String[] args) throws SQLException {
        DB_Utility.CreateConnection();
        ResultSet rs = DB_Utility.runQuery("SELECT * from REGIONS");
        rs.next();

        //sore first row of data as a map<String,String>
        //the key of the map is column name, value of the map is the column data

        Map<String, String> rowMap = new HashMap<>();
        //  rowMap.put("REGION_ID",rs.getString(1));
        // rowMap.put("REGION_NAME",rs.getString(2));

        ResultSetMetaData rsmd = rs.getMetaData();
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
           rowMap.put(rsmd.getColumnName(i), rs.getString(i));
        }

        System.out.println("rowMap = "+rowMap);
        DB_Utility.destroy();
    }
}
