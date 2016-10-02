package cn.thinking.system.trainingplan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.thinking.org.system.trainingplan.Trainingplan;
import cn.thinking.system.trainingplan.dao.ITrainingplanDao;
import cn.thinking.system.trainingplan.service.ITrainingplanService;
@Service
public class TrainingplanServiceImpl  implements ITrainingplanService{
	@Autowired
	private ITrainingplanDao trainingplanDao;

	@Override
	public List<Trainingplan> selectTrainingplanBydepartment(Trainingplan hostdepartment) {
		// TODO 自动生成的方法存根
		return trainingplanDao.selectTrainingplanBydepartment(hostdepartment);
	}

	

	

	
	

}
