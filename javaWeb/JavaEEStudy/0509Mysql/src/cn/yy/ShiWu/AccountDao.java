package cn.yy.ShiWu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
  /**
   * 修改指定用户的余额
   * @author 57217
   *
   */
public class AccountDao {
      public void UpdateBalance(Connection con,String name,int balance){
    	  try {
			
			String sql="update account set balance=balance+? where name=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, balance);
			pstmt.setString(2, name);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	  
      }
}
