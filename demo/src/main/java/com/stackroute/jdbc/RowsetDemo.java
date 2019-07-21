package com.stackroute.jdbc;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class RowsetDemo
{

    public void rowMethod()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }

        try {

            JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
            rowSet.setUrl("jdbc:mysql://localhost:3306/STACKROUTE");
            rowSet.setUsername("root");
            rowSet.setPassword("Root@123");

            rowSet.setCommand("select * from EMPLOYEE");
            rowSet.execute();

            while (rowSet.next()) {
                // Generating cursor Moved event
                System.out.println("Id: " + rowSet.getInt(1));
                System.out.println("Name: " + rowSet.getString(2));
                System.out.println("Gender: " + rowSet.getString(3));
                System.out.println("Age: " + rowSet.getInt(4));
            }


        } catch(Exception ex){

            ex.printStackTrace();
        }

    }
}
