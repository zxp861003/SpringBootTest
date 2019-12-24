package com.zxp.mapper;

import java.util.List;

import com.zxp.po.Department;

public interface DepartmentMapper {
	
	int insertDepartment(Department dep);
	
	List<Department> selectDepartmentList();
}
