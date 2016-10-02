package com.neuedu.mapper;

import java.util.List;

import com.neuedu.entity.baseinfo.Department;

public interface DepartmentMapper {
	
	public List<Department> listPageDepartment(Department department);
	
}
