package com.snion.entity;

import java.util.Map;

public class DemoClass3 {
	private String class_name;
	private Map<Integer, String> stu_member;
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public Map<Integer, String> getStu_member() {
		return stu_member;
	}
	public void setStu_member(Map<Integer, String> stu_member) {
		this.stu_member = stu_member;
	}
	public DemoClass3() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DemoClass3(String class_name, Map<Integer, String> stu_member) {
		super();
		this.class_name = class_name;
		this.stu_member = stu_member;
	}
	@Override
	public String toString() {
		return "DemoClass3 [class_name=" + class_name + ", stu_member=" + stu_member + "]";
	}
	
	
}
