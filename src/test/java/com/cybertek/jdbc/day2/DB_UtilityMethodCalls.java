package com.cybertek.jdbc.day2;

public class DB_UtilityMethodCalls {
    public static void main(String[] args) {
        DB_Utility.CreateConnection();
        DB_Utility.runQuery("SELECT * FROM JOBS ");
        DB_Utility.displayAllData();

      //  System.out.println("Column count is "+DB_Utility.getColumnCNT());
     //   System.out.println("Column count is "+DB_Utility.getRowCount());

        System.out.println("Getting the data at 3rd row as Map: \n"
              +DB_Utility.getRowMap(3)  );

        DB_Utility.destroy();
    }
}
