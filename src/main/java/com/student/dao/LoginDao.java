package com.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.student.beans.Student;

public class LoginDao {
	
	//Database credentials
		static final String DRIVER= "com.mysql.jdbc.Driver";
		static final String URL = "jdbc:mysql://qadbinstance.cvvhlvb3ryja.us-west-2.rds.amazonaws.com:3306/University";
		
		//Database credentials
		static final String USERNAME = "dbadmin";
		static final String PASSWORD = "cainXX0109";
	
	public Student doLogin(Student student) throws Exception{
		
		Connection dbConnection = null;
		Statement dbStatement = null;
		Student dbStudent = new Student();
		
	try{
		
		Class.forName("com.mysql.jdbc.Driver");
		dbConnection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
		
		dbStatement = dbConnection.createStatement();
		dbStatement.execute("Select * from USER_CHUL where username='"+student.getUsername()+"' and password= '"+ student.getPassword()+"'");
		ResultSet rs = dbStatement.getResultSet();
		if (!rs.next()){
			throw new SQLException("Student Not Found");
		}
		else{
			dbStudent.setUsername(rs.getString("username"));
			dbStudent.setEmail(rs.getString("Email"));
		}
	}finally{
		dbConnection.close();
		dbStatement.close();
	}
	return dbStudent;
	}
	
	public static void main (String args[]) throws Exception{
		Student s = new Student();
		s.setUsername("surya");
		s.setPassword("surya");
		
		LoginDao loginDao = new LoginDao();
		loginDao.doLogin(s);
		
		System.out.println(s.getEmail());
	}
	
}
