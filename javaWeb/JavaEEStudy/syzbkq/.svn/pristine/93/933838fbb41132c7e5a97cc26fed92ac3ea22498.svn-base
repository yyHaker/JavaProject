package cn.thinking.system.trainingplan.web;


import java.util.List;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.thinking.common.baseeditor.BaseController;
import cn.thinking.org.system.trainingplan.Trainingplan;
import cn.thinking.system.trainingplan.service.ITrainingplanService;



@Controller
@RequestMapping(value = TrainingplanController.modulePath)
public class TrainingplanController  extends BaseController{
	public static final String modulePath = "module/system/trainingplan";
	
	@Autowired
	private ITrainingplanService trainingplanService;
	
	@RequestMapping
	public ModelAndView list(Trainingplan trainingplan) {
		Trainingplan tr=new Trainingplan();
		String hostdepartment=request.getParameter("hostdepartment");
		String tcontent=request.getParameter("tcontent");
		String tobjectives=request.getParameter("tobjectives");
		String tobject=request.getParameter("tobject");
//		Data trainingdate=request.getParameter("trainingdate");
		String tplaces=request.getParameter("tplaces");
		String lecturesource=request.getParameter("lecturesource");
		String assistdepartment=request.getParameter("assistdepartment");
		tr.setHostdepartment(hostdepartment);
		tr.setTcontent(tcontent);
		tr.setTobjectives(tobjectives);
		tr.setTobject(tobject);
		tr.setTplaces(tplaces);
		tr.setLecturesource(lecturesource);
		tr.setAssistdepartment(assistdepartment);
		List<Trainingplan> trainingplanList=trainingplanService.selectTrainingplanBydepartment(tr);
		ModelAndView mv = new ModelAndView();
		mv.setViewName(TrainingplanController.modulePath+ "/trainingplan.jsp");
		mv.addObject("trainingplanList", trainingplanList);
		return mv;	
    }
	
	

}
