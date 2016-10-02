package cn.itcast.User.Service;

import cn.itcast.User.dao.DaoFactory;
import cn.itcast.User.dao.UserDao;
import cn.itcast.User.domain.User;
/**
 * userservice业务层
 * @author 57217
 *
 */
public class UserService {
	 //把具体的实现类的创建，隐藏到工厂中了!
      private UserDao userdao=DaoFactory.getUserDao();
      /**
       * 注册功能
       * @param user
       * @throws UserException
       */
      public void regist(User user) throws UserException{
    	  /**
    	   * 1.使用用户名去查询，如果返回null,完成添加
    	   * 2.如果返回的不是null，抛出异常
    	   */
    	  User _user=userdao.findByUsername(user.getUsername());
    	  if(_user!=null) throw new UserException("用户名"+user.getUsername()+"已经被注册");
    		userdao.add(user); 
      }
      /**
       * 登陆功能
       * 
       * @param form
       * @return
     * @throws UserException 
       */
	public User Login(User form) throws UserException {
		/**
		 * 1.使用form中的username进行查询，得到User对象
		 */
		User user=userdao.findByUsername(form.getUsername());
		/**
		 * 2.如果返回null证明用户名不存在
		 */
		if(user==null) throw new UserException("用户名不存在");
		/**
		 * 3.比较user的password	
		 */
		if(!form.getPassword().equals(user.getPassword())){
			throw new UserException("密码错误");
		}
		return user;//user包含所有信息
	}
}
