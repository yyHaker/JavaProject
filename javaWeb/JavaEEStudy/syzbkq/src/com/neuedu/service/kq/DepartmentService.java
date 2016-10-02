package com.neuedu.service.kq;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.neuedu.entity.baseinfo.Department;
import com.neuedu.mapper.DepartmentMapper;

@Component
public class DepartmentService {
	
	@Resource
	private DepartmentMapper departmentmapper;
	
	public List<Department> getDeapartmentList(Department department){
		return departmentmapper.listPageDepartment(department);
	}
	

}
