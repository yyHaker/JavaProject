package cn.thinking.system.trainer.service;

import java.util.List;

import cn.thinking.org.system.trainer.Trainer;

public interface ITrainerService {
	List<Trainer> ListAllTrainer(Trainer trainer);
	
	Trainer getTrainerById(String employeenum);
	
	void deleteUser(String employeenum);
	
	Trainer updateById(Trainer trainer);
	
	Trainer selectTrainerById(String id);
}
