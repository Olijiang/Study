package com.snion.entity;

import org.springframework.beans.factory.annotation.Value;


public class Student {
	
	private User user;
	@Value("SWUST")
	private String school;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(User user, String school) {
		super();
		this.user = user;
		this.school = school;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	@Override
	public String toString() {
		return "Student [user=" + user + ", school=" + school + "]";
	}
	

}
