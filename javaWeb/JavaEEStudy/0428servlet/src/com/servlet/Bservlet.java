package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Bservlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         /**
          * 使用referer头,来防盗链
          */
		String referer=request.getHeader("Referer");
		System.out.println(referer);
	
		if(referer==null||referer.contains("localhost"))
		{
			System.out.println("hello");
		}
		else 
		{
			response.sendRedirect("http://www.hao123.com");
		}
		
	}

}
