package cn.itcast.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.itcast.mybatis.po.Customer;
/**
 * CustomerDao接口实现类
 * @author 57217
 *
 */
public class CustomerDaoImpl implements CustomerDao {
     //需要向dao实现类中注入SqlSessionFactory
	  //这里通过构造方法注入
	private SqlSessionFactory sqlSessionFactory;
	
	 public CustomerDaoImpl(SqlSessionFactory sqlSessionFactory) {
		 this.sqlSessionFactory=sqlSessionFactory;
	 }
	 
	@Override
	public Customer findCustomerByCid(String cid) throws Exception {
	     SqlSession sqlSession=sqlSessionFactory.openSession();
	     Customer customer=sqlSession.selectOne("test.findCustomerByCid",cid);
	     sqlSession.close();
		 return customer;
	}

	@Override
	public void insertCustomer(Customer customer) throws Exception {
		  SqlSession sqlSession=sqlSessionFactory.openSession();
		   sqlSession.update("test.insertCustomer",customer);
		   sqlSession.commit();
		   sqlSession.close();
	}

	@Override
	public void deleteCustoemr(String cid) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		   sqlSession.delete("test.deleteCustomer",cid);
		   sqlSession.commit();
		   sqlSession.close();
	}

}
