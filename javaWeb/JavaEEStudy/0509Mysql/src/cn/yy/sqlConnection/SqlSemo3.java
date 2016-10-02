package cn.yy.sqlConnection;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import cn.yy.jdbcUtils.JdbcUtils;

public class SqlSemo3 {
	@Test
    public void TestjdbcUtils() throws SQLException{
      Connection con=JdbcUtils.getConnection();
      System.out.println(con);
      Connection con1=JdbcUtils.getConnection();
      System.out.println(con1);
    }
}
