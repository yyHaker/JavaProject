package cn.itcast.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.mybatis.po.Customer;

public class mybatisFirst {
	@Test
   public void findCustomerByIdTest() throws IOException{
	   
	   //mybatis的配置文件
	   String resource="SqlMapConfig.xml";
	   //得到配置文件流
	   InputStream inputStream=Resources.getResourceAsStream(resource);
	   //1.创建会话工厂，传入mybatis的配置信息
	   SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
	   //2.通过工厂得到SqlSession
	   SqlSession sqlSession=sqlSessionFactory.openSession();
	   //3.通过sqlSession操作数据库
	   //第一个参数:映射文件中statment的id，等于namespace+"."+statement的id
	   //第二个参数:指定和映射文件中parameterType类型的参数
	  Customer customer= sqlSession.selectOne("test.findCustomerByCid","c001");
	  System.out.println(customer);
	  //4.释放资源
	  sqlSession.close();
	  
   }
	@Test
	public void findCustomerByCnameTest() throws IOException{
		//mybatis的配置文件
		   String resource="SqlMapConfig.xml";
		   //得到配置文件流
		   InputStream inputStream=Resources.getResourceAsStream(resource);
		   //1.创建会话工厂，传入mybatis的配置信息
		   SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		   //2.通过工厂得到SqlSession
		   SqlSession sqlSession=sqlSessionFactory.openSession();
		   //3.通过sqlSession操作数据库
		   //第一个参数:映射文件中statment的id，等于namespace+"."+statement的id
		   //第二个参数:指定和映射文件中parameterType类型的参数
		  List<Customer> customerList= sqlSession.selectList("test.findCustomerByCname","n");
		  System.out.println(customerList);
		  //4.释放资源
		  sqlSession.close();
	}
	@Test
	public void insertCustomerTest() throws IOException{
		//mybatis的配置文件
		   String resource="SqlMapConfig.xml";
		   //得到配置文件流
		   InputStream inputStream=Resources.getResourceAsStream(resource);
		   //1.创建会话工厂，传入mybatis的配置信息
		   SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		   //2.通过工厂得到SqlSession
		   SqlSession sqlSession=sqlSessionFactory.openSession();
		   //3.通过sqlSession操作数据库
		   //第一个参数:映射文件中statment的id，等于namespace+"."+statement的id
		   //第二个参数:指定和映射文件中parameterType类型的参数
		   Customer customer=new Customer();
		   customer.setCid("c007");
		   customer.setCname("Lily");
		   customer.setCity("shanghai");
		   customer.setDiscnt(0.8f);
		  sqlSession.insert("test.insertCustomer",customer);
		   //提交事务
		  sqlSession.commit();
		  //4.释放资源
		  System.out.println(customer.getCid());
		  sqlSession.close();
	}
	@Test
	public void deleteCustomerTest() throws IOException{
		//mybatis的配置文件
		   String resource="SqlMapConfig.xml";
		   //得到配置文件流
		   InputStream inputStream=Resources.getResourceAsStream(resource);
		   //1.创建会话工厂，传入mybatis的配置信息
		   SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		   //2.通过工厂得到SqlSession
		   SqlSession sqlSession=sqlSessionFactory.openSession();
		   //3.通过sqlSession操作数据库
		   //第一个参数:映射文件中statment的id，等于namespace+"."+statement的id
		   //第二个参数:指定和映射文件中parameterType类型的参数
		  
		  sqlSession.delete("test.deleteCustomer","c001");
		   //提交事务
		  sqlSession.commit();
		  //4.释放资源
		 
		  sqlSession.close();
	}
	@Test
	public void updateCustomer() throws IOException{
		//mybatis的配置文件
		   String resource="SqlMapConfig.xml";
		   //得到配置文件流
		   InputStream inputStream=Resources.getResourceAsStream(resource);
		   //1.创建会话工厂，传入mybatis的配置信息
		   SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		   //2.通过工厂得到SqlSession
		   SqlSession sqlSession=sqlSessionFactory.openSession();
		   //3.通过sqlSession操作数据库
		   //第一个参数:映射文件中statment的id，等于namespace+"."+statement的id
		   //第二个参数:指定和映射文件中parameterType类型的参数
		   Customer customer=new Customer();
		   customer.setCid("c007");
		   customer.setCname("Lilyhaha");
	       customer.setCity("shanghai");
	      customer.setDiscnt(0.4f);
		  sqlSession.update("test.updateCustomer",customer);
		   //提交事务
		  sqlSession.commit();
		  //4.释放资源
		  System.out.println(customer.getCid());
		  sqlSession.close();
	}
	
} 
