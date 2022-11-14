package blog.service;

import blog.config.ComResult;
import blog.entity.User;
import blog.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZGB
 * @since 2022-11-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>{

	@Resource
	private UserMapper userMapper;

	public ComResult getUser(String authorId){
		User user = userMapper.selectById(authorId);
		if (user!=null){
			user.setPassword("");
			return ComResult.success("获取用户信息成功",user);
		}else {
			return ComResult.error("用户不存在");
		}
	}

}
