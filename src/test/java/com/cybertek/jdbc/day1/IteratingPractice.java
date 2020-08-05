package com.cybertek.jdbc.day1;

import java.sql.*;

public class IteratingPractice {
    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@34.207.121.25:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(connectionStr,username,password);

        //Statement stmnt = conn.createStatement(); moving forward only
        //ResultSet.TYPE_SCROLL_INSENSITIVE will make the resultset created from this statement
        //be able to move forward and backward
        //ResultSet.CONCUR_READ_ONLY will make resultset readonly and that's what we need
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmnt.executeQuery("SELECT * FROM COUNTRIES");
        rs.next();

        System.out.println(rs.getString(1)+ " " + rs.getString(2) + " " + rs.getString(3));

        rs.next();

        System.out.println(rs.getString(1)+ " " + rs.getString(2) + " " + rs.getString(3));
         rs.previous();

        System.out.println(rs.getString(1)+ " " + rs.getString(2) + " " + rs.getString(3));
rs.next();
        rs.previous();

        System.out.println(rs.getString(1)+ " " + rs.getString(2) + " " + rs.getString(3));

        rs.last();
        System.out.println(rs.getString(1)+ " " + rs.getString(2) + " " + rs.getString(3));
        rs.first();
        System.out.println(rs.getString(1)+ " " + rs.getString(2) + " " + rs.getString(3));
        rs.absolute(5); //move to particular row
        System.out.println(rs.getString(1)+ " " + rs.getString(2) + " " + rs.getString(3));
        System.out.println("=======================");
        //move to before first/last row
        rs.beforeFirst();
        rs.afterLast();


        //at the end need to close everything
        rs.close();
        stmnt.close();
        conn.close();




    }
}
