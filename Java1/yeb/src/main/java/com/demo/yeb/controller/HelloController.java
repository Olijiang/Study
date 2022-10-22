package com.demo.yeb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZGB
 * @version 1.0
 * @description: test
 * @date 2022/10/20 19:29
 */
@RestController
public class HelloController {

	@GetMapping("/hello")
	private String  hello(){
		System.out.println("hello");
		return "hello";
	}

}
