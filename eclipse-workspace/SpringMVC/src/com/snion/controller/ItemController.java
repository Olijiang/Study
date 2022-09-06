package com.snion.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.snion.entity.Item;

@Controller
public class ItemController {
	
	@RequestMapping(value="itemlist", produces="text/html;charset=utf-8")
	public ModelAndView itemList() {
		ModelAndView mv = new ModelAndView();
		
		List<Item> list = Arrays.asList(new Item(1, "����", 1999, new Date(), "����������"), new Item(2, "����2", 1999, new Date(), "����������2"), 
				new Item(3, "����3", 1999, new Date(), "����������3"), new Item(4, "����4", 1999, new Date(), "�������"));
		mv.addObject("itemlist", list);
		mv.setViewName("ListItem");
		return mv;
	}
		
}