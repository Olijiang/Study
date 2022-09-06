package com.snion.entity;

import java.util.List;

public interface StudentMapper {
	
	public Student getStudentById(int id);
	
	public Student getStudentByName(String name);
	
	public int insertStudent(Student student);
	
	public int deletetStudentById(int id);
	
	public int deletetStudentsById(List<Integer> list);
	
	public List<Student> getAllStudent();


}