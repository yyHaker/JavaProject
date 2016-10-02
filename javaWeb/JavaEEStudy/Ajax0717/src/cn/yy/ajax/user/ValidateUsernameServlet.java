package cn.yy.ajax.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidateUsernameServlet extends HttpServlet {

	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
     List<String> usernames=Arrays.asList("AAA","BBB","CCC");
     String username=request.getParameter("username");
     
     System.out.println(username);
     String result=null;
     if(usernames.contains(username)){
    	 result="<font color='red'>该用户已被注册</font>";
     }else{
    	 result="<font color='green'>该用户可以使用</font>";
     }
      response.setContentType("text/html");
      response.setCharacterEncoding("utf-8");
      response.getWriter().print(result);
		
	}

}
