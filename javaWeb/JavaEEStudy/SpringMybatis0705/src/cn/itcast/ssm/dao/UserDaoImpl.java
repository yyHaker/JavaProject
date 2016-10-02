package cn.itcast.ssm.dao;


import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import cn.itcast.ssm.po.User;

public class UserDaoImpl  extends SqlSessionDaoSupport implements UserDao {
	/*//需要向dao实现类中注入SqlSessionFactory
	  //这里通过构造方法注入
	private SqlSessionFactory sqlSessionFactory;
	
	 public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		 this.sqlSessionFactory=sqlSessionFactory;
	 }*/
	@Override
	public User findUserById(int id) throws Exception {
		//让类继承SqlSessionDaoSupport,通过this.getSqlSession()来获得sqlSession
		SqlSession sqlSession=this.getSqlSession();
		User user=sqlSession.selectOne("test.findUserById",id);
//	     sqlSession.close();
		 return user;
	}

}
