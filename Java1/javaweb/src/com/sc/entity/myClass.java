package com.sc.entity;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.sc.test.JDBCdemo;

public class myClass {
	private int count;
	private String name;
	private ArrayList<Student> myclass;
	private String schoolName="school";	//数据库
	private String className="myclass";	//表
	JDBCdemo Datebase = new JDBCdemo(schoolName);//建立数据库链接
	String sql;
	
	public myClass() {
		myclass = new ArrayList<Student>();
		count=0;
	}

	public myClass(String name) {
		myclass =new ArrayList<Student>();
		count=0;
		this.name = name;
	}
	
	
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setname(String name) {
		this.name = name;
	}
	
	public ArrayList<Student> getAll() {
		return myclass;
	}
	
	public void init() {
		int[] Sids = {2012, 3013, 4014, 5015, 6016};
		String[] names = {"神曦", "千影", "倾月", "雪瓷", "嫁嫁"};
		String[] births = {"2000-01-01","2000-05-25","2001-07-29","2004-02-29","2000-07-07"};
		int[] Englishs = {91, 93, 89, 95, 92};
		int[] Maths = {98, 94, 87, 94, 93};
		int[] Chineses = {85, 89, 83, 90, 87};
		
		for (int i = 0; i < 5; i++) {
			myclass.add(new Student(Sids[i],names[i],births[i],Englishs[i],Maths[i],Chineses[i]));
			count++;
		}
	}
	
	public void addStudent(Student student) {
		myclass.add(student);
		count++;
	}
	
	public void delStudent(int sid) {
		Student st = new Student();
		st.setSid(sid);
		myclass.remove(myclass.indexOf(st));
		count--;
	}
	
	public void delStudent(String name) {
		 
	}
	
	//根据id or name 获取 student 对象
	public Student getStudent(int sid) {
		for (Student student : myclass) {
			if (student.getSid()==sid) {
				return student;
			}
		}
		return null;
	}
	
	public Student getStudent(String name) {
		for (Student student : myclass) {
			if (student.getName()==name) {
				return student;
			}
		}
		return null;
	}
	
	public void show() {
		System.out.println("--class:"+name+"-- count:"+count+"-----------");
		for (Student st:myclass) {
			System.out.println(st);
		}
		System.out.println("----------------------------------------------");
	}
	
	public void loadClass(String classname) {//从数据库中加载班级
		 sql = "select * from "+classname;
		 ResultSet rs = Datebase.Query(sql);
		 Student st;
		 try {
			 while(rs.next()) {
				 int sid = rs.getInt("sid");
				 String name = rs.getString("name");
				 String birth = rs.getString("birth"); 
				 int english = rs.getInt("English");
				 int math = rs.getInt("Math");
				 int chinese = rs.getInt("Chinese");
				 st = new Student(sid, name, birth, english, math, chinese);
				 st.setChange(false);
				 myclass.add(st);
				 count++;
				 
			 }
		} catch (Exception e) {
			System.out.println("添加出错");
		}	
	}
	
	
	public void updateClass() {	//更新班级信息，上传数据库
		for (Student st : myclass) {
			sql = "insert into "+className+" values("+st.getSid()+",'"+st.getName()+"','"+st.getAge() +"','"+st.getBirth()+"',"+st.getEnglish()+","+st.getMath()+","+st.getChinese()+")";
//			System.out.println(sql);
			if (!Datebase.Update(sql)) {//插入失败， 通常是数据已存在
				if(st.isChange()) {//信息修改过
					sql = "delete from "+className+" where sid="+st.getSid();
//					System.out.println(sql);
					Datebase.Update(sql);
					sql = "insert into "+className+" values("+st.getSid()+",'"+st.getName()+"','"+st.getAge() +"','"+st.getBirth()+"',"+st.getEnglish()+","+st.getMath()+","+st.getChinese()+")";
					Datebase.Update(sql);
					System.out.println(st.getName()+"更新成功");
					st.setChange(false);//复位
				}
			}
			else {
				System.out.println(st.getName()+"添加成功");
			}
		}
	}
}
