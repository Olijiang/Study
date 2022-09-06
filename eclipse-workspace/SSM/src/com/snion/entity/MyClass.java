package com.snion.entity;

import java.util.List;

public class MyClass {
	private Integer tch_id;
	private String tch_name;
	
	private List<Student> classmate;
	
	public Integer getTch_id() {
		return tch_id;
	}
	public void setTch_id(Integer tch_id) {
		this.tch_id = tch_id;
	}
	public String getTch_name() {
		return tch_name;
	}
	public void setTch_name(String tch_name) {
		this.tch_name = tch_name;
	}
	public List<Student> getClassmate() {
		return classmate;
	}
	public void setClassmate(List<Student> classmate) {
		this.classmate = classmate;
	}
	public MyClass(Integer tch_id, String tch_name, List<Student> classmate) {
		super();
		this.tch_id = tch_id;
		this.tch_name = tch_name;
		this.classmate = classmate;
	}
	public MyClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MyClass [tch_id=" + tch_id + ", tch_name=" + tch_name + ", classmate=" + classmate + "]";
	}
	

}