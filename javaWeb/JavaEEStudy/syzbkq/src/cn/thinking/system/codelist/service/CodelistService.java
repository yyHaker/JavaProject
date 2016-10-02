package cn.thinking.system.codelist.service;

import java.util.List;

import cn.thinking.org.system.codelist.Codelist;

/**
 * 数据字典操作服务类接口 
 */
public interface CodelistService {
	//假期类型
	List<Codelist> listvacationType();
	//班制类型
	public List<Codelist> listBanSystem();
}
