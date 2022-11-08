package blog.controller;


import blog.config.ComResult;
import blog.entity.User;
import blog.mapper.UserMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ZGB
 * @since 2022-11-06
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserMapper userMapper;

	@RequestMapping("/get")
	public ComResult getAuthor(String username){
		if (username.equals("")) username="2020";
		User user = userMapper.selectById("2020");
		if (user!=null){
			user.setPassword("");
			return ComResult.success(user);
		}
		return ComResult.success("username不存在");
	}
}
