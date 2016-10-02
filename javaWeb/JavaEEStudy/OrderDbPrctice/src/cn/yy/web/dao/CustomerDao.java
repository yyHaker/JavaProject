package cn.yy.web.dao;

import java.sql.SQLException;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.yy.web.domain.Customer;

/**
 * 提供各种查询方法
 * @author 57217
 * @param <T>
 *
 */
public class CustomerDao {
	QueryRunner qr=new TxQueryRunner();
	/**
	 * 1.dao得到所有顾客
	 * @return list<Customer>
	 * @throws SQLException
	 */
     public List<Customer>   getAllCustomer() throws SQLException{
    	 
    	 String sql="select * from Customer";
    	 List<Customer> list =qr.query(sql,new BeanListHandler<Customer>(Customer.class));
    	 return list;
    	 
     }
     /**
      * 2.dao按提供的参数查询Customer
      * （多条件组合查询）
     * @throws SQLException 
      */
    public List<Customer>  getCustomerByParams(String customerNo,String customerName,
       String telephone,String address,String zip) throws SQLException
    {
    	
    	StringBuilder sql=new StringBuilder("select * from Customer where 1=1");
    	
    	//List<Object> params=new ArrayList<Object>();
    	
    	if(!customerNo.trim().isEmpty()){
    		sql.append(" and customerNo like "+"'%"+customerNo+"%'");
    		//params.add(customerNo);
    	}
    	if(!customerName.trim().isEmpty()){
    		sql.append(" and customerName like "+"'%"+customerName+"%'");
    		
    	}
    	if(!telephone.trim().isEmpty()){
    		sql.append(" and telephone like "+"'%"+telephone+"%'");
    		//params.add("%"+telephone+"%");
    	}
    	if(!address.trim().isEmpty()){
    		sql.append(" and address like "+"'%"+address+"%'");
    		//params.add("%"+address+"%");
    	}
    	if(!zip.trim().isEmpty()){
    		sql.append(" and zip like "+"'%"+zip+"%'");
    		//params.add("%"+zip+"%");
    	}
    	return qr.query(sql.toString(),new BeanListHandler<Customer>(Customer.class));
    
    }
    /**
     * 3.按编号删除Customer
     * @throws SQLException 
     */
    public void deleteCustomerByCustomerNo(String customerNo) throws SQLException{
    	
    	String sql="delete from Customer where customerNo=?";
    	Object []params={customerNo};
    	qr.update(sql, params);
    }
    /**
     * 4.增加Customer
     * @throws SQLException 
     */
    public void addCustomer(Customer c) throws SQLException{
    	
    	String sql="insert into Customer values(?,?,?,?,?)";
    	Object []params={c.getCustomerNo(),c.getCustomerName(),
    			c.getTelephone(),c.getAddress(),c.getZip()};
    	qr.update(sql, params);
    }
    /**
     * 5.编辑Customer
     * @throws SQLException 
     */
    public void editCustomer(Customer c) throws SQLException{
    	
    	String sql="update Customer set customerName='"+c.getCustomerName()+"',"
    			+ "telephone='"+c.getTelephone()+"',"
    			+ "address='"+c.getAddress()+"',"
    			+ "zip='"+c.getZip()+"'"
    			+ " where customerNo='"+c.getCustomerNo()+"'";
//    	Object []params={c.getCustomerName(),c.getTelephone(),
//    			c.getAddress(),c.getZip(),c.getCustomerNo()};
    	qr.update(sql);
    }
    /**
     * 6.通过id获得Customer
     * @throws SQLException 
     */
    public Customer getCustomerByCustomerNo(String customerNo) throws SQLException{
    	
    	String sql="select * from Customer where customerNo="+"'"+customerNo+"'";
    	return qr.query(sql, new BeanListHandler<Customer>(Customer.class)).get(0);
    }
}
