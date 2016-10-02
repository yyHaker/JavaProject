package com.neuedu.overtime.mapper;

import java.util.List;
import com.neuedu.overtime.entity.Overtime;

public interface ApprovalMapper {
	//加班申请主页显示的数据
	public List<Overtime> listPageOvertime(Overtime overtime);
	//加班审批,可以多条
	public void updateApproval(List<Overtime> overtime);
	//加班审批驳回,可以多条
	public void rejectApproval(List<Overtime> overtime);
}
