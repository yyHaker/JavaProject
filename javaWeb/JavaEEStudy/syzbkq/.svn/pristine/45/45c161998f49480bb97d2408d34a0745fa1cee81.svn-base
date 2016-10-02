package com.neuedu.service.kq;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.neuedu.entity.baseinfo.Quarters;
import com.neuedu.mapper.QuartersMapper;


@Component
public class QuartersService {

	@Resource
	private QuartersMapper quartersMapper;
	
	public List<Quarters> listPageAllQuarters(Quarters quarters){
		return quartersMapper.listPageAllQuarters(quarters);
	}
	
	public Quarters getQuartersById(int pid){
		return quartersMapper.getQuartersById(pid);
	}
	
	public int insertQuarters(Quarters quarters){
		return quartersMapper.insertQuarters(quarters);
	}
	
	public void updateQuarters(Quarters quarters){
		quartersMapper.updateQuarters(quarters);
	}
	
	public void deleteQuarters(int pid){
		quartersMapper.deleteQuarters(pid);
	}
}
