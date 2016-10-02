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

import cn.thinking.common.baseeditor.BaseController;
import cn.thinking.common.util.JsonUtil;

import com.neuedu.entity.baseinfo.Quarters;
import com.neuedu.service.kq.QuartersService;

@Controller
@RequestMapping(value = QuartersController.modulePath)
public class QuartersController extends BaseController {
	
	public static final String modulePath = "module/system/quarters";
	
	@Autowired
	@Qualifier("quartersService")
	
	private QuartersService quartersService;
	
	@RequestMapping(value="/searchQuartersList",method=RequestMethod.POST)
	@ResponseBody
	public String searchQuartersList() throws Exception{
		
		String res = super.readRequestInputStream();
		List<Quarters> searchQuartersList = JsonUtil.jsonToList(res, Quarters.class);
		Quarters quarters = searchQuartersList.get(0);
		List<Quarters> quartersList = quartersService.listPageAllQuarters(quarters);
		
		if (quartersList != null){
			return successPageJson(quartersList,quarters);
		}
		else{
			return errorJson("");
		}
	}

    @RequestMapping
    public ModelAndView list(){
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName(QuartersController.modulePath+"/quarters.jsp");
    	return mv;
    }
    
	@ResponseBody
	@RequestMapping(value="getQuartersById",method=RequestMethod.POST)
	public String getQuartersById() throws Exception{
		String res = super.readRequestInputStream();
		List<Quarters> quartersList = JsonUtil.jsonToList(res, Quarters.class);
		int pid = quartersList.get(0).getPid();
		
		Quarters quarters = quartersService.getQuartersById(pid);
		
		if(quarters != null){
			return successJson(quarters);
		}
		else{
			return errorJson("");
		}
	}
	
	@ResponseBody
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateQuarters() throws Exception{
		String res = super.readRequestInputStream();
		List<Quarters> quartersList = JsonUtil.jsonToList(res, Quarters.class);
		
		int pid = quartersList.get(0).getPid();
		Quarters quarters = quartersList.get(0);
		
		quartersService.updateQuarters(quarters);
		
		Quarters quarters1 = quartersService.getQuartersById(pid);
		
		if(quarters1 != null){
			return successJson(quarters);
		}
		else{
			return errorJson("");
		}
	}
	
	@ResponseBody
	@RequestMapping(value="insert",method=RequestMethod.POST)
	public String insertQuarters() throws Exception{
		String res = super.readRequestInputStream();
		List<Quarters> quartersList = JsonUtil.jsonToList(res, Quarters.class);
		
		Quarters quarters = quartersList.get(0);
		
		quartersService.insertQuarters(quarters);
		
		if(quarters!=null){
			return successJson(quarters);
		}
		else{
			return errorJson("");
		}
	}
	
	@RequestMapping(value="delete")
	public void deleteQuarters(@RequestParam int pid,PrintWriter out){
		quartersService.deleteQuarters(pid);
		out.write("success");
		out.close();
	}
}
