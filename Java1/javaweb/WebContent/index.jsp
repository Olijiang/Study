<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1> hello, jsp</h1>
	<%-- 客户端不可见注释 --%>
	<!-- 客户端可见注释 -->
	<!-- 声明区，声明变量方法 -->
	<%!
		private int num=10;
		public void show(){
			System.out.println(num);
			/* 输出到后端，前端不会显示 */
		}
	%>
	<!-- 代码区 -->
	<%
		show();
	System.out.println("小脚本");	
	%>
	
	<!-- 表达式区，向页面输出类容 -->
	<%="<br><h1> yeah, java, nice to see you </h1>" %>
	
	
</body>
</html>