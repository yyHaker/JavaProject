package cn.yy.sqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import com.mysql.jdbc.Driver;
/**
 * jdbc连接到mysql数据库
 * 1.加载驱动类
 * 2.使用url、username、password、得到连接对象
 * 
 * @author 57217
 *
 */
public class SqlDemo1 {
  @Test
  public void ConnectToMysql(){
	  /**
	   * jdbc四大参数
	   * driverClassName:com.mysql.jdbc.Driver
	   * url:jdbc:mysql://localhost:3306/数据库名
	   * username:root
	   * password:123456
	   */
	  /**
	   * 1.所有的java.sql.Driver实现类，都提供了static块，块内的代码都把自己注册到DriverManage中
	   * 2.jdbc4.0之后，每个驱动jar包中，在META-INF目录下提供了一个名为java.sql.Driver的文件，文件
	   *   的内容就是实现该接口的类的类名称
	   * 3.为了兼容老版本的jdbc，最好加上以下代码
	   *    Class.forName("com.mysql.jdbc.Driver");
	   * 
	   */
	  try {
		  /*
		   * 1.加载驱动类(注册驱动)
		   */
		  //注册driver
//		  com.mysql.jdbc.Driver driver=new com.mysql.jdbc.Driver();
//		  DriverManager.registerDriver(driver);
	     Class.forName("com.mysql.jdbc.Driver");
	  
		/**
		 * 2.使用url、username、password、得到连接对象
		 */
	  String url="jdbc:mysql://localhost:3306/workermanage";
	  String username="root";
	  String password="123456";

	  Connection con=DriverManager.getConnection(url, username, password);
	  System.out.println(con);
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
  }
}
