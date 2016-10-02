package cn.itcast.mabatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.Customer;

/**
 * mapper接口，相当于dao接口,用户管理
 * @author 57217
 *
 */
public interface CustomerMapper {
	
  //根据id查询用户信息
	public Customer findCustomerByCid(String cid) throws Exception;
  //根据用户名模糊查询Customer
    public List<Customer> findCustomerByCname(String cname) throws Exception;
  //添加customer信息
	public void insertCustomer(Customer customer) throws Exception;
  //删除customer信息
	public void deleteCustoemr(String cid) throws Exception;	
	
	
}
