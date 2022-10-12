package com.tl.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Loginservlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		System.out.println("处理登录请求");
		//第一种参数获取方法
		/*String name = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String status_code = request.getParameter("status_code");
		String sign = request.getParameter("sign");
		System.out.println("username: "+name+"  password: "+pwd);
		System.out.println("status_code: "+status_code+"  sign: "+sign);
		*/
		
		//第二种参数获取方法,适合添加数据多的时候
		/*Map<String, String[]> map = request.getParameterMap();
		String[] strings =  map.get("username");
		for (String string : strings) {
			System.out.println(string);
		}
		String[] strings2 =  map.get("pwd");
		for (String string : strings) {
			System.out.println(string);
		}*/
		
		String path = request.getServletPath();
		System.out.println(path);
		
		/*if (name.equals("admin") && pwd.equals("12345")) {
			response.sendRedirect("http://127.0.0.1:8080/javaweb/myclass.jsp");
		}else {
			response.sendRedirect("error.jsp");
		}*/
	}
}
