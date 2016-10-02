package com.jsp;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.image.VerifyCode;

public class VerifySevlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            /**
             * 1.生成图片
             * 2.保存图片上的文本到session中
             * 3.把图片响应给客户端
             */
	 VerifyCode vc=new VerifyCode();
	 BufferedImage image=vc.getImage();
	 request.getSession().setAttribute("session_vcode",vc.getText());
	 VerifyCode.output(image,response.getOutputStream());
	}

}
