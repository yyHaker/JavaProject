package com.neuedu.vacation.controller;

import java.io.IOException;
import java.sql.SQLException;
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
import cn.thinking.system.codelist.service.CodelistService;

import com.neuedu.vacation.entity.Vacation;
import com.neuedu.vacation.service.VacationService;

@Controller
@RequestMapping(value = VacationController.modulePath)
public class VacationController extends BaseController {

	public static final String modulePath = "module/system/vacation";

	@Autowired
	@Qualifier("vacationService")
	private VacationService vacationService;

	@Autowired
	private CodelistService codelistservice;

	/**
	 * 假期管理列表查询
	 */
	@ResponseBody
	@RequestMapping(value = "/searchVacationList", method = RequestMethod.POST)
	public String searchVacationList() throws Exception {
		String res = "";
		res = super.readRequestInputStream();
		List<Vacation> searchList = JsonUtil.jsonToList(res, Vacation.class);
		Vacation vacation = searchList.get(0);
		List<Vacation> vacationList = vacationService
				.searchVacationList(vacation);
		Object object = vacationList;
		
		System.out.println();
		
		if (object != null) {
			return successPageJson(object, vacation);
		} else {
			return errorJson("");
		}
	}

	/**
	 * 显示假期管理列表页面假期类型下拉框
	 */
	@RequestMapping
	public ModelAndView list(){
		// 编辑中显示的动态下拉列表框,再用ModelAndView的addobject的方法把数据库中的信息 加载出来
		List<Codelist> vacationTypeList = codelistservice.listvacationType();
		ModelAndView mv = new ModelAndView();
		mv.addObject("vacationTypeList", vacationTypeList);
		mv.setViewName(VacationController.modulePath + "/vacation.jsp");
		return mv;
	}

	/**
	 * 新增假期
	 * 
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String insertVacation() throws Exception {
		String res = super.readRequestInputStream();
		Vacation vacation = JsonUtil.jsonToObject(res, Vacation.class);

		vacationService.insertVacation(vacation);

		Object object = vacation;

		if (object != null) {
			return successJson(vacation);
		} else {
			return errorJson("");
		}
	}

	/**
	 * 根据假期ID查询假期信息
	 * 
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/searchVacationInfo", method = RequestMethod.POST)
	public String searchVacationInfo() throws Exception {
		String res = super.readRequestInputStream();
		List<Vacation> vacationList = JsonUtil.jsonToList(res, Vacation.class);

		int vacationId = vacationList.get(0).getVacationId();

		Vacation vacation = vacationService.searchVacationInfoById(vacationId);

		if (vacation != null) {
			return successJson(vacation);
		} else {
			return errorJson("");
		}
	}

	/**
	 * 根据假期ID修改假期信息
	 */
	@ResponseBody
	@RequestMapping(value = "/updatVacation", method = RequestMethod.POST)
	public String updateVacationInfo() throws Exception {
		String res = "";
		res = super.readRequestInputStream();
		List<Vacation> vacationList = JsonUtil.jsonToList(res, Vacation.class);

		int vacationId = vacationList.get(0).getVacationId();
		Vacation vacation = vacationList.get(0);
		vacationService.updateVacationById(vacation);
		Vacation vacations = vacationService.searchVacationInfoById(vacationId);

		Object object = vacations;

		if (object != null) {
			return successJson(object);
		} else {
			return errorJson("");
		}

	}
}
