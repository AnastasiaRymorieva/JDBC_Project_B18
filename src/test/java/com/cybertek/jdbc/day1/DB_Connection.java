package com.cybertek.jdbc.day1;

import java.sql.*;


public class DB_Connection {
    public static void main(String[] args) throws SQLException {
        //Connection ---->> Statement ------>> Result Set
        //Driver manager is used to get the connection
        //The IP is the Ip address of EC2 instance that have Oracle database
        //This is known as connection string or url

        String connectionStr = "jdbc:oracle:thin:@34.207.121.25:1521:XE";
        String username = "hr";
        String password = "hr";

        //creating connection object using DriverManagers static method Connection
        Connection conn = DriverManager.getConnection(connectionStr,username,password);

        //creating statement object using the connection we have established

        Statement stmnt = conn.createStatement();

        //ResultSet object is what we use to store the actual result we get from query

        ResultSet rs = stmnt.executeQuery("SELECT * FROM REGIONS");

        //Result comes with a cursor used to navigate between rows
        //initially the cursor is at before first location (right before the first row)
        //in order to come to the first row we need to move the cursor
        //next() method is used to move the cursor and return the result as boolean

        rs.next();

        //getting the column data we use multiple get methods available in ResultSet

        System.out.println(rs.getString(1));
        System.out.println(rs.getString("region_id"));

        System.out.println("Second column value using index:  "+ rs.getString(2));
        System.out.println("Second column value using column name:  "+ rs.getString("region_name"));

        rs.next();

        System.out.println("Second column value using index:  "+ rs.getString(2));
        System.out.println("Second column value using column name:  "+ rs.getString("region_name"));


    }
}
