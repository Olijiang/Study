package blog.controller;

import blog.config.ComResult;
import blog.entity.LoginInfo;
import blog.service.LoginService;
import blog.utils.JwtUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

	@ApiOperation("登录操作")
	@PostMapping("/login")
	public ComResult login(@RequestBody LoginInfo loginInfo, HttpSession session){
		String code = (String) session.getAttribute("verifyCode");
		if (loginInfo.getCode().equals(code)){
			return loginService.login(loginInfo);
		}else{
			return ComResult.error("验证码错误");
		}
	}

	@ApiOperation("刷新token")
	@GetMapping("/refreshToken")
	public ComResult refreshToken(@RequestHeader("token") String token ){
		if (token!=null && JwtUtil.getUserFromToken(token)!=null){
			LoginInfo loginInfo = JwtUtil.getUserFromToken(token);
			token = JwtUtil.generateToken(loginInfo);
			return ComResult.success("刷新token成功",token);
		}
		return ComResult.error("非法访问!");
	}
}
