package com.snion.mapper;

import java.util.List;

import com.snion.entity.Student;

public interface StudentMapper {
	
	public Student getStudentById(int id);
	
	public Student getStudentByName(String name);
	
	public int insertStudent(Student student);
	
	public int deletetStudentById(int id);
	
	public int deletetStudentsById(List<Integer> list);
	
	public List<Student> getAllStudent();
}