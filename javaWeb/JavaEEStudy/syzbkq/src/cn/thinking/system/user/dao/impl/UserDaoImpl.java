package cn.thinking.system.user.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.thinking.common.basedao.BaseDao;
import cn.thinking.org.system.user.User;
import cn.thinking.system.user.dao.IUserDao;

/**
 * 
 * Description: 用户接口实现类
 * 
 * Department: 沈阳开发二部 
 * @author liu.jia_neu
 * @update [修改人] [修改时间]
 * @version 1.0
 *
 */
@Repository(value = "cn.thinking.system.user.dao.impl.UserDaoImpl")
public class UserDaoImpl extends BaseDao implements IUserDao {

	@Override
	public List<User> listAllUser() {
		return (List<User>) this.selectList("cn.thinking.org.system.user.User.listAllUser");
	}

	@Override
	public User getUserById(Integer userId) {
        return (User) this.selectOne("cn.thinking.org.system.user.User.getUserById", userId);
	}

	@Override
	public void insertUser(User user) {
        this.insert("cn.thinking.org.system.user.User.insertUser", user);
	}

	@Override
	public void updateUser(User user) {
        this.update("cn.thinking.org.system.user.User.updateUser", user);
	}

	@Override
	public User getUserInfo(User user) {
		return (User)this.selectOne("cn.thinking.org.system.user.User.getUserInfo",user);
	}

	@Override
	public void updateUserBaseInfo(User user) {
        this.update("cn.thinking.org.system.user.User.updateUserBaseInfo", user);
	}

	@Override
	public void updateUserRights(User user) {
        this.update("cn.thinking.org.system.user.User.updateUserRights", user);
	}

	@Override
	public int getCountByName(String loginname) {
        return (Integer) this.selectOne("cn.thinking.org.system.user.User.getCountByName", loginname);
	}

	@Override
	public void deleteUser(int userId) {
        this.delete("cn.thinking.org.system.user.User.deleteUser", userId);
	}

	@Override
	public int getCount(User user) {
        return (Integer) this.selectOne("cn.thinking.org.system.user.User.getCount", user);
	}

	@Override
	public List<User> listPageUser(User user) {
        return (List<User>) this.selectList("cn.thinking.org.system.user.User.listforPageUser", user);
	}

	@Override
	public User getUserAndRoleById(Integer userId) {
        return (User) this.selectOne("cn.thinking.org.system.user.User.getUserAndRoleById", userId);
	}

	@Override
	public void updateLastLogin(User user) {
        this.update("cn.thinking.org.system.user.User.updateLastLogin", user);
	}

	@Override
	public List<User> getUserListByType(HashMap<String, Object> parmas) {
        return (List<User>) this.selectList("cn.thinking.org.system.user.User.getUserListByType", parmas);
	}

	@Override
	public void updateUserPassword(User user) {
        this.update("cn.thinking.org.system.user.User.updateUserPassword", user);
	}

}
