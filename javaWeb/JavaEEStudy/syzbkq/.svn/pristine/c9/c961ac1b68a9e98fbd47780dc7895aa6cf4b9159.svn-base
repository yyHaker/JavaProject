package com.neuedu.service.kq;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.neuedu.entity.baseinfo.Leave;
import com.neuedu.mapper.LeaveMapper;


@Component
public class LeaveService {
	//业务层使用mapper接口
	@Resource
	private LeaveMapper leaveMapper;
	
	//主页显示信息
	public List<Leave> getLeaveList(Leave leave){
		return leaveMapper.listPageLeaveList(leave);
	}
	//点击模态框显示
	public List<Leave> getVacation(){
		return leaveMapper.getVacation();	
	}
	//插入休假申请
	public void insertLeave(Leave leave){
		leaveMapper.insertLeave(leave);
	}
	//通过点击什么假期名字就能显示什么假期说明的查询语句
	public String getVacation_explain(String vacation_name)
	{
		return leaveMapper.getVacation_explain(vacation_name);
	}
	//点击假期名字显示假期信息
	public Leave getInfo(String ID)
	{
		return leaveMapper.getInfo(ID);
	}
	
	////////////////////////////////////////////////////////////////////////////
	
	//休假审批主页信息显示
	public List<Leave> getLeaveReviewList(Leave leave)
	{
		return leaveMapper.listPageLeaveReview(leave);
	}
	//休假审批通过,参数我用的是请假原因；请假原因作为更改参数
	public void updataVacation_review(List<Leave> leave)
	{
		leaveMapper.updataVacation_review(leave);
	}
	//找到一条数据通过休假原因
	public Leave getLeave(String ID)
	{
		return leaveMapper.getLeave(ID);
	}
	//提前休假
	public void updateFlag(String ID)
	{
		leaveMapper.updateFlag(ID);
	}

}
