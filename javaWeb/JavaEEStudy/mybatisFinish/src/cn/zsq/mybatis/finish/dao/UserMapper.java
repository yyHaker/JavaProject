package cn.zsq.mybatis.finish.dao;

import java.util.List;

import cn.zsq.mybatis.finish.domain.Orders;
import cn.zsq.mybatis.finish.domain.User;

public interface UserMapper {
	public User selectUserById(int id) throws Exception;
	public List<Orders> selectOrdersUser() throws Exception;
	public List<Orders> selectOrdersUserLazyLoading() throws Exception;
	public List<Orders> selectOrdersOrderDetailUser() throws Exception;
}
