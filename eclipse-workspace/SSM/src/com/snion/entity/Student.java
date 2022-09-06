package com.snion.entity;

import java.util.Objects;

public class Student {
	private int id;
	private String sid;
	private String sname;
	private int age;
	private int grade;
	private String cname;
	private String email;
	private String telephone;

	public Student() {
	}

	public Student(int id, String sid, String sname, int age, int grade, String cname, String email, String telephone) {
		this.id = id;
		this.sid = sid;
		this.sname = sname;
		this.age = age;
		this.grade = grade;
		this.cname = cname;
		this.email = email;
		this.telephone = telephone;
	}

	public int getId() {
		return id;
	}

	public String getSid() {
		return sid;
	}

	public String getSname() {
		return sname;
	}

	public int getAge() {
		return age;
	}

	public int getGrade() {
		return grade;
	}

	public String getCname() {
		return cname;
	}

	public String getEmail() {
		return email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Student student = (Student) o;
		return Objects.equals(sid, student.sid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(sid);
	}

	@Override
	public String toString() {
		return "student{" +
				"id=" + id +
				", sid='" + sid + '\'' +
				", sname='" + sname + '\'' +
				", age=" + age +
				", grade=" + grade +
				", cname='" + cname + '\'' +
				", email='" + email + '\'' +
				", telephone='" + telephone + '\'' +
				'}';
	}
}
