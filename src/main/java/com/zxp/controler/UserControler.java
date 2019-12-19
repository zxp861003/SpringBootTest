package com.zxp.controler;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zxp.po.User;
import com.zxp.service.UserService;

@RestController    //@RestController = @ResponseBody + @Controller 
@RequestMapping("/user")
public class UserControler {

	private static final Logger logger = Logger.getLogger(UserControler.class);
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getall")
	public List<User> getUserList(){
		logger.debug("controls  enter getUserList ");
		logger.info("controls  start getUserList ");
		return userService.selectUsersAll();
	}
	@PostMapping("/adduser")
	public List<User> addUser(){
		
		return userService.selectUsersAll();
	}
}
