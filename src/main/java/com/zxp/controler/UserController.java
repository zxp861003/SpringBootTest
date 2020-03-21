package com.zxp.controler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zxp.po.User;
import com.zxp.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseConroller{
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request,Model model){
		System.out.println(request.getSession().getAttribute("sess"));
		return "user_add";
	}
	
	@RequestMapping("/list")
	public String userList(HttpServletRequest request,Model model){
		request.getSession().setAttribute("sess", "HttpSession");
		List<User> list = userService.selectUsersAll();
		model.addAttribute("list", list);
		return "user_list";
	}
	
	@RequestMapping("/add")
	public String addUser(@Valid User user,Model model){
		userService.addUser(user);
		List<User> list = userService.selectUsersAll();
		model.addAttribute("list", list);
		return "user_list";
	}
	
	@RequestMapping("/delete")
	public String delete(Long id,Model model){
//		userService.delete(id);
		List<User> list = userService.selectUsersAll();
		model.addAttribute("list", list);
		return "user_list";
	}
	
	
}
