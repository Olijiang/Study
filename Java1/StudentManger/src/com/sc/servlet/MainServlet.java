package com.sc.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//������������ַ���������.do��β������

public class MainServlet extends HttpServlet{
	

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletPath();
		
		// ��¼ login.do
		// ע��	register.do
		// �˳���¼ logout.do
		// ѧ���б�չʾ	queryAll.do
		// �޸�ѧ����Ϣ	changeStudent.do
		// ���ѧ��	addStudent.do
		// ɾ��ѧ��	deleteStudent.do
		// ��Ӱ༶	addsClass.do
		// ɾ���༶	deletesClass.do
		// ����꼶	addgrade.do
		// ɾ���꼶	deleteGrade.do
		
		
		
		
	}
}
