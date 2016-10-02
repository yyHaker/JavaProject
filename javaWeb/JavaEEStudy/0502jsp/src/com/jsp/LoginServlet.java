package com.jsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   /**
		    * 校验验证码
		    * 1.从session中获取正确的验证码
		    * 2.从表单中获取用户填写的验证码
		    * 3.进行比较
		    * 4.如果相同，想下执行；如果不相同;保存错误信息到request域当中，转发到Login.jsp
		    */
		String sessionCode=(String)request.getSession().getAttribute("session_vcode");
		String paramCode=request.getParameter("VertifyCode");
		if(!paramCode.equalsIgnoreCase(sessionCode)){
			request.setAttribute("msg", "验证码错误");
			request.getRequestDispatcher("/session/Login.jsp").forward(request, response);
			return;
		}
       /**
        * 获取表单信息
        */
	   request.setCharacterEncoding("utf-8");
	   String username=request.getParameter("username");
	   String password=request.getParameter("password");
	   /**
	    * 校验用户名与密码
	    */
	   /**
	    * 附加项：把用户名保存到cookie中，发送给客户端浏览器
	    * 当再次打开Login.jsp中时,读取用户名
	    */
	   if("yy".equalsIgnoreCase(username))
	   {
		   /**登陆成功
		    * 1.保存用户信息到session中
		    * 2.重定向到succ1.jsp
		    * 
		    */
		   Cookie cookie=new Cookie("uname",username);
		   cookie.setMaxAge(60*60*24);//设置cookie命长为一天
		   response.addCookie(cookie);
		   
		   HttpSession session=request.getSession();//获取session
		   session.setAttribute("username",username);//向session域中保存用户名
		    response.sendRedirect("/0502jsp/session/succ1.jsp");//重定向到succ1.jsp
	   }
	   else{
		   /**登陆失败
		    * 1.保存错误信息到request域中
		    * 2.转发到Login.jsp
		    */
		   request.setAttribute("msg","用户名或密码错误");
		   RequestDispatcher qr=request.getRequestDispatcher("/session/Login.jsp");//得到转发器
		   qr.forward(request, response);//请求转发  
	   }
	}

}
