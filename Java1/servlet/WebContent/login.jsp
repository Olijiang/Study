<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/login.css">
<title>Login</title>
</head>
<body>
	 <div id="LogBox">  
        <h1>Login</h1>
        
        <form action="login" method="post" >
            <input name="username" class="InputBox" type="text" placeholder=" 用户名" autocomplete="off" ></input>  
            <input name="pwd" class="InputBox" type="password" placeholder=" 密码" autocomplete="off" ></input>  
            <select name="status_code" id="status">
                <option value ="1">管理员</option>
                <option value ="2">用户</option>
            </select>
            <!-- form 只能通过submit 提交 -->
            <input  class="bt" type="submit" name="sign" value="登录"></input>
            <input  class="bt" type="submit" name="sign" value="注册"></input>
        </form>
    </div>
	

</body>
</html>