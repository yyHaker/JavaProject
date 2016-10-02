package com.neuedu.attendance.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.neuedu.attendance.entity.Attendance;
import com.neuedu.attendance.service.AttendanceService;
import cn.thinking.common.baseeditor.BaseController;
import cn.thinking.common.util.JsonUtil;

@Controller
@RequestMapping(value = AttendanceController.modulePath)
public class AttendanceController extends BaseController {

	public static final String modulePath = "module/system/attendance";
	
	@Autowired
	@Qualifier("attendanceService")
	private AttendanceService  attendanceService;

	/**
	 * 考勤管理列表查询
	 */
	@ResponseBody
	@RequestMapping(value = "/searchAttendanceList", method = RequestMethod.POST)
	public String searchAttendanceList() throws Exception{
		String res = "";
		res = super.readRequestInputStream();
		List<Attendance> searchList = JsonUtil.jsonToList(res, Attendance.class);
		Attendance attendance = searchList.get(0);
		List<Attendance> attendanceList = attendanceService.listPageSearchAttendanceList(attendance);
		Object object = attendanceList;
		
		if(object != null){
			return successPageJson(object, attendance);
		} else {
			return errorJson("");
		}
	}
	

	@RequestMapping
	public ModelAndView list() {
		// 编辑中显示的动态下拉列表框,再用ModelAndView的addobject的方法把数据库中的信息 加载出来
		ModelAndView mv = new ModelAndView();
		mv.setViewName(AttendanceController.modulePath + "/attendance.jsp");
		return mv;
	}
	

	/**
	 * 根据用户ID查询打卡信息
	 * 
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/searchAttendanceInfo", method = RequestMethod.POST)
	public String searchAttendanceInfo() throws Exception {
		String res = super.readRequestInputStream();
		List<Attendance> attendanceList=JsonUtil.jsonToList(res, Attendance.class);		
		int userid=attendanceList.get(0).getUserid();		
		Attendance attendance=attendanceService.SearchAttendanceByUserid(userid);

		if (attendance != null) {
			return successJson(attendance);
		} else {
			return errorJson("");
		}
	}
	

	/**
	 * 根据假期ID修改打卡信息
	 */
	@ResponseBody
	@RequestMapping(value = "/updatAttendance", method = RequestMethod.POST)
	public String updatAttendance() throws Exception {
		String res = super.readRequestInputStream();
		Attendance attendance=JsonUtil.jsonToObject(res, Attendance.class);		
		int userid=attendance.getUserid();		
		attendanceService.updateAttendanceById(attendance);
		Attendance attendances = attendanceService.SearchAttendanceByUserid(userid);

		Object object = attendances;

		if (object != null) {
			return successJson(object);
		} else {
			return errorJson("");
		}

	}
}
