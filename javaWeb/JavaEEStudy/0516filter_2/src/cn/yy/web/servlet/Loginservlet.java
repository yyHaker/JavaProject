package cn.yy.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Loginservlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            String username=request.getParameter("username");
            if(username.contains("yy")){
            	request.getSession().setAttribute("admin",username);
            }else if(username.contains("user")){
            	request.getSession().setAttribute("user", username);
            }
            request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
