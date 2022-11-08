package blog.service;

import blog.config.ComResult;
import blog.entity.User;
import blog.entity.UserInfo;
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

	public ComResult login(UserInfo userInfo){
		String username = userInfo.getUsername();
		String password = userInfo.getPassword();
		User user = userMapper.selectById(username);
		if (user==null) return ComResult.error("用户不存在");
		if (user.getPassword().equals(password)){
			return ComResult.success("登录成功");
		}else{
			return ComResult.error("密码错误");
		}

	}
}
