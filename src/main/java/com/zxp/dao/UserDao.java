package com.zxp.dao;

import java.util.List;

import com.zxp.mapper.UserMapper;
import com.zxp.po.User;

@Deprecated
public class UserDao {

	private UserMapper userMapper;
	
	public List<User> selectUserList(){
		return userMapper.selectUserList();
	}
}
