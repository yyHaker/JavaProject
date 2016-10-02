package com.neuedu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.neuedu.entity.baseinfo.Leave;
import com.neuedu.service.kq.LeaveService;

import cn.thinking.common.baseeditor.BaseController;
import cn.thinking.common.util.CommonUtils;
import cn.thinking.common.util.JsonUtil;
import cn.thinking.org.system.codelist.Codelist;
import cn.thinking.org.system.user.User;
import cn.thinking.system.codelist.service.CodelistService;

@Controller
@RequestMapping(value=LeaveController.modulePath)
public class LeaveController extends BaseController {
	
	public static final String modulePath="module/system/leaveApplication";
	
	@Autowired
	@Qualifier("leaveService")
	private LeaveService leaveService;
	
	@Autowired
	private CodelistService codelistService;
	
	@ResponseBody
	@RequestMapping(value="/searchLeaveList",method=RequestMethod.POST)
	public String searchLeaveList() throws Exception
	{
		String res=super.readRequestInputStream();
		List<Leave> searchList = JsonUtil.jsonToList(res, Leave.class);
		Leave leave = searchList.get(0);
		List<Leave> leaveList = leaveService.getLeaveList(leave);
		if(leaveList!=null)
		{
			return successPageJson(leaveList, leave);
		}
		else
		{
			return errorJson("");
		}	
	}
	
	//休假管理显示的列表信息
	@RequestMapping
	public ModelAndView list()
	{
		//假期类型下拉列表
		List<Codelist> vacationTypeList = codelistService.listvacationType();
		ModelAndView mv = new ModelAndView();
		mv.setViewName(LeaveController.modulePath+"/leaveApplication.jsp");
		//mv.addObject("vacationTypeList", vacationTypeList);
		return mv;
	}
	
	//点击申请模态框时显示的信息,即查询
	@ResponseBody
	@RequestMapping(value="/searchVacation",method=RequestMethod.POST)
	public List<Leave> getVaction()
	{
		List<Leave> leave=leaveService.getVacation();
		return leave;
	}
	
	//模态框中插入休假申请，即点击添加触发的事件
	@ResponseBody
	@RequestMapping(value="/insertLeave",method=RequestMethod.POST)
	public String insertLeave(HttpServletRequest request) throws Exception
	{
		String res = super.readRequestInputStream();
		Leave leave = JsonUtil.jsonToObject(res, Leave.class);
		
		CommonUtils com=new CommonUtils();
		User user=com.getCurrentUserInfo(request);
		leave.setUserid(user.getUserId());
		
		leaveService.insertLeave(leave);
		if(leave!=null)
		{
			return successJson(leave);
		}
		else
		{
			return errorJson("");
		}
	}
	//模态框里通过点击假期的名字能够显示出改假期的假期说明
	@ResponseBody
	@RequestMapping(value="/searchVacation_explain",method=RequestMethod.POST)
	public String getVacation_explain() throws Exception
	{
		String res = super.readRequestInputStream();
		//前台传过来的是一个字符串，在这块就不用toObject\toList转换了，直接作为参数就可以
		//把查询得到的休假说明返给前台展示
		String vacation_explain = leaveService.getVacation_explain(res);
		if(vacation_explain!=null)
		{
			return successJson(vacation_explain);
		}
		else
		{
			return errorJson("");
		}
	}
	
	//查看休假信息
	@ResponseBody
	@RequestMapping(value="/searchLeaveInfo",method=RequestMethod.POST)
	public String getLeaveInfo() throws Exception
	{
		String res = super.readRequestInputStream();
		//Leave  leave = JsonUtil.jsonToObject(res, Leave.class);
		List<Leave> leaveList = JsonUtil.jsonToList(res, Leave.class);
		String id =leaveList.get(0).getID();
		//String id =  leave.getID();
		Leave leave1 = leaveService.getInfo(id);
		if(leave1!=null)
		{
			return successJson(leave1);
		}
		else
		{
			return errorJson("");
		}
	}
	

}
