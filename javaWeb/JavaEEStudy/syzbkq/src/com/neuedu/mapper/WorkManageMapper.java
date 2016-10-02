package com.neuedu.mapper;

import java.util.List;
import com.neuedu.entity.baseinfo.WorkManage;

/**
 * 班组排班管理接口
 * @author Administrator
 *
 */
public interface WorkManageMapper {
	public List<WorkManage> listPageSearchWorkManage(WorkManage workmanage);
	public void addWorkManage(WorkManage workmanage);
	public void deleteWorkManage(String workmanage_id);
	public WorkManage getWorkManage(String workmanage_id);
	public void updateWorkManage(WorkManage workmanage);
}
