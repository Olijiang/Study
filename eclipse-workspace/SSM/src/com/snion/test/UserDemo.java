package com.snion.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.snion.entity.Student;
import com.snion.entity.User;
import com.snion.mapper.StudentMapper;
import com.snion.mapper.UserMapper;


public class UserDemo {
	
	private ApplicationContext applicationContext;
	
	@Before
	public void init() {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	//@Test
	public void demoGetUser() {
		UserMapper mapper = applicationContext.getBean(UserMapper.class);
		String identifier = "1001";
		User user = mapper.getUser(identifier);
		System.out.println(user);
		user.setCredential("666666");
		int result = mapper.update(user);
		System.out.println(result);
	}
	
	
	@Test
	public void demoGetStudent() {
		StudentMapper mapper = applicationContext.getBean(StudentMapper.class);
		String id = "20200001";
		Student student = mapper.getStudentById(id);
		System.out.println(student);
	}
}