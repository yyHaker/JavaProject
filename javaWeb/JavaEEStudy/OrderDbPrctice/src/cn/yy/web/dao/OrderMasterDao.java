package cn.yy.web.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.JdbcUtils;
import cn.itcast.jdbc.TxQueryRunner;
import cn.yy.web.domain.OrderMaster;

public class OrderMasterDao {
	QueryRunner qr=new TxQueryRunner();
	/**
	 * 1.得到所有OrderMaster
	 * @return
	 * @throws SQLException
	 */
	
     public  List<OrderMaster>   findAllOrderMaster() throws SQLException{
    	
    	 String sql="select * from OrderMaster";
    	 return qr.query(sql, new BeanListHandler<OrderMaster>(OrderMaster.class));
     }
     /**
      * 2.按提供参数查询OrderMaster
     * @throws SQLException 
      */
     public List<OrderMaster> findOrderMasterByParams(String orderNo,
     String customerNo,String employeeNo,String orderDate,
     String orderSum,String invoiceNo) throws SQLException{
    	
     	 StringBuilder sql=new StringBuilder("select * from OrderMaster where 1=1");
     	if(!orderNo.trim().isEmpty()){
    		sql.append(" and orderNo like "+"'%"+orderNo+"%'");
    	}
     	if(!customerNo.trim().isEmpty()){
     		sql.append(" and customerNo like "+"'%"+customerNo+"%'");
     	}
     	if(!employeeNo.trim().isEmpty()){
     		sql.append(" and customerNo like "+"'%"+employeeNo+"%'");
     	}
     	if(!orderSum.trim().isEmpty()){
     		sql.append(" and orderSum = "+Double.parseDouble(orderSum));
     	}
     	if(!invoiceNo.trim().isEmpty()){
     		sql.append(" and invoiceNo like "+"'%"+invoiceNo+"%'");
     	}
    	return qr.query(sql.toString(),new BeanListHandler<OrderMaster>(OrderMaster.class));
     }
     
        public void deleteOrderMasterByOrderNo(String OrderNo) throws SQLException{
        	QueryRunner qr=new TxQueryRunner();
        	JdbcUtils.beginTransaction();
        	String sql1="delete from OrderDetail where OrderNo='"+OrderNo+"'";
    	     String sql2="delete from OrderMaster where OrderNo='"+OrderNo+"'";
    	      qr.update(sql1);
    	      qr.update(sql2);
    	     JdbcUtils.commitTransaction(); 
       }
}
