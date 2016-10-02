package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Aservlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *获取客户端的ip地址、请求方式、获取user-agent
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//             String add=request.getRemoteAddr();//获取客户端的ip地址
//             System.out.println("ip:"+add);
//             System.out.println("请求方式："+request.getMethod());
//             System.out.println("userAgent:"+request.getHeader("User-Agent"));
		/**
		 * 通过request获取url的相关方法
		 */
		      response.getWriter().print(request.getScheme()+"<br>");//获取请求协议
		      response.getWriter().print(request.getServerName()+"<br>");//获取服务器名称
		      response.getWriter().print(request.getServerPort()+"<br>");//获取服务器端口号
		      response.getWriter().print(request.getContextPath()+"<br>");//获取项目名称
		      response.getWriter().print(request.getServletPath()+"<br>");//获取servlet路径
		      response.getWriter().print(request.getQueryString()+"<br>");//获取参数
		      response.getWriter().print(request.getRequestURI()+"<br>");//获取requesturi
		      response.getWriter().print(request.getRequestURL()+"<br>");
             
	}

}
