package blog.service;

import blog.config.ComResult;
import blog.utils.JwtUtil;
import blog.entity.User;
import blog.entity.LoginInfo;
import blog.mapper.UserMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ZGB
 * @version 1.0
 * @description: TODO
 * @date 2022/11/6 14:37
 */
@Component
public class LoginService {

	@Resource
	private UserMapper userMapper;

	public ComResult login(LoginInfo loginInfo){
		String username = loginInfo.getUsername();
		String password = loginInfo.getPassword();
		User user = userMapper.selectById(username);
		if (user==null) return ComResult.error("用户不存在");
		if (user.getPassword().equals(password)){
			// 登录成功
			loginInfo.setPassword("***");
			String token =  JwtUtil.generateToken(loginInfo);
			user.setPassword(token);
			return ComResult.success("登录成功",user);
		}else{
			return ComResult.error("密码错误");
		}
	}
}
