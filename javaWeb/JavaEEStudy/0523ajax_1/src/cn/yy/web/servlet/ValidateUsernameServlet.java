package cn.yy.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidateUsernameServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      String username=request.getParameter("username");
      if(username.equalsIgnoreCase("yy")){
    	  response.getWriter().print("1");
      }else{
    	  response.getWriter().print("0");
      }
	
	}

}
