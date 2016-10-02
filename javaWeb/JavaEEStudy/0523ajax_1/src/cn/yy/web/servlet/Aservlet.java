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
         System.out.println("hello ajax!");
         response.getWriter().println("Hello Ajax!");
	}

	public  void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    request.setCharacterEncoding("utf-8");
		    response.setContentType("text/html;charset=utf-8");
		    //获取请求参数
		    String username=request.getParameter("username");
		    System.out.println("post:"+"hello ajax"+username);
		    response.getWriter().println("post:"+"hello ajax"+username);
	}

}
