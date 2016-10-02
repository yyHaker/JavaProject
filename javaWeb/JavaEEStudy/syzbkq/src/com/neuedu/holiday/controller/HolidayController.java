package com.neuedu.holiday.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.neuedu.holiday.entity.Holiday;
import com.neuedu.holiday.service.HolidayService;
import com.neuedu.vacation.entity.Vacation;
import com.neuedu.vacation.service.VacationService;

import cn.thinking.common.baseeditor.BaseController;
import cn.thinking.common.util.JsonUtil;
import cn.thinking.system.codelist.service.CodelistService;

@Controller
@RequestMapping(value = HolidayController.modulePath)
public class HolidayController extends BaseController {

	public static final String modulePath = "module/system/holiday";
	
	@Autowired
	@Qualifier("holidayService")
	private HolidayService holidayService;
	
	@Autowired
	@Qualifier("vacationService")
	private VacationService vacationService;
	
	@Autowired
	private CodelistService codelistservice;
	
	/**
	 * 法定假期维护列表查询
	 */
	@ResponseBody
	@RequestMapping(value = "/searchHolidayList", method = RequestMethod.POST)
	public String searchHolidayList() throws Exception{
		String res = super.readRequestInputStream();
		List<Holiday> searchList = JsonUtil.jsonToList(res, Holiday.class);
		Holiday holiday = searchList.get(0);
		List<Holiday> holidayList = holidayService.searchHolidayList(holiday);
		Object object = holidayList;
		
		if(object != null){
			return successPageJson(object, holiday);
		} else {
			return errorJson("");
		}
	}
	

	@RequestMapping
	public ModelAndView list() {
		// 编辑中显示的动态下拉列表框,再用ModelAndView的addobject的方法把数据库中的信息 加载出来
		ModelAndView mv = new ModelAndView();
		mv.setViewName(HolidayController.modulePath + "/holiday.jsp");
		return mv;
	}
	/**
	 * 删除假期维护
	 * @param hdId
	 * @param out
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteholida",method = RequestMethod.GET)
	public void delholiday(HttpServletRequest req) throws Exception{
		String hdIds = req.getParameter("hdId");
		int hdId =Integer.parseInt(hdIds);
		holidayService.deleteholiday(hdId);
	}
	
	
	/**
	 * 根据假期ID查询法定假期信息
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/searchHolidayInfo", method = RequestMethod.POST)
	public String searchHolidayInfo() throws Exception {
		String res = super.readRequestInputStream();
		List<Holiday> holidayList = JsonUtil.jsonToList(res, Holiday.class);

		int hdId = holidayList.get(0).getHdId();

		Holiday holiday = holidayService.searchHolidayInfoById(hdId);

		if (holiday != null) {
			return successJson(holiday);
		} else {
			return errorJson("");
		}
	}
		
	/**
	 * 根据假期ID修改假期信息
	 */
	@ResponseBody
	@RequestMapping(value = "/updatHoliday", method = RequestMethod.POST)
	public String updatHolidayInfo() throws Exception {
		String res = super.readRequestInputStream();
		List<Holiday> holidayList = JsonUtil.jsonToList(res, Holiday.class);

		int hdId = holidayList.get(0).getHdId();
		Holiday holiday = holidayList.get(0);
		holidayService.editHoliday(holiday);
		Holiday holidaies = holidayService.searchHolidayInfoById(hdId);
		Object object = holidaies;

		if (object != null) {
			return successJson(object);
		} else {
			return errorJson("");
		}

	}
	
	/**
	 * 新增法定假期
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String insertHoliday() throws Exception {
		String res = super.readRequestInputStream();
		List<Holiday> holiday = JsonUtil.jsonToList(res, Holiday.class);

		Vacation vacation= new Vacation();
		List<Vacation> vacations=vacationService.searchVacationList(vacation);
		
		for(int i = 0; i<holiday.size();i++){
			if(holiday.get(i).getVacationName().equals(vacations.get(i).getVacationName())){
				holiday.get(i).setVacationId(vacations.get(i).getVacationId());
			}
		}
		
		holidayService.insertHoliday(holiday);

		Object object = holiday;

		if (object != null) {
			return successJson(object);
		} else {
			return errorJson("");
		}
	}

}
