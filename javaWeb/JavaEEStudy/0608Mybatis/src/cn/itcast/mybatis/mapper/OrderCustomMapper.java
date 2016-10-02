package cn.itcast.mybatis.mapper;

import java.util.List;


import cn.itcast.mybatis.po.Orders;
import cn.itcast.mybatis.po.OrdersCustom;
import cn.itcast.mybatis.po.User;

/**
 * 订单用户mapper
 * @author 57217
 *
 */
public interface OrderCustomMapper {
  //根据user_id查询用户
	public User findUserById(Integer id) throws Exception;
  //查询订单关联用户信息（ResultType实现）
	public List<OrdersCustom> findOrdersUser() throws Exception;
  //查询用户信息
	public List<User> findUser() throws Exception;
  //查询订单关联用户信息（ResultMap实现）
	public List<Orders>  findOrdersUserResultMap() throws Exception;
  //查询订单（关联用户）及订单明细
	public List<Orders>   findOrdersAndOrderDetailResultMap()throws Exception;
  //查询用户购买的商品信息
	public List<User>  findUserAndItemsResultMap()throws Exception;
	//查询订单关联查询用户，用户信息是延迟加载
	public List<Orders> findOrdersUserLazyLoading()throws Exception;
	
}
