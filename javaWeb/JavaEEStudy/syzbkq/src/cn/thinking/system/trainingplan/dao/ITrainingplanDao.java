package cn.thinking.system.trainingplan.dao;

import java.util.List;

import cn.thinking.org.system.trainingplan.Trainingplan;



public interface ITrainingplanDao {
	List<Trainingplan> selectTrainingplanBydepartment(Trainingplan hostdepartment);
	
	

}
