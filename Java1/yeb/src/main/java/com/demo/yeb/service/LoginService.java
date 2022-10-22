package com.demo.yeb.service;

import com.demo.yeb.entity.ComResult;

/**
 * @author ZGB
 * @version 1.0
 * @description: TODO
 * @date 2022/10/21 11:31
 */

public interface LoginService {
	/**
	 * @description: 登录服务
	 * @date: 2022/10/21 11:34
	 */
	ComResult login(String username, String password);
}
