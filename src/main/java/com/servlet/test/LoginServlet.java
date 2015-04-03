package com.servlet.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.beans.Student;
import com.student.business.exception.StudentNotFoundException;
import com.students.business.StudentLoginService;

public class LoginServlet extends HttpServlet {

	public void init(){
		System.out.println("initialized");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String user = request.getParameter("username");
		String pass = request.getParameter("userpass");
		
		out.write(user);
		out.write(pass);
		
		Student x;
		
		StudentLoginService sls = new StudentLoginService();
		try{
			Student student = sls.doLogin(user, pass);
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
			rd.forward(request, response);
		}catch (StudentNotFoundException snf){
			out.println("Sorry no user exists with that name");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
		out.close();
	}
	
	public void destroy(){
		System.out.println("destroyed");
	}
	
}
