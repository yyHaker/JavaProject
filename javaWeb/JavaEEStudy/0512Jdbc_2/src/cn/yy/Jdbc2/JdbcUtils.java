package cn.yy.Jdbc2;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
 /**
  * 使用连接池连接到数据库的类
  * @author 57217
  *版本2.0
  */
public class JdbcUtils {
	/**
	 * 使用连接池返回一个连接对象
	 */
	//使用配置文件的默认配置，要求必须给出c3p0-config.xml
	private static ComboPooledDataSource dataSource=new ComboPooledDataSource();
   public static Connection getConnection() throws SQLException{
	   
	   return dataSource.getConnection();  
	   }
   /**
    * 返回连接池对象
    * @return
    */
   public static DataSource getDataSource(){
	   return dataSource;
   }
}
