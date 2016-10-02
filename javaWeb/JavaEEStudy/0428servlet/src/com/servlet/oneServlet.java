package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class oneServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *演示请求转发
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          
           response.setHeader("aaa","AAA");//设置响应头
           response.getWriter().print("hello oneservlet");//设置响应体
           //如果缓存过大，会报异常
//           for(int i=0;i<1024*24;i++){
//        	  response.getWriter().print("a");
//           }
        	   
           //servlet域传输数据
           request.setAttribute("username", "yy");
           
           
           
           //请求转发,留头不留体，等同于twoServlet的service（）方法
//           request.getRequestDispatcher("/twoServlet").forward(request, response);
           //请求包含,留头又留体
         request.getRequestDispatcher("/twoServlet").include(request, response);
           
            System.out.println("oneservlet");
           
		
	}

}
