package com.snion.entity;

import java.util.Set;

public class DemoClass2 {
	
	private String class_name;
	private Set<String> stu_member;
	
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public Set<String> getStu_member() {
		return stu_member;
	}
	public void setStu_member(Set<String> stu_member) {
		this.stu_member = stu_member;
	}
	public DemoClass2(String class_name, Set<String> stu_member) {
		super();
		this.class_name = class_name;
		this.stu_member = stu_member;
	}
	public DemoClass2() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DemoClass2 [class_name=" + class_name + ", stu_member=" + stu_member + "]";
	}
	
	
	
	


}
