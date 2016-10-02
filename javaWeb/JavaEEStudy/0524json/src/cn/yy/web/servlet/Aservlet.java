package cn.yy.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Aservlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.setContentType("text/html;charset=utf-8");
       /**
        * 向客户端发送json字符串
        */
		String str="{\"name\":\"yy\",\"age\":18,\"sex\":\"male\"}";
		response.getWriter().println(str);
		System.out.println(str);
	}

}
