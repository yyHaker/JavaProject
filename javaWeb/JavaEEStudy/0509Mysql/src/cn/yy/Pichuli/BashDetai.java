package cn.yy.Pichuli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import cn.yy.jdbcUtils.JdbcUtils;

public class BashDetai {
   @Test
   public void ConnectToMysql(){
	   try {
		Connection con=JdbcUtils.getConnection();
		String sql="insert into Student values(?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
	     for (int i = 0; i <10000; i++) {
			pstmt.setInt(1, i+1);
			pstmt.setString(2,"stu_"+i);
			pstmt.setString(3,i%2==0?"男":"女");
			pstmt.addBatch();//添加批处理，保存到集合中
		}
	     long start=System.currentTimeMillis();
	      pstmt.executeBatch();//执行批处理
	     long end=System.currentTimeMillis();
	     System.out.println(end-start);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	  
   }
}
