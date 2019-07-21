package com.stackroute;

import com.stackroute.jdbc.*;

public class App 
{

    //Main method
    public static void main( String[] args )

    {
        //Object creation of various classes to display, update etc. values in table
        //EMPLOYEE of database STACKROUTE
        RowsetDemo rsdemo = new RowsetDemo();
        JdbcTransactionDemo jtdemo = new JdbcTransactionDemo();
        JdbcBatchDemo jbdemo = new JdbcBatchDemo();
        ResultSetMetaDataDemo rsmddemo = new ResultSetMetaDataDemo();
        DatabaseMetadataDemo dbmddemo = new DatabaseMetadataDemo();
        JdbcDemo jdbcDemo=new JdbcDemo();

        //Displaying all rows in table
        System.out.println("--------------------------------------------");
        System.out.println("Displaying employee details");
        jdbcDemo.getEmployeeDetails();

        //Displaying all rows in table in reverse order
        System.out.println("\n\n--------------------------------------------");
        System.out.println("Displaying employee details in reverse order");
        jdbcDemo.getEmployeeDetailsInReverse();

        //Displaying all rows in reverse in the table except the first row
        System.out.println("\n\n--------------------------------------------");
        System.out.println("Displaying employee details in reverse order skipping first entry");
        jdbcDemo.getEmployeeDetailsFromSecondRowInReverse();

        //Displying all details of the mentioned name only from the table
        System.out.println("\n\n--------------------------------------------");
        System.out.println("Displaying Data for a particular name");
        jdbcDemo.getEmployeeDetailsByNameAndGender("AKSHITA","F");

        //Displaying information of driver and database metadata
        System.out.println("\n\n--------------------------------------------");
        System.out.println("Displaying META DATA of database accessed");
        dbmddemo.establishConnection();

        //Displaying information of tables with column types and names
        System.out.println("--------------------------------------------");
        System.out.println("\n\nDisplaying META DATA of result set");
        rsmddemo.showResultSet();

        //Calling method to add values in table in batch
       // jbdemo.batchQueries();

        //Displaying data of table
        System.out.println("--------------------------------------------");
        jtdemo.transactionMethod();

        //Displaying table data using JdbcRowSet
        System.out.println("--------------------------------------------");
        System.out.println("Displaying employee details using Rowset");
        rsdemo.rowMethod();

        //Displaying the table rows post modifications to reflect changes if any
        System.out.println("--------------------------------------------");
        System.out.println("Displaying employee details");
        jdbcDemo.getEmployeeDetails();

    }
}
