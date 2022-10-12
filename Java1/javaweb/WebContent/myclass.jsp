<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.sc.entity.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/Style.css">

<title>Class Manage System 1.0</title>
</head>
<body>
<div class="Result">
	<h1>Class Manage System 1.0</h1>
	<%
		myClass newclass = new myClass("super1");
		newclass.loadClass("myclass");
		ArrayList<Student> list = newclass.getAll();
	%>
	
	<table>
		<tr class="classinfo">
			<td colspan="4">
				Classname : <%=newclass.getName() %>
			</td>
			<td colspan="3">
				Population : <%=newclass.getCount() %>
			</td>
		</tr>

		<tr class="tablehead">
			<td>ID</td>
			<td>Name</td>
			<td>Age</td>
			<td>Birth</td>
			<td>English</td>
			<td>Math</td>
			<td>Chinese</td>
		</tr>
	
	<%
		for(Student st:list){
	%>
		<tr>
			<td><%=st.getSid() %></td>
			<td><%=st.getName() %></td>
			<td><%=st.getAge() %></td>
			<td><%=st.getBirth() %></td>
			<td><%=st.getEnglish() %></td>
			<td><%=st.getMath() %></td>
			<td><%=st.getChinese() %></td>
		</tr>
	
	<% } %>
	</table>
</div>	

<div>
	<!-- 转发，在同一个页面中 -->
	<% 
		/* page的值最小，只能在本页面有效 
		
		*/
		request.setAttribute("user", "Asia");
		request.setAttribute("pwd", "123");
		session.setAttribute("user", "session");
		pageContext.setAttribute("user", "pagecontext");
		application.setAttribute("user", "application");
	%>
	<!-- 转发可以携带参数 -->
<%-- 	<jsp:forward page="forward.jsp">
		<jsp:param value="qianye" name="name"/>
		<jsp:param value="21" name="age"/>
	</jsp:forward> --%>
	

</div>

</body>
</html>