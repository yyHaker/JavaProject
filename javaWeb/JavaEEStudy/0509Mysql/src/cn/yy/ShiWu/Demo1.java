package cn.yy.ShiWu;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import cn.yy.jdbcUtils.JdbcUtils;
/**
 * 演示事务
 * @author 57217
 *
 */
public class Demo1 {
    public void Zhuanzhang(String fromName,String toName,int monney){
    	Connection con=null;
        try{
        	con=JdbcUtils.getConnection();
        	//1.开启事务
        	con.setAutoCommit(false);
        	
        	AccountDao dao=new AccountDao();
        	dao.UpdateBalance(con,fromName,-monney);
        	//测试事务是否正常不能中断
//        	if (true) {
//				throw new RuntimeException();
//			}
        	dao.UpdateBalance(con,toName, monney);
        	//2.提交事务
        	con.commit();
        	con.close();
        }catch(Exception e){
        	//3.回滚事务
        	try {
				con.rollback();
				con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
        }
    }
    @Test
    public void TestDemo1(){
    	Zhuanzhang("zs", "ls",10);
    }
}
