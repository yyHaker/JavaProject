package com.neuedu.controller;

import java.util.ArrayList;
import java.util.List;

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
import cn.thinking.common.util.JsonUtil;

@Controller
@RequestMapping(value=LeaveReviewController.modulePath)
public class LeaveReviewController extends BaseController {
	
	public static final String modulePath="module/system/leaveReview";
	
	@Autowired
	@Qualifier("leaveService")
	private LeaveService leaveService;
	
	//休假审批主页显示
		@ResponseBody
		@RequestMapping(value="/searchLeaveReviewList",method=RequestMethod.POST)
		public String searchLeaveReviewList() throws Exception
		{
			String res = super.readRequestInputStream();
			List<Leave> searchLeaveReviewList = JsonUtil.jsonToList(res, Leave.class);
			Leave leave = searchLeaveReviewList.get(0);
			List<Leave> leaveList = leaveService.getLeaveReviewList(leave);
			if(leaveList!=null)
			{
				return successPageJson(leaveList, leave);
			}
			else
			{
				return errorJson("");
			}		
		}
		
		//休假审批显示信息列表，即返给一个jsp页面
		@RequestMapping
		public ModelAndView list()
		{
			ModelAndView mv = new ModelAndView();
			mv.setViewName(LeaveReviewController.modulePath+"/leaveReview.jsp");
			return mv;
			
		}
		
		//休假审批通过
		@ResponseBody
		@RequestMapping(value="/updateSave",method=RequestMethod.POST)
		public String updataVacation_review() throws Exception
		{
			String res = super.readRequestInputStream();
			Leave leave = JsonUtil.jsonToObject(res, Leave.class);			
			List<Leave> leaveList1=leave.getList();
			String ID = leaveList1.get(0).getID();
		    leaveService.updataVacation_review(leaveList1);
            //通过上边得到的id得到一个对象，用于返给前台做判断
		    Leave leave1 = leaveService.getLeave(ID);
			if(leave1!=null)
			{
				return successJson(leave1);
			}
			else
			{
				return errorJson("");
			}
			
		}
		
		//提前休假
		@ResponseBody
		@RequestMapping(value="/updateFlag",method=RequestMethod.POST)
		public String updateFlag() throws Exception
		{
			String res = super.readRequestInputStream();
			/*List<Leave> leaveList = JsonUtil.jsonToList(res, Leave.class);
			String ID = leaveList.get(0).getID();
			leaveService.updateFlag(ID);*/
			leaveService.updateFlag(res);
			Leave leave = leaveService.getLeave(res);
			if(leave!=null)
			{
				return successJson(leave);
			}
			else
			{
				return errorJson("");
			}
		}

}
