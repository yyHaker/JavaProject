package cn.itcast.mybatis.mapper;


import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.mapper.OrderCustomMapper;
import cn.itcast.mybatis.po.Orders;
import cn.itcast.mybatis.po.OrdersCustom;
import cn.itcast.mybatis.po.User;

public class OrderCustomMapperTest {

	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception {
		  //mybatis的配置文件
		   String resource="SqlMapConfig.xml";
		   //得到配置文件流
		   InputStream inputStream=Resources.getResourceAsStream(resource);
		   //1.创建会话工厂，传入mybatis的配置信息
		    sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		 
	}

	@Test
	public void testFindOrdersUser() throws Exception {
		 //2.通过工厂得到SqlSession
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//创建OrderCustomMapper,mybatis自动生成mapper代理对象
		OrderCustomMapper orderCustomMapper=sqlSession.getMapper(OrderCustomMapper.class);
		//调用mapper方法
		List<OrdersCustom> list=orderCustomMapper.findOrdersUser();
		System.out.println(list);
       sqlSession.close();
		
	}
	@Test
	public void testFindUser() throws Exception{
		    //2.通过工厂得到SqlSession
				SqlSession sqlSession=sqlSessionFactory.openSession();
				//创建OrderCustomMapper,mybatis自动生成mapper代理对象
				OrderCustomMapper orderCustomMapper=sqlSession.getMapper(OrderCustomMapper.class);
				//调用mapper方法
				List<User> list=orderCustomMapper.findUser();
				System.out.println(list);
				sqlSession.close();
	}
	@Test
	public void testFindOrdersUserResultMap() throws Exception {
		 //2.通过工厂得到SqlSession
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//创建OrderCustomMapper,mybatis自动生成mapper代理对象
		OrderCustomMapper orderCustomMapper=sqlSession.getMapper(OrderCustomMapper.class);
		//调用mapper方法
		List<Orders> list=orderCustomMapper.findOrdersUserResultMap();
		System.out.println(list);
          sqlSession.close();
		
	}
	
	@Test
	public void testFindOrdersAndOrderDetailResultMap() throws Exception {
		 //2.通过工厂得到SqlSession
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//创建OrderCustomMapper,mybatis自动生成mapper代理对象
		OrderCustomMapper orderCustomMapper=sqlSession.getMapper(OrderCustomMapper.class);
		//调用mapper方法
		List<Orders> list=orderCustomMapper.findOrdersAndOrderDetailResultMap();
		System.out.println(list);
          sqlSession.close();
		
	}
	
	@Test
	public void testFindUserAndItemsResultMap() throws Exception {
		 //2.通过工厂得到SqlSession
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//创建OrderCustomMapper,mybatis自动生成mapper代理对象
		OrderCustomMapper orderCustomMapper=sqlSession.getMapper(OrderCustomMapper.class);
		//调用mapper方法
		List<User> list=orderCustomMapper.findUserAndItemsResultMap();
		System.out.println(list);
          sqlSession.close();
		
	}
	@Test
	public void testFindUserById() throws Exception {
		 //2.通过工厂得到SqlSession
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//创建OrderCustomMapper,mybatis自动生成mapper代理对象
		OrderCustomMapper orderCustomMapper=sqlSession.getMapper(OrderCustomMapper.class);
		//调用mapper方法
		User user=orderCustomMapper.findUserById(3);
		System.out.println(user);
          sqlSession.close();
		
	}
	//查询订单关联用户信息，用户信息使用延迟加载
	@Test
	public void testFindOrdersUserLazyLoading()throws Exception{
		//2.通过工厂得到SqlSession
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//创建OrderCustomMapper,mybatis自动生成mapper代理对象
		OrderCustomMapper orderCustomMapper=sqlSession.getMapper(OrderCustomMapper.class);
		//调用mapper方法,查询订单信息（单表）
		List<Orders> list= orderCustomMapper.findOrdersUserLazyLoading();
		//遍历上述的订单列表
		for (Orders orders : list) {
			//执行getUser（）查询用户信息，这里实现按需加载
			User user=orders.getUser();
			System.out.println(user);
		}
	}
	
	//一级缓存测试
	@Test
	public void testCache1() throws Exception{
		//2.通过工厂得到SqlSession
				SqlSession sqlSession=sqlSessionFactory.openSession();
				//创建OrderCustomMapper,mybatis自动生成mapper代理对象
				OrderCustomMapper orderCustomMapper=sqlSession.getMapper(OrderCustomMapper.class);
				//调用mapper方法
				User user1=orderCustomMapper.findUserById(2);
				System.out.println(user1);
				//如果sqlSession去执行commit操作，清空sqlSession中的一级缓存，这样做的目的是避免脏读
				User user2=orderCustomMapper.findUserById(2);
				System.out.println(user2);
	}
	
	//二级缓存测试
		@Test
		public void testCache2() throws Exception{
					SqlSession sqlSession1=sqlSessionFactory.openSession();
					SqlSession sqlSession2=sqlSessionFactory.openSession();
					SqlSession sqlSession3=sqlSessionFactory.openSession();
					
					OrderCustomMapper orderCustomMapper1=sqlSession1.getMapper(OrderCustomMapper.class);
					User user1=orderCustomMapper1.findUserById(2);
					System.out.println(user1);
					sqlSession1.close();
					
					OrderCustomMapper orderCustomMapper2=sqlSession2.getMapper(OrderCustomMapper.class);
					User user2=orderCustomMapper2.findUserById(2);
					System.out.println(user2);
					sqlSession2.close();
		}
}
