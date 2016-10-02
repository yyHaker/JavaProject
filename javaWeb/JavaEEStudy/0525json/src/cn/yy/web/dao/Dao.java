package cn.yy.web.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.yy.web.domain.City;
import cn.yy.web.domain.Province;

public class Dao {
	
	private QueryRunner qr=new TxQueryRunner();
	/**
	 * 查询所有省
	 * @return  List<Province>
	 */
  public List<Province> findAllProvince(){
	  String sql="select * from `t_province`";
	  try {
		return qr.query(sql,new BeanListHandler<Province>(Province.class));
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
	  
	 
  }
  
    /**
     * 查询省对应的所有市
     * @return List<City>
     */
  public List<City> findCityByProvincePid(int pid){
	  String sql="select * from  `t_city` where pid=?";
	  try {
		return qr.query( sql, new BeanListHandler<City>(City.class),pid);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
	 
  }
}
