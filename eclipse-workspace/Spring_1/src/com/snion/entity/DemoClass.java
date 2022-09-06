package com.snion.entity;

import java.util.List;

public class DemoClass {
	
	private String class_name;
	private List<String> stu_member;
	
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public List<String> getStu_member() {
		return stu_member;
	}
	public void setStu_member(List<String> stu_member) {
		this.stu_member = stu_member;
	}
	public DemoClass() {
		super();
	}
	public DemoClass(String class_name, List<String> stu_member) {
		super();
		this.class_name = class_name;
		this.stu_member = stu_member;
	}
	@Override
	public String toString() {
		return "DemoClass [class_name=" + class_name + ", stu_member=" + stu_member + "]";
	}
	


}