package com.demo.yeb.controller;

import com.demo.yeb.entity.ComResult;
import com.demo.yeb.service.impl.LoginServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author ZGB
 * @version 1.0
 * @description: TODO
 * @date 2022/10/21 11:27
 */

@Api(tags = "LoginController")
@RestController
public class LoginController {

	@Autowired
	private LoginServiceImpl loginService;

	@ApiOperation(value = "登录")
	@PostMapping("/login")
	public ComResult login(@RequestBody Map<String,String> data){
		String username = data.get("username");
		String password = data.get("password");
		return loginService.login(username, password);
	}

}
