package com.neuedu.overtime.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.neuedu.overtime.entity.Overtime;
import com.neuedu.overtime.mapper.OvertimeMapper;

@Component
public class OvertimeService {
	 @Resource
	   private OvertimeMapper overtimeMapper;
	 
	//加班申请主页显示的数据
	public List<Overtime> listPageOvertime(Overtime overtime){
		return overtimeMapper.listPageOvertime(overtime);
	}
	//申请加班
	public void insertOvertime(List<Overtime> overtime){
		overtimeMapper.insertOvertime(overtime);
	}
	//通过名字模糊查询用户信息
	public List<Overtime> listPageName(Overtime overtime){
		return overtimeMapper.listPageName(overtime);
	}
	//显示全部部门
	public List<Overtime>searchDept(){
		return overtimeMapper.searchDept();
	}
	//显示部门id
	public List<Overtime> searchDid(String dname){
		return overtimeMapper.searchDid(dname);
	}
}
