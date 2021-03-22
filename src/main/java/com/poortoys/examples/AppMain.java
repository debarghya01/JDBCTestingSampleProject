package com.poortoys.examples;

import java.sql.*;

public class AppMain {

    public static void main(String[] args) {
        System.out.println("Hello, world");
        
        try {
        	Class.forName("com.mysql.jdbc.Drivere");
        	
        }catch(Exception e) {
        	
        }
//		Try with resource, so no need to explicitly close the connection  
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_test?useSLL=flase","root","root");
        		Statement stmt = conn.createStatement();){

//			Reading from table
        	String query = "select ID, NAME, SAL from emp_table;";
        	ResultSet rs = stmt.executeQuery(query);
        	
        	while(rs.next()) {
        		long id = rs.getLong("ID");
        		String name = rs.getString("NAME");
        		double salary = rs.getDouble("SAL");
        		
        		System.out.println("ID: " + id + " Name: " + name + " Salary: " + salary);
        		
        	}
        	
//			Inserting into table
        	long insertID = 4;
        	String insertName = "Test User4";
        	double insertSalary = 10000;
        	
        	String insertQuery = "Insert into emp_table values(" + insertID + ",'" + insertName + "'," + insertSalary + ")";
        	int insertCount = stmt.executeUpdate(insertQuery);
        	System.out.println("Number of rows inserted " + insertCount);
        	
//			Updating table row
        	long updateID = 4;
        	long updateSalary = 60000;
        	
        	String updateQuery = "update emp_table set sal = " + updateSalary + " where ID = " + updateID ;
        	int updateCount = stmt.executeUpdate(updateQuery);
        	System.out.println("Number of rows updated " + updateCount);
        	
        			
        }catch(SQLException e) {
        	System.out.println(e);
        }
        	  
   	}
       
}


