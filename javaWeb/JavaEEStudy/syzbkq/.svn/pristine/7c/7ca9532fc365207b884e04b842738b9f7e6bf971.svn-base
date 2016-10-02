package com.neuedu.controller;

import java.io.PrintWriter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.neuedu.entity.baseinfo.WorkManage;
import com.neuedu.service.kq.WorkManageService;
import cn.thinking.common.baseeditor.BaseController;
import cn.thinking.common.util.JsonUtil;
import cn.thinking.org.system.codelist.Codelist;
import cn.thinking.system.codelist.service.CodelistService;

@Controller
@RequestMapping(value=WorkManageController.modulePath)
public class WorkManageController extends BaseController {
	public static final String  modulePath="module/system/workmanage";
	
	@Autowired
	@Qualifier("workManageService")
	private WorkManageService workManageService;
	
	@Autowired
	private CodelistService codelistService;
	
	//显示主页面数据
	@ResponseBody
	@RequestMapping(value="/listsearchWorkManage")
	public String listsearchWorkManage() throws Exception{
		String res = super.readRequestInputStream();
		List<WorkManage> searchList = JsonUtil.jsonToList(res, WorkManage.class);
		WorkManage workmanage = searchList.get(0);
		List<WorkManage> workmanageList = workManageService.listPageSearchWorkManage(workmanage);
		if(workmanageList!=null){
			return successPageJson(workmanageList, workmanage);
		}
		else{
			return errorJson("");
		}
	}
	
	@RequestMapping
	public ModelAndView list(){
		List<Codelist> BanSystemList = codelistService.listBanSystem();
		ModelAndView mv = new ModelAndView();
		mv.addObject("BanSystemList", BanSystemList);
		mv.setViewName(WorkManageController.modulePath+"/workmanage.jsp");
		return mv;
	}
	 //排班新增
	@ResponseBody
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert() throws Exception{
		String res = super.readRequestInputStream();
		WorkManage workmanage = JsonUtil.jsonToObject(res, WorkManage.class);
		workManageService.addWorkManage(workmanage);
		if(workmanage!=null){
			return successJson(workmanage);
		}
		else{
			return errorJson("");
		}
	}
	
	//删除
	@RequestMapping(value="delete")
	public void deleteWorkManage(@RequestParam String workmanage_id,PrintWriter out){
		workManageService.deleteWorkManage(workmanage_id);
		out.write("success");
		out.close();
	}
	//修改信息之先查找信息
	@ResponseBody
	@RequestMapping(value="/getWorkManage",method=RequestMethod.POST)
	public String getWorkManage() throws Exception{
		String res = super.readRequestInputStream();
		WorkManage workmanage = JsonUtil.jsonToObject(res, WorkManage.class);
		String workmanage_id = workmanage.getWorkmanage_id();
		WorkManage workmanage1 = workManageService.getWorkManage(workmanage_id);
		if(workmanage1!=null){
			return successJson(workmanage1);
		}
		else{
			return errorJson("");
		}
	}
	
	//修改之后的保存
	@ResponseBody
	@RequestMapping(value="/addWorkManage",method=RequestMethod.POST)
	public String addWorkManage() throws Exception{
		String res = super.readRequestInputStream();
		WorkManage workmanage = JsonUtil.jsonToObject(res, WorkManage.class);
		if(workmanage.getWname().equals("正常班制")){
			workmanage.setWname("1");
		}
		else if(workmanage.getWname().equals("两班倒班制")){
			workmanage.setWname("2");
		}
		else if(workmanage.getWname().equals("三班倒班制")){
			workmanage.setWname("3");
		}
		else{
			workmanage.setWname("4");
		}
		workManageService.updateWorkManage(workmanage);
		if(workmanage!=null){
			return successJson(workmanage);
		}
		else{
			return errorJson("");
		}
	}

}
