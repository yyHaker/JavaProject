package com.neuedu.overtime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.thinking.common.baseeditor.BaseController;
import cn.thinking.common.util.Const;
import cn.thinking.common.util.JsonUtil;
import cn.thinking.org.system.user.User;

import com.neuedu.overtime.entity.Overtime;
import com.neuedu.overtime.service.OvertimeService;


@Controller
@RequestMapping(value=OvertimeController.modulePath)
public class OvertimeController extends BaseController{
	public static final String modulePath="module/system/overtime";
	
	@Autowired
	@Qualifier("overtimeService")
	private OvertimeService overtimeService;	
	
	    //加班申请主页面的数据显示
		@ResponseBody
		@RequestMapping(value="/searchOvertimeList")
		public String searchOvertimeList() throws Exception
		{
			String res = super.readRequestInputStream();
			List<Overtime> searchList = JsonUtil.jsonToList(res, Overtime.class);
			Overtime overtime = searchList.get(0);
			List<Overtime> overtimeList = overtimeService.listPageOvertime(overtime);
			
			if(overtimeList!=null)
			{
				return successPageJson(overtimeList, overtime);
			}
			else
			{
				return errorJson("");
			}
		}
		
		@RequestMapping
		public ModelAndView list()
		{
			ModelAndView mv = new ModelAndView();			
			mv.setViewName(OvertimeController.modulePath+"/overtime.jsp");
			return mv;
		}
		
		//跳转到申请加班页面				 
		@RequestMapping(value="/changePage")
		public ModelAndView changePage(Model model) 
		{
			ModelAndView mv = new ModelAndView();
			User user = (User) session.getAttribute(Const.SESSION_USER); 
			String loginname=user.getLoginname(); 
			String dept=user.getDeptname();
			if(loginname.equals("admin")){
				List<Overtime> deptList = overtimeService.searchDept();
				mv.addObject("deptList",deptList);
			}
			else{
				List<Overtime> deptList=overtimeService.searchDid(dept);
				mv.addObject("deptList",deptList);
			}
						
			mv.setViewName(OvertimeController.modulePath+"/overtime_add.jsp");
			return mv;
		}
		//通过名字模糊查询用户信息				 
		@ResponseBody
		@RequestMapping(value="/listPageName")
		public String listPageName() throws Exception
		{
			//调用所写基类的方法控制层通用类,业务模块的Controller可继承此类进行方法复用,如:对于ajax交互时处理回写json的处理等...

			String res = super.readRequestInputStream();
			List<Overtime> searchList = JsonUtil.jsonToList(res, Overtime.class);
			Overtime overtime = searchList.get(0);			
			List<Overtime> overtimeList = overtimeService.listPageName(overtime);
			
			if(overtimeList!=null)
			{
				return successPageJson(overtimeList, overtime);
			}
			else
			{
				return errorJson("");
			}
		}
		//申请加班
		@ResponseBody
		@RequestMapping(value="/insertOvertime",method=RequestMethod.POST)
		public String insertOvertime() throws Exception
		{
			String res = super.readRequestInputStream();
			Overtime overtime = JsonUtil.jsonToObject(res, Overtime.class);
			List<Overtime> overtimeList = overtime.getList();
			overtimeService.insertOvertime(overtimeList);
			if(overtime!=null)
			{
				return successJson(overtime);
			}
			else
			{
				return errorJson("");
			}	
		}
}
