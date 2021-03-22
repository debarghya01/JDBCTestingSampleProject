package com.poortoys.examples;

import java.sql.*;

public class AppMain {

    public static void main(String[] args) {
        System.out.println("Hello, world");
        
        try {
        	Class.forName("com.mysql.jdbc.Drivere");
        	
        }catch(Exception e) {
        	
        }
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_test?useSLL=flase","root","root");
        		Statement stmt = conn.createStatement();){
        	
        	String query = "select ID, NAME, SAL from emp_table;";
        	ResultSet rs = stmt.executeQuery(query);
        	
        	while(rs.next()) {
        		long id = rs.getLong("ID");
        		String name = rs.getString("NAME");
        		double salary = rs.getDouble("SAL");
        		
        		System.out.println("ID: " + id + " Name: " + name + " Salary: " + salary);
        		
        	}
        	
        			
        }catch(SQLException e) {
        	
        }
        	  
   	}
       
}


