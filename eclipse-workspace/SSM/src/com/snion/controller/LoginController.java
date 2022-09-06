package com.snion.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.snion.entity.User;
import com.snion.mapper.UserMapper;

@Controller
public class LoginController {

	@Autowired
	private UserMapper mapper;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST) //��ע�����ڰ��û��������ַ������getstudent.action
	@ResponseBody
	public String login(String id, String pwd) {
		User user = mapper.getUser(id);
		if(user!=null && user.getCredential().equals(pwd)) {
			System.out.println(id + " Login Successful ");
			return "http://localhost:8080/SSM/jsp/stuquery.jsp";
		}else {
			System.out.println(id + " Login Failed ");
			return "F";
		}
	}
	
	
	@RequestMapping(value = "/getcode", method = RequestMethod.POST) //��ע�����ڰ��û��������ַ������getstudent.action
	@ResponseBody
	public String getcode(String id, String ep) {
		User user = mapper.getUser(id);
		if(user!=null) {
			System.out.println(id + " GetCode Successful ");
			String code = "6666";
			session =  request.getSession();
			session.setAttribute("code", code);
			session.setAttribute("user", user);
			return "OK";
		}else {
			System.out.println(id + " GetCode Failed ");
			return "FF";	//�˺Ų�����
		}
	}
	
	@RequestMapping(value = "/reset", method = RequestMethod.POST) //��ע�����ڰ��û��������ַ������getstudent.action
	@ResponseBody
	public String reset(String id, String ep, String code) {
		System.out.println(id+"  "+  ep + "  " + code);
		User user = mapper.getUser(id);
		if(user!=null && code.equals(session.getAttribute("code"))) {
			return "http://localhost:8080/SSM/jsp/resetpwd.html";
		}else {
			return "FF";
		}
	}
	
	@RequestMapping(value = "/resetpwd", method = RequestMethod.POST) //��ע�����ڰ��û��������ַ������getstudent.action
	@ResponseBody
	public String resetpwd(String pwd) {
		System.out.println("pwd:"+ pwd);
		User user = (User) session.getAttribute("user");
		if(user==null) return "FF";
		System.out.println("user");
		user.setCredential(pwd);
		mapper.update(user);
		return "http://localhost:8080/SSM/";
	}
}
