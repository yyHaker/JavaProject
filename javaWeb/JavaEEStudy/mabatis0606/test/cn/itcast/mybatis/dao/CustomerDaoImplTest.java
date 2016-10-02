package cn.itcast.mybatis.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.po.Customer;

public class CustomerDaoImplTest {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception{
		  //mybatis的配置文件
		   String resource="SqlMapConfig.xml";
		   //得到配置文件流
		   InputStream inputStream=Resources.getResourceAsStream(resource);
		   //1.创建会话工厂，传入mybatis的配置信息
		    sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		   //2.通过工厂得到SqlSession
		 
	}

	@Test
	public void testFindCustomerByCid() throws Exception {
		//创建customerDao对象
		CustomerDao customerDao=new CustomerDaoImpl(sqlSessionFactory);
		//调用customerDao的方法
	  Customer customer=	customerDao.findCustomerByCid("c004");
	  System.out.println(customer);
	}

}
