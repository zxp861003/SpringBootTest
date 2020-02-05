package com.zxp.controler;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zxp.po.User;
import com.zxp.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/list")
	public String userList(Model model){
		List<User> list = userService.selectUsersAll();
		model.addAttribute("list", list);
		return "user_list";
	}
	
	@RequestMapping("/add")
	public String addUser(@Valid User user,Model model){
		System.out.println(1);
		userService.addUser(user);
		List<User> list = userService.selectUsersAll();
		model.addAttribute("list", list);
		return "user_list";
	}
	
	@RequestMapping("/index")
	public String index(){
		System.out.println(1);
		return "user_add";
	}
}
