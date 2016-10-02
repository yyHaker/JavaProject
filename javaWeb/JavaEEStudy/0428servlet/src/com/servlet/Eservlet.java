package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Eservlet extends HttpServlet {
   /**
    * 
    */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        /**
         * 若如下处理则为乱码，tomcat8解析get请求编码默认为utf-8(tomcat7解析get请求编码默认为iso-)
         * 1.先获取iso的错误字1符串
         * 2.回退,使用utf-8重编
         * 
         */
	     String username=request.getParameter("username");
//                byte []b=username.getBytes("iso-8859-1");
//                 username=new String(b,"utf-8");
	        System.out.println(username);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//tomcat默认使用iso来处理post请求编码，故需要设置为utf-8
        request.setCharacterEncoding("utf-8");
        System.out.println(request.getParameter("username"));
	}

}
