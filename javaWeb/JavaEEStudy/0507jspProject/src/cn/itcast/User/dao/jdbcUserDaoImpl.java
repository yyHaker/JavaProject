package cn.itcast.User.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.itcast.User.domain.User;
/**
 * 针对数据库的实现
 * @author 57217
 *
 */
public class jdbcUserDaoImpl implements UserDao {

	@Override
	public void add(User user) {
		Connection con=null;
		PreparedStatement pstmt=null;
		/**
		 * 一.得到连接
		 */
        try {
			 con=JdbcUtils.getConnection();
		/**
		 *2.准备sql模板，得到PrepareStatement 对象
		 */
			String sql="insert into userinformation values(?,?)";
		   pstmt=con.prepareStatement(sql);
		 /**
		  * 3.为PrepareStatement对象中sql参数赋值 
		  */
		  pstmt.setString(1,user.getUsername());
		  pstmt.setString(2, user.getPassword());
		  /**
		   * 4.运行
		   */
		  pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
				try {
					if(pstmt!=null)pstmt.close();
					if(con!=null) pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
		}
	}

	@Override
	public User findByUsername(String username) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		/**
		 * 一.得到连接
		 */
        try {
			 con=JdbcUtils.getConnection();
		/**
		 *2.准备sql模板，得到PrepareStatement 对象
		 */
			String sql="select * from userinformation where username=?";
		   pstmt=con.prepareStatement(sql);
		 /**
		  * 3.为PrepareStatement对象中sql参数赋值 
		  */
		  pstmt.setString(1,username);
		
		  /**
		   * 4.运行
		   */
		   rs=pstmt.executeQuery();
		   /**
		    * 5.把 ResultSet转换成User类型,返回
		    */
		   if(rs==null){
			   return null;
		   }
		   if(rs.next()){
			   //转换成User对象，并返回
			   //orm -->对象关系映射（Hibernate）
			   User user =new User();
			   user.setUsername(rs.getString("username"));
			   user.setPassword(rs.getString("password"));
			   return user;
		   }else{
			   return null;
		   }
		 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
				try {
					if(pstmt!=null)pstmt.close();
					if(con!=null) pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
		}
        return null;
		
	}

}
