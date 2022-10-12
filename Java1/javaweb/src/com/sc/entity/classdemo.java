package com.sc.entity;

import java.util.ArrayList;
import java.util.List;

public class classdemo {
	public static void main(String[] args) {
		myClass myclass = new myClass("super1");
		Student st;
//		myclass.init();
//		myclass.show();
//		Student st = new Student(2828, "ÔÂæ¿","2000-07-07",98,90,89);
		
//		myclass.addStudent(st);
//		myclass.show();
		
		myclass.loadClass("myclass");

		List<Student> list = myclass.getAll();
		for (Student student : list) {
			System.out.println(student);
		}

//		st = new Student(5656, "Ë®ÐÀ","2001-12-01",90,89,98);
//		myclass.addStudent(st);
//		myclass.show();
		st = myclass.getStudent(2012);
//		System.out.println(st);
//		st.setBirth("2001-01-01");
//		myclass.updateClass();
//		myclass.show();
		myclass.Datebase.close();
	
	}
	
}
