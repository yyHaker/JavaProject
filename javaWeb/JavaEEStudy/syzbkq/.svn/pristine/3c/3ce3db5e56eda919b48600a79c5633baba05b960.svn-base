package cn.thinking.common.util;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.MybatisGenerator;
import org.mybatis.generator.config.GeneratorProperties;

/**
 * 
 * Description: mybatis-generator-core.jar 一个自动生成模型类、dao接口类甚至mapping映射文件的支撑包
 * 由于MyBatis属于一种半自动的ORM框架,所以主要的工作将是书写Mapping映射文件,但是由于手写映射文件很容易出错,这里预留一个代码生成器
 * @update [修改人] [修改时间]
 * @version 1.0
 *
 */
public class PhGeneratorTest {

	public static void main(String[] args) {
		GeneratorProperties properties = new GeneratorProperties();
        // 数据库连接驱动
        properties.setDriverClass("com.mysql.jdbc.Driver");
        // 数据库连接串
        properties.setUrl("jdbc:mysql://localhost:3306/xframe");
        // 用户名
        properties.setUser("root");
        // 密码
        properties.setPassword("");
        // 准备生成的pojo、sql映射文件存放包路径
        properties.setTargetPackage("cn.thinking.org.met");
        // 是否生成校验Annotation注释
		properties.setCheckFlag(false);
		List list = new ArrayList();
        // 本例只生成MYBATISTEST1表的对应Pojo、Sql映射文件
		// list.add("test_user");
        list.add("MAT_APPLY_INFO");
        // 准备生成代码的数据表（多个）
		properties.setTables(list);
        // 开始生成代码
		new MybatisGenerator(properties).generate();
        System.out.println("ph generator> 代码生成完毕，生成的代码存放路径："
				+ properties.getTargetPackage());
	}

}
