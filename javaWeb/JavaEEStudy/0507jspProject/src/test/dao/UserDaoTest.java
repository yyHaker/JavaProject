package test.dao;

import org.junit.Test;

import cn.itcast.User.dao.UserDao;
import cn.itcast.User.dao.UserDaoImpl;
import cn.itcast.User.domain.User;

public class UserDaoTest {

	@Test
	public void testFindByUsername(){
		//System.out.println("hello world!");
		UserDao userdao=new UserDaoImpl();
		User user=userdao.findByUsername("lixue");
		System.out.println(user);
	}
	@Test
	public void testAdd(){
		UserDao userdao=new UserDaoImpl();
		User user=new User();
		user.setUsername("王五");
		user.setPassword("456");
		userdao.add(user);
		
	}
}
