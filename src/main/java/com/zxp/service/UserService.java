package com.zxp.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxp.mapper.UserMapper;
import com.zxp.po.User;

@Service
public class UserService {

	private static final Logger logger = Logger.getLogger(UserService.class);
	
	@Autowired
	private UserMapper userMapper;
	
	public List<User> selectUsersAll() {
		logger.info("enter UserService selectUserList");
		return userMapper.selectUserList();
	}

	public int addUser(User user) {
		int result = userMapper.insertUser(user);
		return result;
	}
	
	public User updateUser() {
		return null;
	}

}
