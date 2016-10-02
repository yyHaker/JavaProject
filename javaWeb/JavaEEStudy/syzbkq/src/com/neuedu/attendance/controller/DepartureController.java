package com.neuedu.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.neuedu.attendance.entity.Departure;
import com.neuedu.attendance.service.DepartureService;

import cn.thinking.common.baseeditor.BaseController;
import cn.thinking.common.util.JsonUtil;

@Controller
@RequestMapping(value=DepartureController.modulePath)
public class DepartureController extends BaseController {
	public static final String modulePath="module/system/departure";
	
	@Autowired
	@Qualifier("departureService")
	private DepartureService departureService;
	
	//离岗申请主页面的数据显示
	@ResponseBody
	@RequestMapping(value="/searchDepartureList")
	public String searchDepartureList() throws Exception
	{
		String res = super.readRequestInputStream();
		List<Departure> searchList = JsonUtil.jsonToList(res, Departure.class);
		Departure departure = searchList.get(0);
		List<Departure> departureList = departureService.listPageSearchDeparture(departure);
		if(departureList!=null)
		{
			return successPageJson(departureList, departure);
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
		mv.setViewName(DepartureController.modulePath+"/departure.jsp");
		return mv;
	}
	
	//申请离岗
	@ResponseBody
	@RequestMapping(value="/insertDeparture",method=RequestMethod.POST)
	public String insertDeparture() throws Exception
	{
		String res = super.readRequestInputStream();
		List<Departure> departureList = JsonUtil.jsonToList(res, Departure.class);
		Departure departure = departureList.get(0);
		departureService.insertDeparture(departure);
		if(departureList!=null)
		{
			return successJson(departureList);
		}
		else
		{
			return errorJson("");
		}	
	}
	
	//离岗审批
	@ResponseBody
	@RequestMapping(value="/updateStatus",method=RequestMethod.POST)
	public String updateStatus() throws Exception
	{
		String res = super.readRequestInputStream();
		Departure departure = JsonUtil.jsonToObject(res, Departure.class);
		List<Departure> departureList = departure.getList();
		String id = departureList.get(0).getID();
		departureService.upstatus(departureList);

		if(departure!=null)
		{
			return successJson(departure);
		}
		else
		{
			return errorJson("");
		}
		
	}

}
