package blog.controller;

import blog.config.ComResult;
import blog.entity.UserInfo;
import blog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


/**
 * @author ZGB
 * @version 1.0
 * @description: TODO
 * @date 2022/11/6 14:30
 */
@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping("/login")
	public ComResult login(@RequestBody UserInfo userInfo, HttpSession session){
		String code = (String) session.getAttribute("verifyCode");
		System.out.println(code);
		System.out.println(userInfo.getCode());
		if (userInfo.getCode().equals(code)){
			return loginService.login(userInfo);
		}else{
			return ComResult.error("验证码错误");
		}

	}
}
