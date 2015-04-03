package com.servlet.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {

	int x=0;
	int i =0;
	public void init(){
		System.out.println("initialized");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
			
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.write("<html>");
		out.write("<body>");
		out.write("<h1> Request Attributes </h1> <br>");
		
		Enumeration<String> userInputValues = request.getParameterNames();
		
		while(userInputValues.hasMoreElements()){
			String userInput = userInputValues.nextElement();
			out.write("Input Name: " + userInput + " value: " + request.getParameter(userInput));
			out.write("</br>");
		}
		
		out.write("</body>");
		out.write("</html>");
	}
	
	public void destroy(){
		System.out.println("destroyed");
	}
	
}
