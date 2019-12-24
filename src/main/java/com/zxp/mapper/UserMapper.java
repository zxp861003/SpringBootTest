package com.zxp.mapper;

import java.util.List;

import com.zxp.po.User;

public interface UserMapper {
	
	int insertUser(User user);
	
	List<User> selectUserList();
	
	User selectUsersById(long id);
	
	void updateUser(User users);
	
	void deleteUserById(long id);
}
