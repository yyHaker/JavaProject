package cn.yy.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import cn.yy.web.dao.OrderDetailDao;

public class OrderDetailServlet extends BaseServlet {

	OrderDetailDao dao=new OrderDetailDao();
	public String  findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
	 request.setAttribute("orderdetaillist",dao.getAllOrderDetail());
		return "OrderDetail.jsp";
	}
	
	public String  findOrderDetailByParams(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException{
		  request.setAttribute("orderdetaillist", 
				  dao.getOrderDetailByParams(
						  request.getParameter("orderNo"), 
						  request.getParameter("productNo"),
						  request.getParameter("quantity"),
						  request.getParameter("price")));  
		return "OrderDetail.jsp";
	}

}
