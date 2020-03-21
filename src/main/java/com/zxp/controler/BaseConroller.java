package com.zxp.controler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class BaseConroller {

	@RequestMapping("/{page}")
	public String showInfo(@PathVariable String page){
		return page;
	}
	
	/**
	 * 作用域的测试
	 * 
	 * */
	@RequestMapping("/show5")
	public String showInfo5(HttpServletRequest request,Model model){
		request.setAttribute("req", "HttpServletRequest");
		request.getSession().setAttribute("sess", "HttpSession");
		request.getSession().getServletContext().setAttribute("app", "Application");
		return "index5";
	}
}
