package com.snion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.snion.entity.Student;
import com.snion.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService stuService;
	
	//DefaultAnnotationHandlerMapping���������ӳ��������ר�����ڰ����ǵ�url���󣬸�url���󵽵����ĸ���������������
	@RequestMapping(value = "/getstudent", method = RequestMethod.POST) //��ע�����ڰ��û��������ַ������getstudent.action
	@ResponseBody
	public ModelAndView getStudent(Integer id ) {
		System.out.println("id:" + id);
		ModelAndView mav = new ModelAndView();
		Student student = stuService.getStudentById(id);
		mav.addObject("student", student);
//		mav.setViewName("/WEB-INF/jsp/itemList.jsp");
		mav.setViewName("stuquery");
		
		return mav;
	}
	
}