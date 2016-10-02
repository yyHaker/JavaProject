package cn.yy.sqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;


/**
 * 第一个实例
 *  >连接数据库，实现增删改查
 * @author 57217
 *
 */
public class sqlDemo2 {
    @Test
    public void ConnectionToMysql(){
    	String driverClassName="com.mysql.jdbc.Driver";
    	/**
    	 * 1.jdbc协议的格式! jdbc:工商的名称:子协议(由工商自己决定)
    	 * 2.对于mysql而言,他的子协议结构:  //主机：端口号/数据库名称
    	 */
    	String url="jdbc:mysql://localhost:3306/CAP";
    	String username="root";
    	String password="123456";
    	
       try {
    		
    		Class.forName(driverClassName);
			Connection con=DriverManager.getConnection(url, username, password);
//			System.out.println(con);
	     /**
	      * 二.对数据库增删改查
	      *  1.通过connection对象创建Statement
	      *   >Statement语句的发送器，他的功能就是向数据库发送sql语句!
	      *  2.调用它的int excuteUpdate(String url),它可以发送DML,DDL
	      *  
	      */
			//1.通过Connection对象创建Statment
		 Statement stmt=con.createStatement();	
            //2.使用statement发送sql语句
		 String sql="insert into Agent values('a05','Haker','Beijing',0.6)";
		 
		 int r=stmt.executeUpdate(sql);
		     System.out.println(r);
		 
		     
		     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    }
    
    /**
     * 第二个实例：查询数据库
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Test
    public void ConnectionToMysql2() throws ClassNotFoundException, SQLException{
    	/**
    	 * 执行查询
    	 */
    	/**
    	 * 1.连接数据库
    	 */
    	String driverClassName="com.mysql.jdbc.Driver";
    	String url="jdbc:mysql://localhost:3306/CAP";
    	String username="root";
    	String password="123456";
    	Class.forName(driverClassName);
    	Connection con=DriverManager.getConnection(url, username, password);
    	/**
    	 * 2.得到Statement，执行select语句
    	 *   >得到Statement对象,Connection的CreateStatment()方法
    	 * 
    	 */
    	Statement stm=con.createStatement();
    	/**
    	 * 3.调用Statement的ResultSet rs=excuteQuery(String QuerySql)
    	 */
    	String sql="select * from Agent";
    	ResultSet result=stm.executeQuery(sql);
    	/**
    	 * 解析ResultSet
    	 * 1.把行光标移动刀第一行，调用boolean next()方法(把光标移向下一行，并判断下一行是否存在)
    	 */
//    	System.out.println(result);
    	while (result.next()) {
			String aid=result.getString("aid");
			String aname=result.getString("aname");
			String city=result.getString("city");
			float persent=result.getFloat("persent");
			
			System.out.println(aid+" "+aname+" "+city+" "+persent);
		}
    	/**
    	 * 四.关闭数据库
    	 *  >倒着顺序关闭
    	 */
    	result.close();
    	stm.close();
    	con.close();
    }
    /**
     * 连接数据库规范化写法
     */
    @Test
    public void ConnectionToMysql3() {
    	//定义引用
    	Connection con=null;
    	Statement stmt=null;
    	ResultSet rs=null;
    			
    	try {
    		/**
    		 * 1.连接数据库
    		 */
    	String driverClassName="com.mysql.jdbc.Driver";
    	String url="jdbc:mysql://localhost:3306/CAP";
    	String username="root";
    	String password="123456";
    		
			Class.forName(driverClassName);
			con=DriverManager.getConnection(url, username, password);
			/**
			 * 2.创建statement
			 */
			stmt=con.createStatement();
		    String sql="select * from Agent";
		    rs=stmt.executeQuery(sql);
		    
		    /**
		     * 3.循环遍历rs，打印其中数据
		     */
//		    while(rs.next()){
//		    	String aid=rs.getString("aid");
//				String aname=rs.getString("aname");
//				String city=rs.getString("city");
//				float persent=rs.getFloat("persent");
//				
//				System.out.println(aid+" "+aname+" "+city+" "+persent);	
//		    }
		    /**
		     * >不知结果集的情况下来输出结果
		     */
		    int count=rs.getMetaData().getColumnCount();
		     while(rs.next()){
		    	 for (int i = 1; i <=count; i++) {
					System.out.print(rs.getString(i));
					if(i<count) {
						System.out.print(",");
					}
				}
		    	 System.out.println();
		     }
		} catch (Exception e) {
			 throw new RuntimeException(e);
			 
		}finally{
			//关闭
			  try {
				if(rs!=null)rs.close();
				if(stmt!=null) stmt.close();
	            if(con!=null)  con.close();
			   } catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
    	
    }
    /**
     * 防止sql攻击写法
     */
    @Test
    public void ConnectionToMysql4() {
    	//定义引用
    	Connection con=null;
    	PreparedStatement pstmt=null;
    	ResultSet rs=null;	
    	try {
    		/**
    		 * 1.连接数据库
    		 */
    	String driverClassName="com.mysql.jdbc.Driver";
    	String url="jdbc:mysql://localhost:3306/UserLogin";
    	String username="root";
    	String password="123456";
    		
		Class.forName(driverClassName);
		con=DriverManager.getConnection(url, username, password);
			/**
			 * 2.得到PrepareStatement
			 *  >给出sql模板，所有参数用?代替
			 *  >调用Connection方法,得到PrepareStatement
			 *  
			 */
String sql="select * from userinformation where username=? and password=?";
		 pstmt=con.prepareStatement(sql);
		    /**
		     * >为参数赋值
		     */
		pstmt.setString(1,"yyy");//给第一个问号赋值
		pstmt.setString(2,"123");//给第二个问号赋值
		
	    rs=pstmt.executeQuery();//调用查询方法，向数据库发送查询语句
	    
	   // System.out.println(sql);
	    System.out.println(rs.next()); 
//	    while(rs.next()){
//	    	System.out.println(rs.getString(0)+" "+rs.getString(1));
//	    }
		
		} catch (Exception e) {
			 throw new RuntimeException(e);
			 
		}finally{
			//关闭
			  try {
				if(rs!=null)rs.close();
				if(pstmt!=null) pstmt.close();
	            if(con!=null)  con.close();
			   } catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
    	
    }
}
