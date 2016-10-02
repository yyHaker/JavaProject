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

import com.neuedu.entity.baseinfo.BanTeam;
import com.neuedu.service.kq.BanTeamService;

import cn.thinking.common.baseeditor.BaseController;
import cn.thinking.common.util.JsonUtil;
/**
 * 班组控制层
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value=BanTeamController.modulePath)
public class BanTeamController extends BaseController {
	public static final String modulePath="module/system/banteam";
	
	@Autowired
	@Qualifier("banTeamService")
	private BanTeamService banteamservice;

	//班组主页信息显示
	@ResponseBody
	@RequestMapping(value="/searchBanTeamList")
	public String searchBanTeamList() throws Exception{
		String res = super.readRequestInputStream();
		List<BanTeam> searchList = JsonUtil.jsonToList(res, BanTeam.class);
		BanTeam banteam = searchList.get(0);
		List<BanTeam> banteamList = banteamservice.listPageSearchBanTeam(banteam);
		if(banteamList!=null)
		{
			return successPageJson(banteamList, banteam);
		}
		else
		{
			return errorJson("");
		}
	}
	
	@RequestMapping
	public ModelAndView list(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName(BanTeamController.modulePath+"/banteam.jsp");
		return mv;
	}
	
	//删除
	@RequestMapping(value="/delete")
	public void deleteBanteam(@RequestParam String banteam_id,PrintWriter out){
		banteamservice.deleteBanteam(banteam_id);
		out.write("success");
		out.close();
	}
	
	//增加
	@ResponseBody
	@RequestMapping(value="/addBanteam",method=RequestMethod.POST)
	public String insertBanteam() throws Exception{
		String res = super.readRequestInputStream();
		List<BanTeam> list = JsonUtil.jsonToList(res, BanTeam.class);
		BanTeam banteam = list.get(0);
		banteamservice.insertBanteam(banteam);
		if(banteam!=null){
			return successJson(banteam);
		}
		else
		{
			return errorJson("");
		}
	}
	
	//详细信息显示
	@ResponseBody
	@RequestMapping(value="/findBanteam",method=RequestMethod.POST)
	public String findBanteam() throws Exception{
		String res = super.readRequestInputStream();
		List<BanTeam> list = JsonUtil.jsonToList(res, BanTeam.class);
		String banteam_id = list.get(0).getBanTeam_id();
		BanTeam banteam = banteamservice.findBanteam(banteam_id);
		if(banteam!=null)
		{
			return successJson(banteam);
		}
		else
		{
			return errorJson("");
		}
	}
	
	//修改
	@ResponseBody
	@RequestMapping(value="/updateBanteam",method=RequestMethod.POST)
	public String updateBanteam() throws Exception{
		String res =super.readRequestInputStream();
		BanTeam list = JsonUtil.jsonToObject(res, BanTeam.class);		
		banteamservice.updateBanteam(list);
		BanTeam banteam = banteamservice.findBanteam(list.getBanTeam_id());
		if(banteam!=null)
		{
			return successJson(banteam);
		}
		else
		{
			return errorJson("");
		}
	}

}
