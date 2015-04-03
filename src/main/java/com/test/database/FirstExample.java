package com.test.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstExample {
	
	// Database credentials
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://qadbinstance.cvvhlvb3ryja.us-west-2.rds.amazonaws.com:3306/University";
	
	//Database credentials
	static final String USER = "dbadmin";
	static final String PASS = "cainXX0109";
			
	
	
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		try{
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			stmt = conn.createStatement();
			stmt.execute("Select * from COURSE");
			ResultSet rs = stmt.getResultSet();
			
			while(rs.next()){
				System.out.println(rs.getString("Course_name"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			conn.close();
			stmt.close();
		}
		
	}

}
