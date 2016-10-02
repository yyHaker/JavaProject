package com.neuedu.mapper;

import java.util.List;

import com.neuedu.entity.baseinfo.Quarters;

public interface QuartersMapper {
	
	public List<Quarters> listPageAllQuarters(Quarters quarters);
	
	public Quarters getQuartersById(int pid);
	
	public int insertQuarters(Quarters quarters);
	
	public void updateQuarters(Quarters quarters);
	
	public void deleteQuarters(int pid);

}
