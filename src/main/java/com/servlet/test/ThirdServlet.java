package com.servlet.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThirdServlet extends HttpServlet{
	
		// Database credentials
		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://qadbinstance.cvvhlvb3ryja.us-west-2.rds.amazonaws.com:3306/University";
		
		//Database credentials
		static final String USER = "dbadmin";
		static final String PASS = "cainXX0109";
		
		public void init(){
			System.out.println("initialized");
		}
		
		public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException{
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
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
			out.write("<html>");
			out.write("<body>");
			while(rs.next()){
				out.write(rs.getString("Course_name"));
				out.write("<br>");
			}
			out.write("</body>");
			out.write("</html>");
			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				//conn.close();
				//stmt.close();
			}
		}
}

