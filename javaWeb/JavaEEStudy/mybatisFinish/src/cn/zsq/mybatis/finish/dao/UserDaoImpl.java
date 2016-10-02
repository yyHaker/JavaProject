package cn.zsq.mybatis.finish.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.zsq.mybatis.finish.domain.Orders;
import cn.zsq.mybatis.finish.domain.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public User selectUserById(int id) throws Exception {
		SqlSession sqlSession = this.getSqlSession();
		User user = sqlSession.selectOne("selectUserById", id);
		return user;
	}

	@Override
	public List<Orders> selectOrdersUser() throws Exception {
		SqlSessionFactoryBean test = new SqlSessionFactoryBean();
		return null;
	}

	@Override
	public List<Orders> selectOrdersUserLazyLoading() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> selectOrdersOrderDetailUser() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
