package cn.thinking.common.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.thinking.common.util.Const;
import cn.thinking.common.util.RightsHelper;
import cn.thinking.common.util.ServiceHelper;
import cn.thinking.common.util.Tools;
import cn.thinking.org.system.menu.Menu;
import cn.thinking.org.system.user.User;

/**
 * 
 * Description: 用户权限拦截器,它在applicationContext-mvc.xml被定义为mvc的拦截器,所有的.do请求被它拦截判断是否享有访问权限
 * 
 * Department: 沈阳开发二部 
 * @author liu.jia_neu
 * @update [修改人] [修改时间]
 * @version 1.0
 *
 */
public class RightsHandlerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // TODO Auto-generated method stub
        String path = request.getServletPath();
        if (path.matches(Const.NO_INTERCEPTOR_PATH))
            return true;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Const.SESSION_USER);
        Integer menuId = null;
        List<Menu> subList = ServiceHelper.getMenuService().listAllSubMenu();
        for (Menu m : subList) {
            String menuUrl = m.getMenuUrl();
            if (Tools.notEmpty(menuUrl)) {
                if (path.contains(menuUrl)) {
                    menuId = m.getMenuId();
                    break;
                }
                else {
                    String[] arr = menuUrl.split("\\.");
                    String regex = "";
                    if (arr.length == 2) {
                        regex = "/?" + menuUrl + "(/.*)?.";

                    }
                    else {
                        regex = "/?" + menuUrl + "(/.*)?.html";
                    }
                    if (path.matches(regex)) {
                        menuId = m.getMenuId();
                        break;
                    }
                }
            }
        }
        if (menuId != null) {
            String userRights = (String) session.getAttribute(Const.SESSION_USER_RIGHTS);
            String roleRights = (String) session.getAttribute(Const.SESSION_ROLE_RIGHTS);
            if (RightsHelper.testRights(userRights, menuId) || RightsHelper.testRights(roleRights, menuId)) {
                return true;
            }
            else {
                System.out.println("用户：" + user.getLoginname() + "试图访问" + path + "被阻止！");
                ModelAndView mv = new ModelAndView();
                mv.setViewName("system/no_rights");
                throw new ModelAndViewDefiningException(mv);
            }
        }
        return super.preHandle(request, response, handler);
    }

}
