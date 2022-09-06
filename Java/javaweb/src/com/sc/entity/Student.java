package com.sc.entity;

import java.text.SimpleDateFormat;
import java.util.Date;


/*
 * 学生实体
*/
public class Student {

	private int sid;
	private String name;
	private int age;
	private String birth;
	private int English;
	private int Math;
	private int Chinese;
	private boolean isChange=false;
	

	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		setChange(true);
		this.sid = sid;
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
		return English;
	}
	public void setEnglish(int english) {
		setChange(true);
		English = english;
	}
	public int getMath() {
		return Math;
	}
	public void setMath(int math) {
		setChange(true);
		Math = math;
	}
	public int getChinese() {
		return Chinese;
	}
	public void setChinese(int chinese) {
		setChange(true);
		Chinese = chinese;
	}
	public Student(int sid, String name, String birth, int english, int math, int chinese) {
		super();
		this.sid = sid;
		this.name = name;
		this.age = getAge(birth);
		this.birth = birth;
		English = english;
		Math = math;
		Chinese = chinese;
		isChange = true;
	}
	public Student() {
		super();
	}
	
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", age=" + age + ", birth=" + birth + ", English=" + English
				+ ", Math=" + Math + ", Chinese=" + Chinese + "]";
	}
	
	private int getAge(String birth) {
		String pattern = "\\d{4}-.*";
		boolean isvalid = birth.matches(pattern);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");//格式化
		String str = sdf.format(new Date());	//当前年份
		if (isvalid) {
			int bir = Integer.parseInt(birth.substring(0,4));
			int nowAge = Integer.parseInt(str);
			int age = nowAge-bir;
			if (age>25 || bir<18) {
				return -1;
			}
			return age;
		}else {
			return -1;
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + sid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (sid != other.sid)
			return false;
		return true;
	}
	public boolean isChange() {
		return isChange;
	}
	public void setChange(boolean isChange) {
		this.isChange = isChange;
	}
	
	
}
