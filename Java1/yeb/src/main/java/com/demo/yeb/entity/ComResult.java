package com.demo.yeb.entity;

import lombok.Data;

/**
 * @author ZGB
 * @version 1.0
 * @description: 公共返回对象
 * @date 2022/10/21 11:08
 */
@Data
public class ComResult {
	private int code;
	private String msg;
	private Object data;

	private ComResult(int code, String msg, Object data){
		this.code = code;
		this.msg = msg;
		this.data = data;
	}


	public static ComResult success(String msg, Object data){
		return new ComResult(200, msg, data);
	}

	public static ComResult success(String msg){
		return new ComResult(200, msg, null);
	}

	public static ComResult success(Object data){
		return new ComResult(200, "OK", data);
	}

	public static ComResult error(int code, String msg){
		return new ComResult(code, msg, null);
	}

	public static ComResult error(String msg) {
		return new ComResult(416, msg, null);
	}
}
