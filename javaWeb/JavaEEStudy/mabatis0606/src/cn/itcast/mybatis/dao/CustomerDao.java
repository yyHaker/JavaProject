package cn.itcast.mybatis.dao;

import cn.itcast.mybatis.po.Customer;

/**
 * dao接口，客户管理
 * @author 57217
 *
 */
public interface CustomerDao {
    //根据cid查询Customer信息
	public Customer findCustomerByCid(String cid) throws Exception;
	//添加customer信息
	public void insertCustomer(Customer customer) throws Exception;
	//删除customer信息
	public void deleteCustoemr(String cid) throws Exception;
}
