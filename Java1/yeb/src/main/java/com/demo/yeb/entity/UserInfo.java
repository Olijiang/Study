package com.demo.yeb.controller;

import lombok.Data;

/**
 * @author ZGB
 * @version 1.0
 * @description: 存放登录用户信息
 * @date 2022/10/21 10:54
 */

@Data
public class UserInfo {

	private String userId;
	private String username;
	private String userType;

}
