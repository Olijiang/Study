package com.demo.yeb.service.impl;

import com.demo.yeb.config.Cache;
import com.demo.yeb.config.JwtUtil;
import com.demo.yeb.entity.Admin;
import com.demo.yeb.entity.ComResult;
import com.demo.yeb.entity.UserInfo;
import com.demo.yeb.mapper.AdminMapper;
import com.demo.yeb.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZGB
 * @version 1.0
 * @description: TODO
 * @date 2022/10/21 11:35
 */
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private JwtUtil jwtUtil;

	/** 
	 * @description: 登录服务
	 * @param:  userInfo
	 * @date: 2022/10/21 13:37
	 */ 
	@Override
	public ComResult login(String username, String password) {
		UserInfo userInfo = new UserInfo();
		Admin user = adminMapper.getByUsername(username);
		if (user==null) return ComResult.error("用户不存在");

		if (user.getPassword().equals(password)){
			// 将用户信息添加到本地缓存
			Cache.put(username, user);
			userInfo.setUsername(user.getUsername());
			userInfo.setUserId(user.getId());
			String token = jwtUtil.generateToken(userInfo);
			Map<String,Object> map = new HashMap<>();
			map.put("token",token);
			return ComResult.success("登录成功",map);
		}

		return ComResult.error("密码错误");
	}
}
