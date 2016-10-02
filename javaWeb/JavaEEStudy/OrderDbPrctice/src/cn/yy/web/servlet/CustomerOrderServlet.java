package cn.yy.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;

import cn.itcast.jdbc.TxQueryRunner;
import cn.itcast.servlet.BaseServlet;
import cn.yy.web.dao.CustomerOrderDao;

public class CustomerOrderServlet extends BaseServlet {

	   CustomerOrderDao dao=new CustomerOrderDao();
	public String searchCustomerOrderInfor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
       request.setAttribute("customerOrderList",
    		   dao.searchCustomerOrder(request.getParameter("customerNo"),
    				request.getParameter("customerName"),
    				  request.getParameter("productName")));
		return "/CustomerOrder.jsp";
	}

}
