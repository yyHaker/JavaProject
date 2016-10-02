package cn.thinking.system.user.service;

import java.util.List;

import cn.thinking.org.system.user.User;

/**
 * 
 * Description: 用户模块业务层DAO
 * 
 * Department: 沈阳开发二部 
 * @author liu.jia_neu
 * @update [修改人] [修改时间]
 * @version 1.0
 *
 */
public interface IUserService {
    User getUserById(Integer userId);

    boolean insertUser(User user);

    void updateUser(User user);

    User getUserByNameAndPwd(String username, String password);

    void updateUserBaseInfo(User user);

    void updateUserRights(User user);

    void deleteUser(int userId);

    List<User> listPageUser(User user);

    void updateLastLogin(User user);

    User getUserAndRoleById(Integer userId);

    List<User> listAllUser();

    List<User> getUserListByType(String userOrgId, Integer userLevel);

    void updateUserPassword(User user);
}
