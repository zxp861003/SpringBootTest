package com.zxp.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxp.mapper.DepartmentMapper;
import com.zxp.po.Department;

@Service
public class DepartmentService {

	private static final Logger logger = Logger.getLogger(DepartmentService.class);
	
	@Autowired
	private DepartmentMapper depMapper;
	
	public List<Department> selectDepartmentList() {
		logger.info("enter UserService selectUserList");
		return depMapper.selectDepartmentList();
	}

	public int addDepartment(Department user) {
		int result = depMapper.insertDepartment(user);
		return result;
	}
	

}
