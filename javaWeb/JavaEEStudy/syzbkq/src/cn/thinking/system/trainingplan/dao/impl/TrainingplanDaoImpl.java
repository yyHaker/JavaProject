package cn.thinking.system.trainingplan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import cn.thinking.common.basedao.BaseDao;
import cn.thinking.org.system.trainingplan.Trainingplan;
import cn.thinking.system.trainingplan.dao.ITrainingplanDao;

@Repository(value="cn.thinking.system.trainingplan.dao.impl.TrainingplanDaoImpl")
public class TrainingplanDaoImpl extends BaseDao implements ITrainingplanDao{
	

	@Override
	public List<Trainingplan> selectTrainingplanBydepartment(Trainingplan hostdepartment) {
		// TODO 自动生成的方法存根
		return (List<Trainingplan>) this.selectList("cn.thinking.org.system.trainingplan.Trainingplan.selectTrainingplanBydepartment", hostdepartment);
	}

	

	

}
