package com.snion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloControll {
	
	@RequestMapping("hello") //��ע�����ڰ��û��������ַ������hello.action
	public ModelAndView hello() {
		System.out.println("hello, SpringMVC");
		ModelAndView mv = new ModelAndView();
		//����ģ�����ݣ����ڴ��ݵ�jspҳ������ʾ
		mv.addObject("msg", "hello, SpringMVC");
		//������ͼ���֣�������Ӧ�û�
		mv.setViewName("hello");	//ֱ�ӽ�WebContent֮���Ŀ¼
		return mv;
	}
}