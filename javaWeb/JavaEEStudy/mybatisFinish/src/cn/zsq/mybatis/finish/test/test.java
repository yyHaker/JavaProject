package cn.zsq.mybatis.finish.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.zsq.mybatis.finish.dao.UserDao;
import cn.zsq.mybatis.finish.dao.UserMapper;
import cn.zsq.mybatis.finish.domain.Orders;
import cn.zsq.mybatis.finish.domain.User;

public class test {

	@Test
	public void func6() throws Exception {
		ApplicationContext context = new 
				ClassPathXmlApplicationContext("spring/ApplicationContext.xml");
		UserDao userDao = (UserDao) context.getBean("userDao");
		User user = userDao.selectUserById(1);
		System.out.println(user);
	}
	
	@Test
	public void func7() throws Exception{
		ApplicationContext context = new 
				ClassPathXmlApplicationContext("spring/ApplicationContext.xml");
		UserMapper userMapper = (UserMapper) context.getBean("userMapper");
		User user = userMapper.selectUserById(1);
		System.out.println(user);
	}
}
