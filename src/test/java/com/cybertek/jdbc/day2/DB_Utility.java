package com.cybertek.jdbc.day2;

import javax.management.Query;
import java.sql.*;
import java.util.*;

public class DB_Utility {

    private static Connection conn;
    private static Statement stmnt;
    private static ResultSet rs = null;

    public static void destroy() {
        try {
            if (rs != null) {
                rs.close();
            }
            if(stmnt!=null){
                stmnt.close();
            }
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     *Storing data as a map
     * Map <String,String>
     */
    public static Map<String, String> getRowMap(int rowNum) {
        Map<String, String> rowMap = new HashMap<>();

        try {
            rs.absolute(rowNum);
            ResultSetMetaData rsdm = rs.getMetaData();
            for (int colNum = 1; colNum <= getColumnCNT(); colNum++) {
                String colName = rsdm.getColumnName(colNum);
                String colValue = rs.getString(colNum);
                rowMap.put(colName, colValue);
            }

        } catch (SQLException e) {
            System.out.println("Error at Row Map Function");
        }

        return rowMap;
    }

    public static List<String> getColumnDataAsList(int columnIndex) {
        List<String> columnDataList = new ArrayList<>();
        try {
            rs.beforeFirst();
            while (rs.next()) {
                columnDataList.add(rs.getString(columnIndex));
            }
            rs.beforeFirst();

        } catch (SQLException e) {
            System.out.println("ERROR While getting colunm Data as list");
        }

        return columnDataList;
    }


    /*
     * getting cell using column name
     */
    public static String getColumnName(int rowNum, String columnName) {
        String result = "";
        try {
            rs.absolute(rowNum);
            result = rs.getString(columnName);
        } catch (SQLException e) {
            System.out.println("ERROR while getColumnDataAtRow");
            e.printStackTrace();
        }
        return result;
    }

    /*
     *Getting single column cell value at certain row
     * row 2 column 3 --> the data
     */
    public static String getColumnDataAtRow(int rowNum, int columnIndex) {
        String result = "";
        try {
            rs.absolute(rowNum);
            result = rs.getString(columnIndex);
        } catch (SQLException e) {
            System.out.println("ERROR while getColumnDataAtRow");
            e.printStackTrace();
        }
        return result;
    }


    /*
     * method to display all the data in the result set

     */
    public static void displayAllData() {
        int colCount = DB_Utility.getColumnCNT();

        try {
            rs.beforeFirst();
            while (rs.next() == true) {

                for (int i = 1; i <= colCount; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
            //need to remove cursor to first location
            rs.beforeFirst();
        } catch (SQLException e) {
            System.out.println("ERROR WHILE GETTING ALL DATA");
            e.printStackTrace();
        }

    }

    /*
     *a method to get the column count if the current ResultSet
     * getColumnCount()
     */
    public static int getColumnCNT() {

        int colCount = 0;
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            colCount = rsmd.getColumnCount();
        } catch (SQLException e) {
            System.out.println("ERROR WHILE COUNTING THE COLUMNS");
            e.printStackTrace();
        }


        return colCount;
    }

    /*
     * a method to create connection
     * with valid url and password     *
     */
    public static void CreateConnection() {
        String connectionStr = "jdbc:oracle:thin:@34.207.121.25:1521:XE";
        String username = "hr";
        String password = "hr";
        try {
            conn = DriverManager.getConnection(connectionStr, username, password);
            System.out.println("Connection SUCCESSFUL");
        } catch (SQLException e) {
            System.out.println("CONNECTION HAS FAILED");
            e.printStackTrace();
        }
    }

    /*
     *a method to get the resultSet object
     * with valid connection by executing query
     */
    public static ResultSet runQuery(String Query) {

        try {
            stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmnt.executeQuery(Query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    /*
     * Getting entire row as List<String>
     */
    public static List<String> getRowDataAsList(int rowNum) {
        List<String> rowDataList = new ArrayList<>();

        try {
            rs.absolute(rowNum);
            for (int colNum = 1; colNum <= getColumnCNT(); colNum++) {
                rowDataList.add(rs.getString(colNum));
            }
            rs.beforeFirst();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while getRowDATAASList");
        }
        return rowDataList;
    }

    public static int getRowCount() {
        int rowCount = 0;
        try {
            rs.last();
            rowCount = rs.getRow();
            rs.beforeFirst();

        } catch (SQLException e) {
            System.out.println("Error while getting row count");
        }
        return rowCount;
    }

}
