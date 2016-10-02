package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cservlet extends HttpServlet {

	/**
	 * 演示request获取请求参数
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        
	    System.out.println("Get:"+request.getParameter("xxx"));
	    System.out.println("Get:"+request.getParameter("yyy"));
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         String username=request.getParameter("username");
         String password=request.getParameter("password");
         String[] hobby=request.getParameterValues("hobby");
         System.out.println(username+","+password+","+Arrays.toString(hobby));
         
         //打印所有参数名称,为什么 会顺序乱了
         Enumeration er=request.getParameterNames();
         while(er.hasMoreElements())
         {
        	 System.out.println(er.nextElement());
         }
         //获取所有参数,封装到map当中
         Map<String,String[]> map=request.getParameterMap();
         //System.out.println(map);
         for(String name:map.keySet()){
        	 String[] values=map.get(name);
        	 System.out.println(name+"="+Arrays.toString(values));
         }
	}

}
