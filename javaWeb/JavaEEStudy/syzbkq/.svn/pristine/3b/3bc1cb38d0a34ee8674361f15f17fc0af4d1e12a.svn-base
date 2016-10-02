package cn.thinking.system.user.dao;

import java.util.HashMap;
import java.util.List;

import cn.thinking.org.system.user.User;

/**
 * 
 * Description: 用户模块DAO底层接口
 * 
 * Department: 沈阳开发二部 
 * @author liu.jia_neu
 * @update [修改人] [修改时间]
 * @version 1.0
 *
 */
public interface IUserDao {
	/**
	 * 
	 * Discription:获取所有User
	 *
	 * @return List<User>
	 */
    List<User> listAllUser();

    User getUserById(Integer userId);

    void insertUser(User user);

    void updateUser(User user);

    User getUserInfo(User user);

    void updateUserBaseInfo(User user);

    void updateUserRights(User user);

    int getCountByName(String loginname);

    void deleteUser(int userId);

    int getCount(User user);

    List<User> listPageUser(User user);

    User getUserAndRoleById(Integer userId);

    void updateLastLogin(User user);

    List<User> getUserListByType(HashMap<String, Object> parmas);

    void updateUserPassword(User user);
}
