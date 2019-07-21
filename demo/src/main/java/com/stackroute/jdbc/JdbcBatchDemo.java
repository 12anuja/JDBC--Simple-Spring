package com.stackroute.jdbc;

import java.sql.*;


//Jdbc connection to Mysql table EMPLOYEE in database STACKROUTE
public class JdbcBatchDemo
{

    //Method to insert values in table in batch
    public void batchQueries()
    {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/STACKROUTE", "root","Root@123") ;
            statement = connection.createStatement();

            statement.addBatch("insert into EMPLOYEE values(190,'ADITI','F',29)");
            statement.addBatch("insert into EMPLOYEE values(191,'UTKARSH','M',24)");

            statement.executeBatch();//executing the batch


        } catch(Exception ex){

            ex.printStackTrace();
        }
        finally {
            try
            {
                connection.close();
                statement.close();

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
