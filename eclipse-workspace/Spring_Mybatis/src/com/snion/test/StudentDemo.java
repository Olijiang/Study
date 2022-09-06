package com.snion.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.snion.entity.Student;
import com.snion.mapper.StudentMapper;

public class StudentDemo {
	
	private ApplicationContext applicationContext;
	
	@Before
	public void init() {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void testGetUserById() {
		StudentMapper mapper = applicationContext.getBean(StudentMapper.class);
		Student student = mapper.getStudentById(1001);
		System.out.println(student);
		List<Student> stlist = mapper.getAllStudent();
		for (Student student2 : stlist) {
			System.out.println(student2);
		}
	}
}