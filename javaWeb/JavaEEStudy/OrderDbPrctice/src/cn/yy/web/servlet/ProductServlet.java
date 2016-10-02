package cn.yy.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import cn.yy.web.dao.ProductDao;
import cn.yy.web.domain.Customer;
import cn.yy.web.domain.Product;

public class ProductServlet extends BaseServlet {

	ProductDao dao=new ProductDao();
	public String findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
	   request.setAttribute("productlist",dao.getAllProduct());
		return "Product.jsp";
	}
	public String  findProductByParams(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException{
		  request.setAttribute("productlist", 
				  dao.getProductByParams(request.getParameter("productNo"),
						  request.getParameter("productName"), 
						  request.getParameter("productClass"),
						  request.getParameter("productPrice"),
						  request.getParameter("inStock")
						  ));  
		return "Product.jsp";
	}
	
	public String  editProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException{
		     Product  p=dao.getProductByProductNo(request.getParameter("productNo"));
		     String productName=request.getParameter("productName");
		     String productClass=request.getParameter("productClass");
		    String  productPrice=request.getParameter("productPrice");
		    String  inStock=request.getParameter("inStock");
		       if(!productName.trim().isEmpty()){
		    	   p.setProductName(productName);
		       }
		       if(!productClass.trim().isEmpty()){
		    	   p.setProductClass(productClass);
		       }
		       if(!productPrice.trim().isEmpty()){
		    	   p.setProductPrice(Double.parseDouble(productPrice));
		       }
		       if(!inStock.trim().isEmpty()){
		    	   p.setInStock(Integer.parseInt(inStock));
		       }
		        dao.editProduct(p);
		        request.setAttribute("productlist",dao.getAllProduct());
		return "Product.jsp";
	}
	
	
}
