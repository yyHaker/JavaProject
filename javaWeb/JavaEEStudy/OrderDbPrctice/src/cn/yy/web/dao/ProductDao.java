package cn.yy.web.dao;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import cn.itcast.jdbc.JdbcUtils;
import cn.itcast.jdbc.TxQueryRunner;
import cn.yy.web.domain.OrderMaster;
import cn.yy.web.domain.Product;
 
public class ProductDao { 
	QueryRunner qr=new TxQueryRunner();
	   /**
	    * 1.dao得到所有产品信息
	    * @return List<Product>
	    * @throws SQLException
	    */
	
	
	 public List<Product>   getAllProduct() throws SQLException{
    	
    	 String sql="select * from Product";
    	 List<Product> list =qr.query(sql,new BeanListHandler<Product>(Product.class));
    	 return list;
    	 
     }
	   /**
	    * 2.根据参数查询Product
	    * (多条件组合查询)
	    * @param productNo
	    * @param productName
	    * @param productClass
	    * @param productPrice
	    * @param inStock
	    * @return
	 * @throws SQLException 
	    */
	 public List<Product> getProductByParams( String productNo,String productName,
	    String productClass,String productPrice,String inStock) throws SQLException{
		     /**
		      * 此处我们将productPrice、instock都作为字符串处理，若不为空
		      * 则分别转换为double、int，后拼接sql
		      */
		 
		 StringBuilder sql=new StringBuilder("select * from Product where 1=1");
		 if(!productNo.trim().isEmpty()){
			 sql.append(" and productNo like "+"'%"+productNo+"%'");
		 }
		 if(!productName.trim().isEmpty()){
			 sql.append(" and productName like "+"'%"+productName+"%'");
		 }
		 if(!productClass.trim().isEmpty()){
			 sql.append(" and productClass like "+"'%"+productClass+"%'");
		 }
		 if(!productPrice.trim().isEmpty()){
			// sql.append(" and productNo like "+"'%"+productNo+"%'");
			 sql.append(" and productPrice ="+Double.parseDouble(productPrice));
		 }
		 if(!inStock.trim().isEmpty()){
			// sql.append(" and productNo like "+"'%"+productNo+"%'");
			 sql.append(" and inStock ="+Integer.parseInt(inStock));
		 }
		 
		 return qr.query(sql.toString(), new BeanListHandler<Product>(Product.class));	
	 }
	 
	 /**
	  * 3.编辑Product
	  * @param p
	 * @throws SQLException 
	  */
	 public void editProduct(Product p) throws SQLException{
//		 String productNo;
//		     String productName;
//		    String productClass;
//		   double productPrice;
//		  int inStock;
		
		 String sql="update Product set "
				   +"productName='"+p.getProductName()+"',"
				   +"productClass='"+p.getProductClass()+"',"
				   +"productPrice="+p.getProductPrice()+","
				   +"inStock="+p.getInStock()+
				    " where productNo='"+p.getProductNo()+"'";
		   qr.update(sql);
				  
	 }
	 /**
	  * 通过ProductNo获得Product
	 * @throws SQLException 
	  */
	 public Product getProductByProductNo(String productNo) throws SQLException{
		
		 String sql="select * from Product where productNo="+"'"+productNo+"'";
		 // System.out.println(sql);
		 return qr.query(sql,new BeanListHandler<Product>(Product.class)).get(0);
		
	 }
	 /**
	  * 一.新增订单，需要用户输入商品名称（Product）、订货数量(OrderDetail)(要注意库存)、
	  *    客户编号(Customer.customerNo)、业务员编号(Employee.employeeNo)、
	  * 二.具体步骤
	  *   1.根据productName查询Product表获得库存量inStock、productNo、productPrice,判断OrderDetai.qunatity
	  *      是否小于inStock,若不小于，return
	  *   2.查询OrderMaster.orderNO,生成一个订单编号
	  *   3.insert into OrderDetail  values(orderNo,productNo,quantity,price)
	  *     insert into OrderMaster 
	  *     valus(orderNo,customerNo，OrderMaster.orderDate(获得当前时间),
	  *        orderSum,invoiceNo(生成发票号码))
	 * @throws SQLException 
	  */
	 public void addNewOrder(String productName,int quantity,String customerNo,String employeeNo) throws SQLException{
		QueryRunner qr=new TxQueryRunner();
		String sql1="select * from Product where productName='"+productName+"'";
		Product product=qr.query(sql1,new BeanListHandler<Product>(Product.class)).get(0);
		if(quantity>product.getInStock()){
			return;
		}
		String sql2="select orderNo from OrderMaster";
	    List<OrderMaster> ordermasterlist=qr.query(sql2,new BeanListHandler<OrderMaster>(OrderMaster.class));
	      long []orderNo={0};
	     for (int i = 0; i < ordermasterlist.size(); i++) {
			orderNo[i]=Long.parseLong((ordermasterlist.get(i).getOrderNo()));
		}
	     long maxorder=0;
	     for (int i = 0; i < orderNo.length; i++) {
			if(orderNo[i]>maxorder){
				maxorder=orderNo[i];
			}
		}
	      maxorder=maxorder++;//生成订单编号
	     long []invoiceNo={};
	     for (int i = 0; i < ordermasterlist.size(); i++) {
			invoiceNo[i]=Long.parseLong(((ordermasterlist.get(i).getInvoiceNo())));
		}
	     long maxinvoiceNo=0;
	     for (int i = 0; i < invoiceNo.length; i++) {
			if(invoiceNo[i]>maxinvoiceNo){
				maxinvoiceNo=invoiceNo[i];
			}
		}
	     maxinvoiceNo=maxinvoiceNo++;//生成发票号
	     
	   
	    GregorianCalendar gre=new GregorianCalendar();
   	    String orderdate=gre.get(Calendar.YEAR)+"-"+gre.get(Calendar.MONTH)+"-"+gre.get(Calendar.DAY_OF_MONTH);
   	    JdbcUtils.beginTransaction();
	    String sql3="insert into OrderMaster values("+"'"+maxorder+"','"+customerNo+"','"+employeeNo+"','"+orderdate+"','"+quantity*product.getProductPrice()+"','"+maxinvoiceNo+"'"+")";
	     qr.update(sql3);
	     String sql4="insert into OrderDetail values('"+maxorder+"','"+product.getProductNo()+"','"+quantity+"','"+product.getProductPrice()+"'"+   ")";
	     qr.update(sql4);
	    JdbcUtils.commitTransaction();
	 }
}
