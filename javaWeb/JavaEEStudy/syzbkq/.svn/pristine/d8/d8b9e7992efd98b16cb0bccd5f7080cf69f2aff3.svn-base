package com.neuedu.service.kq;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.neuedu.entity.baseinfo.WorkManage;
import com.neuedu.mapper.WorkManageMapper;
/**
 * 班组排班管理业务层
 * @author Administrator
 *
 */
@Component
public class WorkManageService {
	@Resource
	private WorkManageMapper workmanagemapper;
	
	//主页显示数据
	public List<WorkManage> listPageSearchWorkManage(WorkManage workmanage){
		return workmanagemapper.listPageSearchWorkManage(workmanage);
	}
	//排班，就是增加
	public void addWorkManage(WorkManage workmanage){
		workmanagemapper.addWorkManage(workmanage);
	}
	//删除
	public void deleteWorkManage(String workmanage_id){
		workmanagemapper.deleteWorkManage(workmanage_id);
	}
	//修改信息之先知道一条信息
	public WorkManage getWorkManage(String workmanage_id){
		return workmanagemapper.getWorkManage(workmanage_id);
	}
	//修改
	public void updateWorkManage(WorkManage workmanage){
		workmanagemapper.updateWorkManage(workmanage);
	}

}
