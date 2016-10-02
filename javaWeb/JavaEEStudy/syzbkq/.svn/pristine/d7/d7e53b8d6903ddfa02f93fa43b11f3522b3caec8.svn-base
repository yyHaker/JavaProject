package cn.thinking.system.user.service.impl;

import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.thinking.org.system.user.User;
import cn.thinking.system.user.dao.IUserDao;
import cn.thinking.system.user.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
    private IUserDao userDao;

	public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    public boolean insertUser(User user) {
        // TODO Auto-generated method stub
        int count = userDao.getCountByName(user.getLoginname());
        if (count > 0) {
            return false;
        }
        else {
            userDao.insertUser(user);
            return true;
        }

    }

    public List<User> listPageUser(User user) {
        if (StringUtils.isNotEmpty(user.getUsername())) {
            user.setUsername("%" + user.getUsername() + "%");
        }

        return userDao.listPageUser(user);
    }

    public void updateUser(User user) {
        // TODO Auto-generated method stub
        userDao.updateUser(user);
    }

    public void updateUserBaseInfo(User user) {
        userDao.updateUserBaseInfo(user);
    }

    public void updateUserRights(User user) {
        userDao.updateUserRights(user);
    }

    public User getUserByNameAndPwd(String loginname, String password) {
        User user = new User();
        user.setLoginname(loginname);
        user.setPassword(password);
        return userDao.getUserInfo(user);
    }

    public void deleteUser(int userId) {
        userDao.deleteUser(userId);
    }

    public User getUserAndRoleById(Integer userId) {
        return userDao.getUserAndRoleById(userId);
    }

    public void updateLastLogin(User user) {
        // TODO Auto-generated method stub
        userDao.updateLastLogin(user);
    }

    public List<User> listAllUser() {
        // TODO Auto-generated method stub
        return userDao.listAllUser();
    }

    public List<User> getUserListByType(String userOrgId, Integer userLevel) {
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("userorgid", userOrgId);
        params.put("userlevel", userLevel);

        return userDao.getUserListByType(params);
    }

    public void updateUserPassword(User user) {
        userDao.updateUserPassword(user);
    }
}
