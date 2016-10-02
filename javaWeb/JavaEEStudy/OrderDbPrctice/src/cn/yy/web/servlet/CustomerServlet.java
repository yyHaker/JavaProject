package cn.yy.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import cn.yy.web.dao.CustomerDao;
import cn.yy.web.domain.Customer;

public class CustomerServlet extends BaseServlet {

	CustomerDao dao =new CustomerDao();
	public String  findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
     /**
      * 1.得到所有Customer
      * 2.保存到request域
      * 3.转发到“Customer.jsp”
      */
	 request.setAttribute("customerlist",dao.getAllCustomer());
		return "Customer.jsp";
	}
//  @Override
//protected void doPost(HttpServletRequest requset, HttpServletResponse response)
//		throws ServletException, IOException {
////               String customerNo;
////               String customerName;
////               String telephone;
////               String address;
////               String zip;
//               Customer c=new Customer(requset.getParameter("customerNo"),
//            		                  requset.getParameter("customerName"),
//            		                  requset.getParameter(""));
//}
	public String  findCustomerByParams(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException{
		  request.setAttribute("customerlist", 
				  dao.getCustomerByParams(request.getParameter("customerNo"),
						  request.getParameter("customerName"), 
						  request.getParameter("telephone"),
						  request.getParameter("address"),
						  request.getParameter("zip")));  
		return "Customer.jsp";
	}
	
	public String  editCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException{
		     Customer c=dao.getCustomerByCustomerNo(request.getParameter("customerNo"));
				String customerName=request.getParameter("customerName");
		        String telephone=request.getParameter("telephone");
		        String address=request.getParameter("address");
		        String zip=request.getParameter("zip");
		        if(!customerName.trim().isEmpty()){
		        	c.setCustomerName(customerName);
		        }
		        if(!telephone.trim().isEmpty()){
		        	c.setTelephone(telephone);
		        }
		        if(!address.trim().isEmpty()){
		        	c.setAddress(address);
		        }
		        if(!zip.trim().isEmpty()){
		        	c.setZip(zip);
		        }
		        dao.editCustomer(c);
		        request.setAttribute("customerlist",dao.getAllCustomer());
		return "Customer.jsp";
	}
}
