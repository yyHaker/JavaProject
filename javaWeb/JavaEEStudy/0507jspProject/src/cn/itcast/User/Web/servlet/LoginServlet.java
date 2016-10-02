package cn.itcast.User.Web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.User.Service.UserService;
import cn.itcast.User.domain.User;
import cn.itcast.commons.CommonUtils;

/**
 * userServlet层
 * @author 57217
 *
 */
public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//依赖userService
		UserService userservice=new UserService();
		/**
		 * 1.封装表单数据到user form中
		 * 2.调用service 的Login方法,得到返回的User对象
		 *   >如果抛出异常，获取异常信息，保存到request域中，再保存到form，转发到Login.jsp
		 *   >如果没有异常信息，保存到session中，重定向到index.jsp
		 *   
		 */
		User form =CommonUtils.toBean(request.getParameterMap(),User.class);
		try {
			User user=userservice.Login(form);
			request.getSession().setAttribute("sessionUser", form);
			response.sendRedirect(request.getContextPath()+"/User/index.jsp");
		} catch (Exception e) {
			request.setAttribute("msg",e.getMessage());
			request.setAttribute("user", form);
			request.getRequestDispatcher("/User/Login.jsp").forward(request, response);
			
		}
		
		
	}

}
