package cn.yy.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import cn.yy.web.dao.OrderMasterDao;
import cn.yy.web.dao.ProductDao;

public class OrderMasterServlet extends BaseServlet {

	
	OrderMasterDao dao=new OrderMasterDao();
	public String  findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
    
	 request.setAttribute("ordermasterlist",dao.findAllOrderMaster());
		return "OrderMaster.jsp";
	}
	public String  findOrderMasterByParams(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException{
		  request.setAttribute("ordermasterlist", 
				  dao.findOrderMasterByParams(request.getParameter("orderNo"),
						  request.getParameter("customerNo"), 
						  request.getParameter("employeeNo"),
						  request.getParameter("orderDate"),
						  request.getParameter("orderSum"),
						  request.getParameter("invoiceNo")));  
		return "OrderMaster.jsp";
	}
	
	public String  deleteOrderNo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
         if(!request.getParameter("orderNo").trim().isEmpty())
	         dao.deleteOrderMasterByOrderNo(request.getParameter("orderNo"));
         request.setAttribute("ordermasterlist",dao.findAllOrderMaster());
		return "OrderMaster.jsp";
	}
	
	public String  addOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
          ProductDao productdao=new ProductDao();
          productdao.addNewOrder(request.getParameter("productName"),
        		  Integer.parseInt(request.getParameter("quantity")),
        		  request.getParameter("customerNo_1"),request.getParameter("employeeNo"));
		
		 
	 request.setAttribute("ordermasterlist",dao.findAllOrderMaster());
		return "OrderMaster.jsp";
	}
	

}
