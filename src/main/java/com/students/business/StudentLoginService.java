package com.students.business;

import com.student.beans.Student;
import com.student.business.exception.StudentNotFoundException;
import com.student.dao.LoginDao;

public class StudentLoginService {
	public Student doLogin(String username, String password){
		Student student = new Student();
		student.setUsername(username);
		student.setPassword(password);
		
		try{
		LoginDao loginDao = new LoginDao();
		student = loginDao.doLogin(student);
		}catch(Exception e){
			throw new StudentNotFoundException("No Student found with username : " + username);
		}
			
		return student;
	}

	public static void main(String args[]){
		
		String username = "surya";
		String password = "surya";
		
		StudentLoginService sls = new StudentLoginService();
		sls.doLogin(username, password);
	}
	
}
