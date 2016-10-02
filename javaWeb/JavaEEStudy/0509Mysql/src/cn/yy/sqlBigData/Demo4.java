package cn.yy.sqlBigData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import cn.yy.jdbcUtils.*;
/**
 * 大数据
 * @author cxf
 *
 */
public class Demo4 {
	/**
	 * 把mp3保存到数据库中。
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void fun1() throws Exception {
		/*
		 * 1. 得到Connection
		 * 2. 给出sql模板，创建pstmt
		 * 3. 设置sql模板中的参数
		 * 4. 调用pstmt的executeUpdate()执行
		 */
		Connection con = JdbcUtils.getConnection();
		String sql = "insert into tab_bin values(?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, 1);
		pstmt.setString(2, "许巍 - 蓝莲花.mp3");
		/**
		 * 需要得到Blob
		 * 1. 我们有的是文件，目标是Blob
		 * 2. 先把文件变成byte[]
		 * 3. 再使用byte[]创建Blob
		 */
		// 把文件转换成byte[]
		byte[] bytes = IOUtils.toByteArray(new FileInputStream("E:/许巍 - 蓝莲花.mp3"));
		// 使用byte[]创建Blob
		Blob blob = new SerialBlob(bytes);
		// 设置参数
		pstmt.setBlob(3, blob);
		
		pstmt.executeUpdate();
	}
	
	/**
	 * 从数据库读取mp3
	 * @throws SQLException 
	 */
	@Test
	public void fun2() throws Exception {
		/*
		 * 1. 创建Connection
		 */
		Connection con = JdbcUtils.getConnection();
		/*
		 * 2. 给出select语句模板，创建pstmt
		 */
		String sql = "select * from tab_bin";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		/*
		 * 3. pstmt执行查询，得到ResultSet
		 */
		ResultSet rs = pstmt.executeQuery();
		
		/*
		 * 4. 获取rs中名为data的列数据
		 */
		if(rs.next()) {
			Blob blob = rs.getBlob("data");
			/*
			 * 把Blob变成硬盘上的文件！
			 */
			/*
			 * 1. 通过Blob得到输入流对象
			 * 2. 自己创建输出流对象
			 * 3. 把输入流的数据写入到输出流中
			 */
			InputStream in = blob.getBinaryStream();
			OutputStream out = new FileOutputStream("c:/许巍 - 蓝莲花.mp3");
			IOUtils.copy(in, out);
		}
	}
}
