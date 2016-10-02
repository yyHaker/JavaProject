package com.neuedu.mapper;

import java.util.List;

import com.neuedu.entity.baseinfo.ClassManage;

public interface ClassManageMapper {
	//班制管理主页数据显示
	public List<ClassManage> listPageSearchClassManage(ClassManage classManage);
	//班组新增
	public void insertClassManage(ClassManage classManage);
	//查看详细信息
	public ClassManage findClassManage(String class_system_id);
	//删除数据
	public void deleteClassManage(String class_system_id);
	//修改信息
	public void updateClassManage(ClassManage classManage);

}
