package cn.yy.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import cn.yy.web.dao.CustomerDao;
import cn.yy.web.dao.EmployeeDao;
import cn.yy.web.domain.Customer;
import cn.yy.web.domain.Employee;

public class EmployeeServlet extends BaseServlet {
              EmployeeDao dao =new EmployeeDao();
	
	
		public String  findAll(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException, SQLException {
		 request.setAttribute("employeelist",dao.getAllEmployee());
			return "Employee.jsp";
		}
		
		public String  findEmployeeByParams(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException, SQLException{
			  request.setAttribute("employeelist",
					  dao.getEmployeeByParams(request.getParameter("employeeNo"),
						request.getParameter("employeeName"),
						request.getParameter("gender"),
						request.getParameter("birthday"),
						request.getParameter("address"), 
						request.getParameter("telephone"),
						request.getParameter("hireDate"),
						request.getParameter("department"),
						request.getParameter("headShip"),
						request.getParameter("salary")));
					      
			return "Employee.jsp";
		}
		public String  editEmployee(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException, SQLException{
			     Employee e=dao.getEmployeeByEmployeeNo(request.getParameter("employeeNo"));
 		          
			      String employeeName=request.getParameter("employeeName");
			      String gender=request.getParameter("gender");
			      String birthday=request.getParameter("birthday");
			      String address=request.getParameter("address");
			      String telephone=request.getParameter("telephone");
			      String hireDate=request.getParameter("hireDate");	
			      String department=request.getParameter("department");
			      String headShip=request.getParameter("headShip");
			      String  salary=request.getParameter("salary");
			    		
			      if(!employeeName.trim().isEmpty()){
			    	  e.setEmployeeName(employeeName);
			      }
			      if(!gender.trim().isEmpty()){
			    	  e.setGender(gender);
			      }
			      if(!birthday.trim().isEmpty()){
			    	  e.setBirthday(birthday);
			      }
			      if(!address.trim().isEmpty()){
			    	  e.setAddress(address);
			      }
			      if(!telephone.trim().isEmpty()){
			    	  e.setTelephone(telephone);
			      }
			      if(!hireDate.trim().isEmpty()){
			    	  e.setHireDate(hireDate);
			      }
			      if(!department.trim().isEmpty()){
			    	  e.setDepartment(department);
			      }
			      if(!headShip.trim().isEmpty()){
			    	  e.setHeadShip(headShip);
			      }
			      if(!salary.trim().isEmpty()){
			    	  e.setSalary(Double.parseDouble(salary));
			      }
			        
			        dao.editEmployee(e);
			        request.setAttribute("employeelist",dao.getAllEmployee());
			return "Employee.jsp";
		}	

}
