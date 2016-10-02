package com.neuedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.thinking.common.baseeditor.BaseController;
import cn.thinking.common.util.JsonUtil;
import cn.thinking.org.system.codelist.Codelist;

import com.neuedu.entity.baseinfo.Department;
import com.neuedu.service.kq.DepartmentService;
import com.neuedu.service.kq.LeaveService;


@Controller
@RequestMapping(value=DepartmentController.modulePath)
public class DepartmentController extends BaseController{
	
	public static final String modulePath="module/system/department";
	
	
	
	@Autowired
	@Qualifier("departmentService")
	private DepartmentService departmentService;
	
	@RequestMapping
	public ModelAndView list()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName(DepartmentController.modulePath+"/department.jsp");
		return mv;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/searchDepartmentList",method=RequestMethod.POST)
	public String searchDepartmentList() throws Exception
	{
		String res=super.readRequestInputStream();
		Department department = JsonUtil.jsonToObject(res, Department.class);
		List<Department> DepartmentList = departmentService.getDeapartmentList(department);
		Object object = DepartmentList;
		if(object!=null)
		{
			return successPageJson(object, department);
		}
		else
		{
			return errorJson("");
		}	
	}
	

}
