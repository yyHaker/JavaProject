package cn.yy.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.Test;

import cn.itcast.jdbc.TxQueryRunner;

public class Test1 {
	@Test
	   public void fun1(){
		   String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
	         // 连接服务器和数据库sample
	         String dbURL = "jdbc:sqlserver://localhost:1433;"
	         		+ "DatabaseName=CAP";
	         String username="sa";
	         String password="yy13418048969";
	         
	         try {
	             Class.forName(driverName);
	             Connection   dbConn = DriverManager.getConnection(dbURL, username, password);
	             System.out.println(dbConn);
	             System.out.println("Connection Successful!"); // 如果连接成功
	                                                             // 控制台输出Connection
	             // Successful!
	         } catch (Exception e) {
	             e.printStackTrace();
	         }
	   }
	
       @Test  
     public void fun2() throws SQLException{
    	 QueryRunner qr=new TxQueryRunner();
    	 String sql="select * from Customer";
    	List<Map<String, Object>> productList=qr.query(sql,new MapListHandler());
    	 System.out.println(productList);
     }
     @Test
     public void fun3(){
    	 GregorianCalendar gre=new GregorianCalendar();
    	 String orderdate=gre.get(Calendar.YEAR)+"-"+gre.get(Calendar.MONTH)+"-"+gre.get(Calendar.DAY_OF_MONTH);
    	 System.out.println(orderdate);
     }
}
