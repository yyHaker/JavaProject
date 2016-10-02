package com.neuedu.mapper;

import java.util.List;

import com.neuedu.entity.baseinfo.Leave;

public interface LeaveMapper {
	//主页显示
	public List<Leave> listPageLeaveList(Leave leave);
	//休假申请模态框显示
	public List<Leave> getVacation();
	//插入休假申请,传参是个对象
	public void insertLeave(Leave leave);
	//申请休假的时候选择哪个假就对应出哪个休假说明
	public String getVacation_explain(String vacation_name);
	//点击假期名字显示假期的各种信息
    public Leave getInfo(String ID);
	
	//休假审批的主页显示
	public List<Leave> listPageLeaveReview(Leave leave);
	//审批通过
	public void updataVacation_review(List<Leave> leave);
	//通过请假原因找到一条数据
	public Leave getLeave(String ID);
	//提前销假
	public void updateFlag(String ID);

}
