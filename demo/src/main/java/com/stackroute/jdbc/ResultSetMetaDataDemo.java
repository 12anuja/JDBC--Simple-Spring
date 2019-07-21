package com.stackroute.jdbc;

import java.sql.*;


//Jdbc connection to Mysql table EMPLOYEE of database STACKROUTE
public class ResultSetMetaDataDemo {

    //Method to display no. of columns, names and data types of columns in selected table
    public void showResultSet() {
        Connection connection = null;
        PreparedStatement ps = null;
        DatabaseMetaData dbmd = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/STACKROUTE", "root", "Root@123");

            ps=connection.prepareStatement("select * from EMPLOYEE");
            ResultSet rs=ps.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();

            System.out.println("Total columns: "+rsmd.getColumnCount());
            System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));
            System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1));


        } catch (Exception ex) {

            ex.printStackTrace();
        } finally {
            try {
                connection.close();
                ps.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
