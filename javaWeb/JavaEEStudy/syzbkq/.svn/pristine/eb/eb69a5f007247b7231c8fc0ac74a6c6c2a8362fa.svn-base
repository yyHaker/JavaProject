package cn.thinking.system.trainer.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.thinking.common.basedao.BaseDao;
import cn.thinking.org.system.trainer.Trainer;
import cn.thinking.system.trainer.dao.ITrainerDao;

@Repository(value = "cn.thinking.system.trainer.dao.impl.TrainerDaoImpl")
public class TrainerDaoImpl extends BaseDao implements ITrainerDao{
	@Override
	public List<Trainer> listAllTrainer(Trainer trainer) {
		return (List<Trainer>) this.selectList("cn.thinking.org.system.trainer.Trainer.listAllTrainer",trainer);
	}
	
	@Override
	public Trainer getTrainerById(String employeenum) {
		return (Trainer) this.selectOne("cn.thinking.org.system.trainer.Trainer.getTrainerById",employeenum);
	}
	
	@Override
	public void deleteUser(String employeenum) {
		this.delete("cn.thinking.org.system.trainer.Trainer.deleteUser",employeenum);

	}
	
	@Override
	public void modifyTrainerById(Trainer trainer) {
		this.update("cn.thinking.org.system.trainer.Trainer.updateTrainById",trainer);
	}

	@Override
	public Trainer selectTrainerById(String id) {
		// TODO Auto-generated method stub
		return (Trainer)this.selectOne("cn.thinking.org.system.trainer.Trainer.getTrainerById", id);
	}
}
