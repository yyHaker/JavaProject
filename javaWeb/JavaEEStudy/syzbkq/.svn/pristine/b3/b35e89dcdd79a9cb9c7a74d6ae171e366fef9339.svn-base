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

import com.neuedu.entity.baseinfo.ClassManage;
import com.neuedu.service.kq.ClassManageService;

import cn.thinking.common.baseeditor.BaseController;
import cn.thinking.common.util.JsonUtil;
import cn.thinking.org.system.codelist.Codelist;
import cn.thinking.system.codelist.service.CodelistService;
@Controller
@RequestMapping(value=ClassManageController.modulePath)
public class ClassManageController extends BaseController {
	public static final String modulePath="module/system/classManage";
	
	@Autowired
	@Qualifier("classManageService")
	private ClassManageService classManageService;
	
	@Autowired
	private CodelistService  codelistService;
	
	//班制管理主页显示
	@ResponseBody
	@RequestMapping(value="/searchClassManageList")
	public String searchClassManageList() throws Exception{
		String  res = super.readRequestInputStream();
		List<ClassManage> searchList = JsonUtil.jsonToList(res, ClassManage.class);
		ClassManage classManage = searchList.get(0);
		List<ClassManage> classManageList = classManageService.listPageSearchClassManage(classManage);
		if(classManageList!=null)
		{
			return successPageJson(classManageList, classManage);
		}
		else
		{
			return errorJson("");
		}
	}
	
	@RequestMapping
	public ModelAndView list(){
		List<Codelist> BanSystemlist=codelistService.listBanSystem();
		ModelAndView mv = new ModelAndView();
		mv.addObject("BanSystemlist", BanSystemlist);
		mv.setViewName(ClassManageController.modulePath+"/classManage.jsp");
		return mv;
	}
	
	//新增
	@ResponseBody
	@RequestMapping(value="/addClassManage",method=RequestMethod.POST)
	public String addClassManage() throws Exception{
		String res = super.readRequestInputStream();
		List<ClassManage> searchList = JsonUtil.jsonToList(res, ClassManage.class);
		ClassManage classManage = searchList.get(0);
		classManageService.insertClassManage(classManage);
		if(classManage!=null)
		{
			return successJson(classManage);
		}
		else
		{
			return errorJson("");
		}
	}
	
	//查看详细信息
	@ResponseBody
	@RequestMapping(value="/selectClassManage",method=RequestMethod.POST)
	public String selectClassManage() throws Exception{
		String res = super.readRequestInputStream();
		List<ClassManage> searchList = JsonUtil.jsonToList(res, ClassManage.class);
		String id = searchList.get(0).getClass_system_id();
		ClassManage classManage = classManageService.findClassManage(id);
		if(classManage!=null)
		{
			return successJson(classManage);
		}
		else
		{
			return errorJson("");
		}
	}
	
	//删除数据
	@RequestMapping(value="delete")
	public void deleteClassManage(@RequestParam String class_system_id,PrintWriter out) {
		classManageService.deleteClassManage(class_system_id);
		out.write("success");
		out.close();
    }
	
	//修改信息
	@ResponseBody
	@RequestMapping(value="/updateClassManage",method=RequestMethod.POST)
	public String updateClassManage() throws Exception{
		String res =super.readRequestInputStream();
		ClassManage classManage = JsonUtil.jsonToObject(res, ClassManage.class);
		if(classManage.getName().equals("正常班制")){
			classManage.setName("1");
		}
		else if(classManage.getName().equals("两班倒班制")){
			classManage.setName("2");
		}
		else if(classManage.getName().equals("三班倒班制")){
			classManage.setName("3");
		}
		else{
			classManage.setName("4");
		}
		classManageService.updateClassManage(classManage);
		if(classManage!=null){
			return successJson(classManage);
		}
		else{
			return errorJson("");
		}
	}
	
}