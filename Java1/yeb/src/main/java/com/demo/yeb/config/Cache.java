package com.demo.yeb.config;

import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author ZGB
 * @version 1.0
 * @description: 缓存, 用来存数据库中查询到的数据
 * @date 2022/10/21 14:21
 */
@Component
public class Cache {

	private static final HashMap<String, Object> map = new HashMap<>();

	public static void put(String key, Object data){
		map.put(key,data);
	}

	public static void remove(String key, Object data){
		map.remove(key);
	}

	public static Object get(String key){
		return map.get(key);
	}

}
