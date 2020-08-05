package com.cybertek.jdbc.day1;

import java.sql.*;

public class IteratingResultBackward {
    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@34.207.121.25:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(connectionStr, username, password);
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmnt.executeQuery("SELECT * From COUNTRIES");

        //first move to after las location
        // the keep moving to previous row as long as there is more row above

        rs.afterLast();
        rs.previous();


        while (rs.previous() == true) {
            System.out.println(rs.getString(1) + " " + rs.getString(2));

        }
        System.out.println("---------------");
        rs.absolute(2);
        System.out.println(rs.getString(1) + " " + rs.getString(2));
        System.out.println("Row number "+rs.getRow());

    }
}
