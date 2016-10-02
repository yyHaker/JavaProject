package com.neuedu.overtime.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.neuedu.overtime.entity.Overtime;
import com.neuedu.overtime.mapper.ApprovalMapper;

@Component
public class ApprovalService {
	
	@Resource
	   private ApprovalMapper approvalMapper;
	 
	//加班申请主页显示的数据
	public List<Overtime> listPageOvertime(Overtime overtime){
		return approvalMapper.listPageOvertime(overtime);
	}
	//离岗审批,可以多条
	public void updateApproval(List<Overtime> overtime){
		approvalMapper.updateApproval(overtime);
	}
	//加班审批驳回,可以多条
	public void rejectApproval(List<Overtime> overtime){
		approvalMapper.rejectApproval(overtime);
	}
}
	
	