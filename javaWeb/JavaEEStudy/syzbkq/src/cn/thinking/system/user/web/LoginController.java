package cn.thinking.system.user.web;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import cn.thinking.common.util.Const;
import cn.thinking.common.util.RightsHelper;
import cn.thinking.common.util.Tools;
import cn.thinking.org.system.menu.Menu;
import cn.thinking.org.system.role.Role;
import cn.thinking.org.system.unit.Unit;
import cn.thinking.org.system.user.User;
import cn.thinking.system.menu.service.MenuService;
import cn.thinking.system.unit.service.UnitService;
import cn.thinking.system.user.service.IUserService;

@Controller
public class LoginController {
	public static final String modulePath = "module/common";
	@Autowired
	private IUserService userService;

	@Autowired
	private MenuService menuService;

	@Autowired
	private UnitService unitService;

	/**
	 * 访问登录页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet() {
		return "module/common/login.jsp";
	}

	/**
	 * 请求登录，验证用户
	 * 
	 * @param session
	 * @param loginname
	 * @param password
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost(HttpSession session, @RequestParam String loginname, @RequestParam String password) {

		ModelAndView mv = new ModelAndView();
		String errInfo = "";
		User user = null;

		try {
			password = Tools.replaceBlank(Tools.encryptBASE64(password.getBytes()));
			user = userService.getUserByNameAndPwd(loginname, password);

			if (user != null) {
				user.setLastLogin(new Date());
				userService.updateLastLogin(user);
				Unit orgInfo = unitService.getUnitById(user.getUserorgid());
				Unit deptInfo = unitService.getUnitById(user.getUserdeptid());
				user.setOrgname(orgInfo == null ? "未设定" : orgInfo.getOrgName());
				user.setDeptname(deptInfo == null ? "未设定" : deptInfo.getOrgName());
				session.setAttribute(Const.SESSION_USER, user);
			} else {
				errInfo = "用户名或密码有误！";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (Tools.isEmpty(errInfo)) {
			mv.setViewName("redirect:/index.do");
		} else {
			mv.addObject("errInfo", errInfo);
			mv.addObject("loginname", loginname);
			mv.addObject("password", password);
			mv.setViewName(modulePath+"/login.jsp");
		}
		return mv;
	}

	/**
	 * 访问系统首页
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/index")
	public String index(HttpSession session, Model model) {
		User user = (User) session.getAttribute(Const.SESSION_USER);
		user = userService.getUserAndRoleById(user.getUserId());
		Unit orgInfo = unitService.getUnitById(user.getUserorgid());
		Unit deptInfo = unitService.getUnitById(user.getUserdeptid());
		user.setOrgname(orgInfo == null ? "未设定" : orgInfo.getOrgName());
		user.setDeptname(deptInfo == null ? "未设定" : deptInfo.getOrgName());
		Role role = user.getRole();
		String roleRights = role != null ? role.getRights() : "";
		String userRights = user.getRights();
		// 避免每次拦截用户操作时查询数据库，以下将用户所属角色权限、用户权限限都存入session
		session.setAttribute(Const.SESSION_ROLE_RIGHTS, roleRights); // 将角色权限存入session
		session.setAttribute(Const.SESSION_USER_RIGHTS, userRights); // 将用户权限存入session

		List<Menu> menuList = menuService.listAllMenu();
		if (Tools.notEmpty(userRights) || Tools.notEmpty(roleRights)) {
			for (Menu menu : menuList) {
				menu.setHasMenu(RightsHelper.testRights(userRights, menu.getMenuId()) || RightsHelper.testRights(roleRights, menu.getMenuId()));
				if (menu.isHasMenu()) {
					List<Menu> subMenuList = menu.getSubMenu();
					for (Menu sub : subMenuList) {
						sub.setHasMenu(RightsHelper.testRights(userRights, sub.getMenuId()) || RightsHelper.testRights(roleRights, sub.getMenuId()));
					}
				}
			}
		}
		model.addAttribute("user", user);
		model.addAttribute("menuList", menuList);
		return "module/common/index.jsp";
	}

	/**
	 * 进入首页后的默认页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/default")
	public String defaultPage() {
		return "module/common/default.jsp";
	}

	/**
	 * 用户注销
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.removeAttribute(Const.SESSION_USER);
		session.removeAttribute(Const.SESSION_ROLE_RIGHTS);
		session.removeAttribute(Const.SESSION_USER_RIGHTS);
		return "redirect:/login.do";
	}
	
}
