package cn.yy.web.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.yy.web.domain.OrderDetail;

public class OrderDetailDao {
	QueryRunner qr=new TxQueryRunner();
   /**
    * 1.得到所有OrderDetail
 * @throws SQLException 
    */
	public List<OrderDetail> getAllOrderDetail() throws SQLException{
		
		String sql="select * from OrderDetail";
		return qr.query(sql,new BeanListHandler<OrderDetail>(OrderDetail.class));
	}
	/**
	 * 2.按参数查询OrderDetail
	 * @throws SQLException 
	 */
	public List<OrderDetail> getOrderDetailByParams( String orderNo,
     String productNo,String quantity,String  price) throws SQLException{
		
    	StringBuilder sql=new StringBuilder("select * from OrderDetail where 1=1");

    	if(!orderNo.trim().isEmpty()){
    		sql.append(" and orderNo like "+"'%"+orderNo+"%'");
    	}
    	
    	if(!productNo.trim().isEmpty()){
    		sql.append(" and productNo like "+"'%"+productNo+"%'");
    	}
    	
    	if(!quantity.trim().isEmpty()){
    		sql.append(" and quantity = "+Integer.parseInt(quantity));
    	}
    	
    	if(!price.trim().isEmpty()){
    		sql.append(" and price ="+Double.parseDouble(price));
    	}
		return qr.query(sql.toString(),new BeanListHandler<OrderDetail>(OrderDetail.class));
	}
}
