package com.cybertek.jdbc.day2;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DB_Practice {
    public static void main(String[] args) throws SQLException {
        DB_Utility.CreateConnection();

        ResultSet rs = DB_Utility.runQuery("SELECT * FROM jobs");

       /* while(rs.next()==true){
            System.out.println(rs.getString(2));
        }

        */

        System.out.println("colCount = "+DB_Utility.getColumnCNT());


        //get the first row data | without knowing the column names

        int colCount = DB_Utility.getColumnCNT();
        rs.first(); //moving to the first row of data


        for (int i = 1; i<=colCount;i++){
            System.out.print(rs.getString(i) + "\t");
        }


    }
}
