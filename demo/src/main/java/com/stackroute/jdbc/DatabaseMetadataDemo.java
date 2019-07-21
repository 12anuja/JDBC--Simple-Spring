package com.stackroute.jdbc;


import java.sql.*;

//Jdbc connection Mysql table EMPLOYEE in database STACKROUTE
public class DatabaseMetadataDemo {


    //Method to display name and version of Driver, name and version of Database Product and username of mysql
    //It also displays names of all tables present in the connected database STACKROUTE
    public void establishConnection() {
        Connection connection = null;
        Statement statement = null;
        DatabaseMetaData dbmd = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }

        try {

            connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/STACKROUTE", "root","Root@123") ;
            statement = connection.createStatement();

            //DataBaseMetaData object to fetch details of driver and database
            dbmd = connection.getMetaData();

            System.out.println("Driver Name: "+dbmd.getDriverName());
            System.out.println("Driver Version: "+dbmd.getDriverVersion());
            System.out.println("UserName: "+dbmd.getUserName());
            System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());
            System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());

            String table[]={"TABLE"};
            ResultSet rs=dbmd.getTables(null,null,null,table);

            System.out.println("Table in selected database");
            while(rs.next())
            {
                System.out.println(rs.getString(3));
            }


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