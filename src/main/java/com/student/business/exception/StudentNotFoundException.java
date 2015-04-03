package com.student.business.exception;

public class StudentNotFoundException extends RuntimeException{
	public StudentNotFoundException(String message){
			//calling super class constructor
			super(message);
		}
	
}
