package com.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.Seckill;

@Controller
@RequestMapping("/test")
public class test {

	@RequestMapping(value="/listtest",method = RequestMethod.GET)
	public String list(Model model) {
		// list.jsp+model=ModelAndView
		// 获取列表页
		System.out.println("开始");
		return "list";// /WEB-INF/jsp/"list.jsp"
	}
}
