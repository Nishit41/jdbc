package com.bridgelabz;

import java.sql.*;
import java.util.Enumeration;

public class JdbcSample2 {


       public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/payroll_service?characterEncoding=latin1";
        String USER = "root";
        String PASS = "Nishit@41";
        Connection con;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        }
        catch (ClassNotFoundException e){
            throw new IllegalStateException("Cannot find the driver in ths classpath!",e);
        }

           try{
               con = DriverManager.getConnection(URL, USER, PASS);
               Statement statement = con.createStatement();
               statement.execute("update employee_payroll set salary=3000000.00 where name='Terisa'");
               ResultSet result =  statement.executeQuery("select * from employee_payroll");
               while(result.next()){
                   System.out.println(result.getInt("id")+" " +
                           result.getString(2) +" "+
                           result.getString(3)+ " "+
                           result.getDouble(4)+" "+
                           result.getDate(5));
               }
           }
           catch (Exception e){
               e.printStackTrace();
           }

        listDrivers();

        try{
            System.out.println("Connecting to database: "+URL);
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connection is successful!!!! "+con);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void listDrivers() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while(driverList.hasMoreElements()){
            Driver driverClass = driverList.nextElement();
            System.out.println(" "+driverClass.getClass().getName());
        }
    }
}

