package cn.yy.web.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import cn.itcast.jdbc.TxQueryRunner;

public class CustomerOrderDao {
	public List<Map<String,Object>> searchCustomerOrder(String customerNo,String customerName,String productName) throws SQLException
	{
		 QueryRunner qr=new TxQueryRunner();
	     StringBuilder sql=new StringBuilder("select Customer.customerNo,Customer.customerName,"
	     		+ "OrderMaster.orderNo,OrderMaster.orderDate,"+
	  "OrderMaster.orderSum,OrderDetail.price,OrderDetail.quantity,Product.productNo,Product.productName"+  
	  " from Customer,OrderMaster,OrderDetail,Product"+
	  " where Customer.customerNo=OrderMaster.customerNo and"+
	" OrderMaster.orderNo=OrderDetail.orderNo and OrderDetail.productNo=Product.productNo");
	     if(!customerNo.trim().isEmpty()){
	     	sql.append(" and Customer.customerNo='"+customerNo+"'");
	     }
	     if(!customerName.trim().isEmpty()){
	     	sql.append(" and Customer.customerName like '%"+customerName+"%'");
	     }
	     if(!productName.trim().isEmpty()){
	    	 sql.append(" and Product.productName like '%"+productName+"%'");
	     }
	    

		List<Map<String, Object>> maplist=qr.query(sql.toString(),new MapListHandler());
		return maplist;
	}
}
