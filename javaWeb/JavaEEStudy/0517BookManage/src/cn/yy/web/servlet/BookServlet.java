package cn.yy.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import cn.yy.web.dao.BookDao;

public class BookServlet extends BaseServlet {
      private BookDao bookdao=new BookDao();
      
    public String findAll(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	request.setAttribute("booklist", bookdao.findAll());
    	return "/Show.jsp";
    }
    
    
    public String findByCategory(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	
    	String value=request.getParameter("category");
    	int category=Integer.parseInt(value);
    	request.setAttribute("booklist",bookdao.findByCategory(category));
    	return "/Show.jsp";
    
    	
    }
}
