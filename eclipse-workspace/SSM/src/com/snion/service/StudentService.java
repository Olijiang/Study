package com.snion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snion.entity.Student;
import com.snion.mapper.StudentMapper;

//service������������mapper�ģ�mapper�������������ݿ�ģ�������service���У�
//��������Ҫ��ȡmapper�ӿڵĴ�������ֻ����������������ͨ��Springע������ģ�
//Ȼ��ͨ�������������ȥ�������ݿ⡣

@Service
public class StudentService {
	
	@Autowired
	private StudentMapper mapper;
	
	
	public Student getStudentById(int id){
		return mapper.getStudentById(id);
	}
}