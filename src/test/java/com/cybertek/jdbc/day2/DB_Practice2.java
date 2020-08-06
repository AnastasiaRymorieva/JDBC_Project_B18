package com.cybertek.jdbc.day2;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_Practice2 {
    public static void main(String[] args) throws SQLException {
        DB_Utility.CreateConnection();

        ResultSet rs = DB_Utility.runQuery("SELECT * FROM regions");

        //get the first row data | without knowing the column names

        DB_Utility.displayAllData();
        System.out.println(DB_Utility.getColumnDataAtRow(3,2));
        System.out.println(DB_Utility.getColumnName(3,"region_name"));



        System.out.println(DB_Utility.getRowDataAsList(3));


        System.out.println(DB_Utility.getColumnDataAsList(2));
    }
}
