package cn.itcast.User.dao;

import cn.itcast.User.domain.User;

public interface UserDao {
	public void add(User user);
    public User findByUsername(String username);
}
