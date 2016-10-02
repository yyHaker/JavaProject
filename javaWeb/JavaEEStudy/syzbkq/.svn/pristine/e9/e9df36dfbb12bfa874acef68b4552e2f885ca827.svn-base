package com.neuedu.vacation.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.neuedu.vacation.entity.Vacation;
import com.neuedu.vacation.mapper.VacationMapper;

/**
 * 假期管理service
 * 
 * @author liudaming
 */
@Component
public class VacationService {

	@Resource
	private VacationMapper vacationMapper;

	// 假期管理列表查询
	public List<Vacation> searchVacationList(Vacation vacation) {
		return vacationMapper.listPageSearchVacationList(vacation);
	}

	// 新增假期信息
	public boolean insertVacation(Vacation vacation) {
		vacationMapper.insertVacation(vacation);
		return true;
	}

	// 根据假期ID查询假期信息
	public Vacation searchVacationInfoById(int vacationId) {
		return vacationMapper.searchVacationInfoById(vacationId);
	}

	// 修改假期信息
	public Vacation updateVacationById(Vacation vacation) {
		vacationMapper.updateVacationById(vacation);
		return vacation;
	}

}
