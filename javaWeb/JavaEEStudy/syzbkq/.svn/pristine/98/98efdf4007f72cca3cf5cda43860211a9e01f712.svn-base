package com.neuedu.service.kq;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.neuedu.mapper.SqlServerDataSourceMapper;


/**
 * 多数据源测试
 * @author Administrator
 *
 */
@Component
public class DataSourceServiceTest {
	@Resource
	private SqlServerDataSourceMapper dataSourceTestMapper;
	
	public void getAllList(){
		//DataSourceTypeManager.set(DataSources.SQLSERVER);
		System.out.println("getObjectTypeList---------------开始------");
		dataSourceTestMapper.getObjectTypeList();
		System.out.println("getObjectTypeList---------------结束------");
		
		System.out.println("getObjectTypeList---------------开始------");
		//dataSourceTestMapper.getObjectTypeList();
		System.out.println("addObjectTypeList---------------结束------");
		
	}

}
