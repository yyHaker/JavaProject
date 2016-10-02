package cn.thinking.system.trainer.web;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.thinking.common.baseeditor.BaseController;
import cn.thinking.common.util.JsonUtil;
import cn.thinking.org.system.trainer.Trainer;
import cn.thinking.system.trainer.service.ITrainerService;
import cn.thinking.system.trainer.web.TrainerController;

@Controller
@RequestMapping(value = TrainerController.modulePath)
public class TrainerController extends BaseController{

	public static final String modulePath = "module/system/trainer";
	
	@Autowired
	private ITrainerService trainerService;
	
	/**
	 * 显示内训师列表
	 * 
	 * @param trainer
	 * @return
	 */
	@RequestMapping
	public ModelAndView list(Trainer trainer){
		Trainer t=new Trainer();
		String name=request.getParameter("name");
		System.out.println(request.getParameter("name"));
		t.setName(name);
		List<Trainer> trainerList=trainerService.ListAllTrainer(t);
		ModelAndView mv = new ModelAndView();
		mv.setViewName(TrainerController.modulePath+"/trainer.jsp");
		mv.addObject("trainerList", trainerList);
		return mv;		
	}
	
	/**
	 * 测试ajax交互数据,根据employeenum获取用户信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/trainerInfo")
	@ResponseBody
	public String trainerInfo() throws Exception {
		String res = super.readRequestInputStream();
		
		/**
		 * 以下注释中,在json的工具类中有处理json字符串方法,下如：将传入的json值对应javaBean形成List
		 */
		List<Trainer> trainerList = JsonUtil.jsonToList(res, Trainer.class);
		String employeenum = trainerList.get(0).getEmployeenum();// 解析res传入参数

		// 查询用户信息
		Trainer trainer = trainerService.getTrainerById(employeenum);

		// 判断查询结果
		if (trainer != null) {
			return successJson(trainer);
		} else {
			return errorJson("");
		}
	}
	
	
	//删除某个用户
		@RequestMapping(value = "/delete")
		public void deleteUser(@RequestParam String employeenum, PrintWriter out)
		{
			trainerService.deleteUser(employeenum);
			out.write("success");
			out.close();
		}

		
		/*
      	修改用戶信息
      	從update.jsp過來的editTrainer
      */
	@ResponseBody 
	@RequestMapping(value = "/updatesave", method = RequestMethod.POST)
    public String editTrainer() throws Exception{
		String res = "";
//		ModelAndView mv=new ModelAndView();
			res = super.readRequestInputStream();
			List<Trainer>trainerList=JsonUtil.jsonToList(res, Trainer.class);
			String employeenum=trainerList.get(0).getEmployeenum();
			Trainer trainer=trainerList.get(0);
			trainerService.updateById(trainer);
			Trainer trainers=trainerService.selectTrainerById(employeenum);
			Object object =trainers;	
			if(object!=null){
				return successJson(object);
	    }
			else{
				return errorJson("");
		}
		
    }

	@RequestMapping(value="/selectAjax")
	@ResponseBody
	public String selectTrainer() throws Exception{
		
		String res=super.readRequestInputStream();
		
		List<Trainer>trainerList=JsonUtil.jsonToList(res, Trainer.class);
		String employeenum=trainerList.get(0).getEmployeenum();

		Trainer trainer=trainerService.selectTrainerById(employeenum);
		if(trainer!=null){
			return successJson(trainer);
		}
		else{
			return errorJson("");
		}
		
	}
}
