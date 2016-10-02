package cn.thinking.system.trainer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.thinking.org.system.trainer.Trainer;
import cn.thinking.system.trainer.dao.ITrainerDao;
import cn.thinking.system.trainer.service.ITrainerService;

@Service
public class TrainerServiceImpl implements ITrainerService{

	@Autowired
	private ITrainerDao trainerDao;

	@Override
	public List<Trainer> ListAllTrainer(Trainer trainer) {
		// TODO Auto-generated method stub
		return trainerDao.listAllTrainer(trainer);
	}
	
	@Override
	public Trainer getTrainerById(String employeenum) {
		// TODO Auto-generated method stub
		return trainerDao.getTrainerById(employeenum);
	}
	
	@Override
	public void deleteUser(String employeenum) {
		 
		trainerDao.deleteUser(employeenum);
	}
	
	@Override
	public Trainer updateById(Trainer trainer) {
		trainerDao.modifyTrainerById(trainer);
		return trainer;
	}

	@Override
	public Trainer selectTrainerById(String id) {
		return trainerDao.selectTrainerById(id);
	}
	
}
