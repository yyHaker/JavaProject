package cn.thinking.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.thinking.common.util.Const;
import cn.thinking.org.system.user.User;

/**
 * 
 * Description:用户登录拦截器,它在applicationContext-mvc.xml被定义为mvc的拦截器,所有的.do请求被它拦截判断session是否过期,若过期返回登录页面
 * 
 * Department: 沈阳开发二部
 * 
 * @author liu.jia_neu
 * @update [修改人] [修改时间]
 * @version 1.0
 * 
 */
public class LoginHandlerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		if (path.matches(Const.NO_INTERCEPTOR_PATH)) {
			return true;
		} else {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute(Const.SESSION_USER);
			if (user != null) {
				return true;
			} else {
				response.sendRedirect(request.getContextPath() + "/login.do");
				return false;
			}
		}
	}

}
