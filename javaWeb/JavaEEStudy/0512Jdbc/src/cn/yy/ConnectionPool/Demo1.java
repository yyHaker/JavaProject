package cn.yy.ConnectionPool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

/**
 * DBCP连接池
 * @author cxf
 *
 */
public class Demo1 {
	@Test
	public void fun1() throws SQLException {
		/*
		 * 1. 创建连接池对象
		 * 2. 配置四大参数
		 * 3. 配置池参数
		 * 4. 得到连接对象
		 */
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/CAP");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		
		dataSource.setMaxActive(20);
		dataSource.setMinIdle(3);
		dataSource.setMaxWait(1000);
		
		Connection con = dataSource.getConnection();
		//Connection con1 = new MyConnection(con);
		System.out.println(con.getClass().getName());
		
		/**
		 * 连接池内部使用四大参数创建了连接对象！即mysql驱动提供的Connection
		 * 连接池使用mysql的连接对象进行了装饰，只对close()方法进行了增强！
		 * 装饰之后的Connection的close()方法，用来把当前连接归还给池！
		 */
		con.close();//把连接归还给池！
	}
}

class MyInputStream extends InputStream {
	private InputStream in;
	private int key;
	
	public MyInputStream(InputStream in, int key){
		this.in = in;
		this.key = key;
	}

	@Override
	public int read() throws IOException {
		return this.in.read() - key;
	}
}