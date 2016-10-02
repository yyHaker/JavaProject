package cn.yy.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

public class UploadServlet1 extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;chatset=utf-8");
		
		ServletInputStream in=request.getInputStream();
		String s=IOUtils.toString(in);
		System.out.println(s);
	}

}
