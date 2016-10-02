package cn.yy.web.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.yy.web.domain.Employee;

public class EmployeeDao {
	QueryRunner qr=new TxQueryRunner();
	/**
	 * 1.得到所有Employee
	 * @return
	 * @throws SQLException
	 */
     public List<Employee> getAllEmployee() throws SQLException{
    	 
    	 String sql="select * from Employee";
    	 return qr.query(sql, new BeanListHandler<Employee>(Employee.class));
     }
     /**
      * 2.按参数查询Employee
      * @return
     * @throws SQLException 
      */
     public List<Employee> getEmployeeByParams(String employeeNo,String employeeName,
    String gender,String birthday,String address,String telephone,
    String hireDate,String department,
    String headShip,String salary) throws SQLException{
    	 /**
    	  * 此处salary用字符串传入,若不为空再转换为double
    	  */
    	
    	 StringBuilder sql=new StringBuilder("select * from Employee where 1=1");
    	 if(!employeeNo.trim().isEmpty()){
     		sql.append(" and employeeNo like "+"'%"+employeeNo+"%'");
     	}
    	 if(!employeeName.trim().isEmpty()){
    		 sql.append(" and employeeName like "+"'%"+employeeName+"%'");
    	 }
    	 if(!gender.trim().isEmpty()){
    		 sql.append(" and gender like "+"'%"+gender+"%'");
    	 }
    	 if(!birthday.trim().isEmpty()){
    		 sql.append(" and birthday like "+"'%"+birthday+"%'");
    	 }
    	 if(!address.trim().isEmpty()){
    		 sql.append(" and address like "+"'%"+address+"%'");
    	 }
    	 if(!telephone.trim().isEmpty()){
    		 sql.append(" and telephone like "+"'%"+telephone+"%'");
    	 }
    	 if(!hireDate.trim().isEmpty()){
    		 sql.append(" and hireDate like "+"'%"+hireDate+"%'");
    	 }
    	 if(!department.trim().isEmpty()){
    		 sql.append(" and department like "+"'%"+department+"%'");
    	 }
    	 if(!headShip.trim().isEmpty()){
    		 sql.append(" and headShip like "+"'%"+headShip+"%'");
    	 }
    	 if(!salary.trim().isEmpty()){
    		 sql.append(" and salary = "+Double.parseDouble(salary));
    	 }
    	
    	return qr.query(sql.toString(),new BeanListHandler<Employee>(Employee.class));
     }
     
     /**
      * 3.编辑Employee
     * @throws SQLException 
      */
     public void editEmployee(Employee e) throws SQLException{
//    	 String employeeNo,String employeeName,
//    	    String gender,String birthday,String address,String telephone,
//    	    String hireDate,String department,
//    	    String headShip,double salary
    	
    	 String sql="update Employee set employeeName='"+e.getEmployeeName()+"',"
    			 +"gender='"+e.getGender()+"',"
    			 +"birthday='"+e.getBirthday()+"',"
    			 +"address='"+e.getAddress()+"',"
    			 +"telephone='"+e.getTelephone()+"',"
    			 +"hireDate='"+e.getHireDate()+"',"
    			 +"department='"+e.getDepartment()+"',"
    			 +"headShip='"+e.getHeadShip()+"',"
    			 +"salary="+e.getSalary()
    			 +" where employeeNo='"+e.getEmployeeNo()+"'";
    	 qr.update(sql);
     }
     /**
      * 4.通过employeeNo获得employee信息
     * @throws SQLException 
      */
     public Employee getEmployeeByEmployeeNo(String employeeNo) throws SQLException{
    	
    	 String sql="select * from Employee where employeeNo='"+employeeNo+"'";
    	 return qr.query(sql,new BeanListHandler<Employee>(Employee.class)).get(0);
     }
}
