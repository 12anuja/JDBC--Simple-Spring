package com.stackroute.jdbc;

import java.sql.*;


//Jdbc Connection for MYsql table EMPLOYEE in database STACKROUTE
public class JdbcDemo {

   //  private Connection connection;
  //  private Statement statement;
   // private ResultSet resultSet;


    //Method to fetch details of employees in table
    public void getEmployeeDetails() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/STACKROUTE", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from EMPLOYEE");) {
            /*Load driver and register with DriverManager*/

            /*Use DriverManager to get Connection*/
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");

//             statement = connection.createStatement();
//
//             resultSet = statement.executeQuery("Select * from employee");

            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2)
                + " Gender:  "+resultSet.getString(3) + " Age: "+resultSet.getString(4));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
//        finally {
//            try {
//                connection.close();
//                statement.close();
//                resultSet.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }

    }


    /*Print ResultSet in reverse order*/
    public void getEmployeeDetailsInReverse()
    {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/STACKROUTE", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from EMPLOYEE");) {
            resultSet.afterLast();
            while (resultSet.previous()) {
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2)
                        + " Gender:  "+resultSet.getString(3) + " Age: "+resultSet.getString(4));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /*Move ResultSet to second row and print in reverse order*/
    public void getEmployeeDetailsFromSecondRowInReverse()
    {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/STACKROUTE", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from EMPLOYEE");) {
            resultSet.afterLast();
            while (resultSet.previous() &&(!resultSet.isFirst()))
            {
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2)
                        + " Gender:  "+resultSet.getString(3) + " Age: "+resultSet.getString(4));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    /*Use PreparedStatement to display by name and gender*/
    public void getEmployeeDetailsByNameAndGender(String name, String gender)
    {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" +
                    "STACKROUTE", "root", "Root@123");

             String sql = "Select * from EMPLOYEE where NAME=? and GENDER=?";
             PreparedStatement ps = connection.prepareStatement(sql);
             ps.setString(1,name);
             ps.setString(2,gender);
             ResultSet resultSet = ps.executeQuery();
            while (resultSet.next())
            {
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2)
                        + " Gender:  "+resultSet.getString(3) + " Age: "+resultSet.getString(4));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


}
