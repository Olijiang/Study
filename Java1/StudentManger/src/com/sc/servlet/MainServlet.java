package com.sc.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//负责所有请求分发，拦截以.do结尾的请求

public class MainServlet extends HttpServlet{
	

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletPath();
		
		// 登录 login.do
		// 注册	register.do
		// 退出登录 logout.do
		// 学生列表展示	queryAll.do
		// 修改学生信息	changeStudent.do
		// 添加学生	addStudent.do
		// 删除学生	deleteStudent.do
		// 添加班级	addsClass.do
		// 删除班级	deletesClass.do
		// 添加年级	addgrade.do
		// 删除年级	deleteGrade.do
		
		
		
		
	}
}
