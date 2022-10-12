package com.sc.entity;

public class student {
	private int id;
	private String name;
	private int age;
	private String birth;
	private int english;
	private int math;
	private int chinese;
	private int sclass;
 	private int grade;
 	private boolean change=false;	//ÐÞ¸Ä±ê¼Ç
 	
 	

	public boolean isChange() {
		return change;
	}
	public void setChange(boolean change) {
		this.change = change;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		setChange(true);
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		setChange(true);
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		setChange(true);
		this.age = age;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		setChange(true);
		this.birth = birth;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		setChange(true);
		this.english = english;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		setChange(true);
		this.math = math;
	}
	public int getChinese() {
		return chinese;
	}
	public void setChinese(int chinese) {
		setChange(true);
		this.chinese = chinese;
	}
	public int getSclass() {
		return sclass;
	}
	public void setSclass(int sclass) {
		setChange(true);
		this.sclass = sclass;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		setChange(true);
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "student [id=" + id + ", name=" + name + ", age=" + age + ", birth=" + birth + ", english=" + english
				+ ", math=" + math + ", chinese=" + chinese + ", sclass=" + sclass + ", grade=" + grade + "]";
	}
	public student(int id, String name, int age, String birth, int english, int math, int chinese, int sclass,
			int grade) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.birth = birth;
		this.english = english;
		this.math = math;
		this.chinese = chinese;
		this.sclass = sclass;
		this.grade = grade;
	}
	public student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
 	
 	
 	
}
