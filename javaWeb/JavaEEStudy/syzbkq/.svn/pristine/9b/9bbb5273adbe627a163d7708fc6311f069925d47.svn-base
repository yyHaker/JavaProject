package com.neuedu.overtime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.neuedu.attendance.entity.Departure;
import com.neuedu.overtime.entity.Overtime;
import com.neuedu.overtime.service.ApprovalService;

import cn.thinking.common.baseeditor.BaseController;
import cn.thinking.common.util.CommonUtils;
import cn.thinking.common.util.Const;
import cn.thinking.common.util.JsonUtil;
import cn.thinking.org.system.user.User;

@Controller
@RequestMapping(value = ApprovalController.modulePath)
public class ApprovalController extends BaseController{
	
		public static final String modulePath="module/system/approval";
		
		@Autowired
		@Qualifier("approvalService")
		private ApprovalService approvalService;
		
		    //加班申请主页面的数据显示
			@ResponseBody
			@RequestMapping(value="/searchOvertimeList")
			public String searchOvertimeList() throws Exception
			{
				String res = super.readRequestInputStream();
				List<Overtime> searchList = JsonUtil.jsonToList(res, Overtime.class);				
				Overtime overtime = searchList.get(0);
				List<Overtime> overtimeList = approvalService.listPageOvertime(overtime);
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
				mv.setViewName(ApprovalController.modulePath+"/approval.jsp");
				return mv;
			}
			
			//加班审批
			@ResponseBody
			@RequestMapping(value="/updateApproval",method=RequestMethod.POST)
			public String updateApproval() throws Exception
			{
				String res = super.readRequestInputStream();
				Overtime overtime = JsonUtil.jsonToObject(res, Overtime.class);
				User user = (User) session.getAttribute(Const.SESSION_USER);
				String approver=user.getUsername();	
				List<Overtime> overtimeList = overtime.getList();
				for(int i=0;i<overtimeList.size();i++){
					overtimeList.get(i).setApprover(approver);
				}				
				approvalService.updateApproval(overtimeList);

				if(overtime!=null)
				{
					return successJson(overtime);
				}
				else
				{
					return errorJson("");
				}				
			}
			
			//加班审批驳回
			@ResponseBody
			@RequestMapping(value="/rejectApproval",method=RequestMethod.POST)
			public String rejectApproval() throws Exception
			{
				String res = super.readRequestInputStream();											
				Overtime overtime = JsonUtil.jsonToObject(res, Overtime.class);				
				User user = (User) session.getAttribute(Const.SESSION_USER);
				String approver=user.getUsername();	
				List<Overtime> overtimeList = overtime.getList();
				for(int i=0;i<overtimeList.size();i++){
					overtimeList.get(i).setApprover(approver);
				}	
				approvalService.rejectApproval(overtimeList);

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
