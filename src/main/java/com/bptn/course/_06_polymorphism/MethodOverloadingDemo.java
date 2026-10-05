package com.bptn.course._06_polymorphism;

public class MethodOverloadingDemo {
	
	String username;
	String password;
	String email;
	long phone;
	short otp;
	
	// Constructor Overloading
	
	public MethodOverloadingDemo(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public MethodOverloadingDemo(long phone, short otp) {
		this.phone = phone;
		this.otp = otp;
	}
	
	
	// Method Overloading
	
	boolean login(String username, String password) {
		// logic
		return true;
	}
	
	boolean login(long phone, short otp) {
		// logic
		return true;
	}
	
	boolean login(String email, short otp) {
		// logic
		return true;
	}
	
	String login(String email) {
		// logic
		return "success";
	}
	
}
