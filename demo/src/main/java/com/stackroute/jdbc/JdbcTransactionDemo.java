package com.stackroute.jdbc;

import java.sql.*;


//Jdbc connection to Mysql table EMPLOYEE of database STACKROUTE
public class JdbcTransactionDemo
{

    //Method to connect to table using PreparedStatement and insert values
    //Autocommit and commit of transactions can be performed
    public void transactionMethod()
    {
        Connection connection = null;
        PreparedStatement ps = null;
        DatabaseMetaData dbmd = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }

        try {
            //connection.setAutoCommit(false);

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/STACKROUTE", "root","Root@123") ;

            String insertTableSQL = "INSERT INTO EMPLOYEE VALUES" + "(?,?,?,?)";
            ps = connection.prepareStatement(insertTableSQL);
            ps.setInt(1, 15);
            ps.setString(2, "PRANATI");
            ps.setString(3, "F");
            ps.setInt(4,25);
            ps.executeUpdate();

           // connection.commit();

        } catch(Exception ex){

            ex.printStackTrace();
        }
        finally {
            try
            {
                connection.close();
                ps.close();

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}

