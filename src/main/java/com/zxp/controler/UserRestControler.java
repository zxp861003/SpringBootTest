package com.zxp.controler;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zxp.controler.output.BaseResponse;
import com.zxp.po.User;
import com.zxp.service.UserService;

@RestController    //@RestController = @ResponseBody + @Controller 
@RequestMapping("/user")
public class UserRestControler extends BaseRestControler{

	private static final Logger logger = Logger.getLogger(UserRestControler.class);
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getall")
	public BaseResponse getUserList(){
		logger.info("controls  start getUserList ");
		List<User> list = userService.selectUsersAll();
		
		return getSuccessResponse(list);
	}
	
	/**
	 * @RequestBody 接的是json类型数据并可以恢复到对象
	 * @ModelAttribute 接的是Form表单的数据，可以恢复到对象
	 * @Validated 类型校验
	 * @PathVariable  从URL路径中获取数据
	 * @RequestHeader  从请求Header 中获取数据
	 **/
	@PostMapping("/adduser")
	public BaseResponse addUser(@RequestBody @Validated User user){
		int result = userService.addUser(user);
		return getSuccessResponse(result);
	}
	
	@PutMapping("/updateuser" )
	public User updateUser(){
		
		return userService.updateUser();
	}
	
	/**
     * 处理 "/users/{id}" 的 GET 请求，用来删除 User 信息
     */
//    @DeleteMapping("/delete/{id}")
//    public String deleteUser(@PathVariable Long id) {
//
//        userService.delete(id);
//        return "redirect:/users/";
//    }
}
