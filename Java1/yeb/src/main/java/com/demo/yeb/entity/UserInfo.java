package com.demo.yeb.entity;

import lombok.Data;

/**
 * @author ZGB
 * @version 1.0
 * @description: 存放登录用户信息
 * @date 2022/10/21 10:54
 */

@Data
public class UserInfo {

	private int userId;
	private String username;
	private String password;
	private String userType;

}
