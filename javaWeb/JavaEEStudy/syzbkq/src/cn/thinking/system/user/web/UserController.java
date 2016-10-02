package cn.thinking.system.user.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.thinking.common.baseeditor.BaseController;
import cn.thinking.common.util.CommonUtils;
import cn.thinking.common.util.JsonUtil;
import cn.thinking.common.util.RightsHelper;
import cn.thinking.common.util.Tools;
import cn.thinking.common.view.UserExcelView;
import cn.thinking.org.system.menu.Menu;
import cn.thinking.org.system.role.Role;
import cn.thinking.org.system.unit.Unit;
import cn.thinking.org.system.user.User;
import cn.thinking.system.menu.service.MenuService;
import cn.thinking.system.role.service.RoleService;
import cn.thinking.system.unit.service.UnitService;
import cn.thinking.system.user.service.IUserService;

/**
 * 
 * Description: 用户视图处理器
 * 
 * Department: 沈阳开发二部 
 * @author liu.jia_neu
 * @update [修改人] [修改时间]
 * @version 1.0
 *
 */
@Controller
@RequestMapping(value = UserController.modulePath)
public class UserController extends BaseController {

	// 模块页面根路径
	public static final String modulePath = "module/system/user";

	@Autowired
	private IUserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private MenuService menuService;

	@Autowired
	private UnitService unitService;

	/**
	 * 显示用户列表
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping
	public ModelAndView list(User user) {
		List<User> userList = userService.listPageUser(user);
		Unit orgInfo = new Unit();
		Unit deptInfo = new Unit();
		for (User tmp : userList) {
			orgInfo = unitService.getUnitById(tmp.getUserorgid());
			deptInfo = unitService.getUnitById(tmp.getUserdeptid());
			tmp.setOrgname(orgInfo == null ? "未设定" : orgInfo.getOrgName());
			tmp.setDeptname(deptInfo == null ? "未设定" : deptInfo.getOrgName());
		}

		List<Role> roleList = roleService.listAllRoles();
		ModelAndView mv = new ModelAndView();
		mv.setViewName(UserController.modulePath + "/users.jsp");
		mv.addObject("userList", userList);
		mv.addObject("roleList", roleList);
		mv.addObject("user", user);
		return mv;
	}

	/**
	 * 请求新增用户页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add")
	public String toAdd(Model model) {
		List<Role> roleList = roleService.listAllRoles();
		model.addAttribute("roleList", roleList);
		List<Unit> unitList = unitService.listAllParentUnit();
		model.addAttribute("unitList", unitList);
		List<Unit> deptList = unitService.listAllSubUnit();
		model.addAttribute("deptList", deptList);
		return UserController.modulePath + "/user_info.jsp";
	}

	/**
	 * 请求编辑用户页面
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public ModelAndView toEdit(@RequestParam int userId) {
		ModelAndView mv = new ModelAndView();
		User user = userService.getUserById(userId);
		List<Role> roleList = roleService.listAllRoles();
		mv.addObject("user", user);
		mv.addObject("roleList", roleList);
		List<Unit> unitList = unitService.listAllParentUnit();
		mv.addObject("unitList", unitList);
		List<Unit> deptList = unitService.listAllSubUnit();
		mv.addObject("deptList", deptList);
		mv.setViewName(UserController.modulePath + "/user_info.jsp");
		return mv;
	}

	/**
	 * 删除某个用户
	 * 
	 * @param userId
	 * @param out
	 */
	@RequestMapping(value = "/delete")
	public void deleteUser(@RequestParam int userId, PrintWriter out) {
		userService.deleteUser(userId);
		out.write("success");
		out.close();
	}

	/**
	 * 请求用户授权页面
	 * 
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/auth")
	public String auth(@RequestParam int userId, Model model) {
		List<Menu> menuList = menuService.listAllMenu();
		User user = userService.getUserById(userId);
		String userRights = user.getRights();
		if (Tools.notEmpty(userRights)) {
			for (Menu menu : menuList) {
				menu.setHasMenu(RightsHelper.testRights(userRights, menu.getMenuId()));
				if (menu.isHasMenu()) {
					List<Menu> subRightsList = menu.getSubMenu();
					for (Menu sub : subRightsList) {
						sub.setHasMenu(RightsHelper.testRights(userRights, sub.getMenuId()));
					}
				}
			}
		}
		JSONArray arr = JSONArray.fromObject(menuList);
		String json = arr.toString();
		json = json.replaceAll("menuId", "id").replaceAll("menuName", "name").replaceAll("subMenu", "nodes").replaceAll("hasMenu", "checked");
		model.addAttribute("zTreeNodes", json);
		model.addAttribute("userId", userId);
		return UserController.modulePath + "/authorization.jsp";
	}

	/**
	 * 保存用户权限
	 * 
	 * @param userId
	 * @param menuIds
	 * @param out
	 */
	@RequestMapping(value = "/auth/save")
	public void saveAuth(@RequestParam int userId, @RequestParam String menuIds, PrintWriter out) {
		BigInteger rights = RightsHelper.sumRights(Tools.str2StrArray(menuIds));
		User user = userService.getUserById(userId);
		user.setRights(rights.toString());
		userService.updateUserRights(user);
		out.write("success");
		out.close();
	}

	/**
	 * 导出用户信息到excel
	 * 
	 * @return
	 */
	@RequestMapping(value = "/excel")
	public ModelAndView export2Excel() {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("用户名");
		titles.add("名称");
		titles.add("角色");
		titles.add("最近登录");
		dataMap.put("titles", titles);
		List<User> userList = userService.listAllUser();
		dataMap.put("userList", userList);
		UserExcelView erv = new UserExcelView();
		ModelAndView mv = new ModelAndView(erv, dataMap);
		return mv;
	}

	/**
	 * 请求修改用户密码页面
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/editPassword")
	public ModelAndView toEditPassword() {
		ModelAndView mv = new ModelAndView();
		User currentUser = CommonUtils.getCurrentUserInfo(request);
		mv.addObject("user", currentUser);
		mv.setViewName("system/user_password");
		return mv;
	}

	/**
	 * 保存用户信息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	public ModelAndView updatePassword(User user) {
		ModelAndView mv = new ModelAndView();
		if (user.getUserId() == null || user.getUserId().intValue() == 0) {
			mv.addObject("msg", "failed");
		} else {
			try {
				user.setPassword(Tools.replaceBlank(Tools.encryptBASE64(user.getPassword().getBytes())));
			} catch (Exception e) {
				e.printStackTrace();
			}
			userService.updateUserPassword(user);
		}
		mv.setViewName("system/save_result");
		return mv;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
	}

	/**
	 * 测试ajax交互数据,根据userId获取用户信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/testAjax")
	@ResponseBody
	public String testAjax() throws Exception {
		String res = super.readRequestInputStream();
		
		/**
		 * 以下注释中,在json的工具类中有处理json字符串方法,下如：将传入的json值对应javaBean形成List
		 */
		List<User> userList = JsonUtil.jsonToList(res, User.class);
		int userId = userList.get(0).getUserId();// 解析res传入参数

		// 查询用户信息
		User user = userService.getUserById(userId);

		// 判断查询结果
		if (user != null) {
			return successJson(user);
		} else {
			return errorJson("");
		}
	}
	
	/**
	 * 保存用户信息
	 * 
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser() throws Exception {
		String res = super.readRequestInputStream();
		User user = JsonUtil.jsonToObject(res, User.class);
		if (user.getUserId() == null || user.getUserId().intValue() == 0) {
			try {
				user.setPassword(Tools.replaceBlank(Tools.encryptBASE64(user.getPassword().getBytes())));
			} catch (Exception e) {
				e.printStackTrace();
				return errorJson("");
			}
			user.setUserlevel(1);
			user.setStatus(0);
			if (userService.insertUser(user) == false) {
				return errorJson("");
			} else {
				return successJson(user);
			}
		} else {
			try {
				user.setPassword(Tools.replaceBlank(Tools.encryptBASE64(user.getPassword().getBytes())));
			} catch (Exception e) {
				e.printStackTrace();
				return errorJson("");
			}
			userService.updateUserBaseInfo(user);
			return successJson(user);
		}
		/*
		ModelAndView mv = new ModelAndView();
		if (user.getUserId() == null || user.getUserId().intValue() == 0) {
			try {
				user.setPassword(Tools.replaceBlank(Tools.encryptBASE64(user.getPassword().getBytes())));
			} catch (Exception e) {
				e.printStackTrace();
			}
			user.setUserlevel(1);
			user.setStatus(0);
			if (userService.insertUser(user) == false) {
				mv.addObject("msg", "failed");
			} else {
				mv.addObject("msg", "success");
			}
		} else {
			try {
				user.setPassword(Tools.replaceBlank(Tools.encryptBASE64(user.getPassword().getBytes())));
			} catch (Exception e) {
				e.printStackTrace();
			}
			userService.updateUserBaseInfo(user);
		}
		mv.setViewName("system/user.do");
		return mv;
		*/
	}

}
