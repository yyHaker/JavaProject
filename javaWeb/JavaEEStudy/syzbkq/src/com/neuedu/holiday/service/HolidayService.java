package com.neuedu.holiday.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.neuedu.holiday.entity.Holiday;
import com.neuedu.holiday.mapper.HolidayMapper;


/**
 * 法定假期维护service
 * @author liudaming
 */
@Component
public class HolidayService {

	@Resource
	private HolidayMapper holidayMapper;

	//法定假期维护列表查询
	public List<Holiday> searchHolidayList(Holiday holiday) {
		return holidayMapper.searchHolidayList(holiday);
	}
	//删除假期信息
	public void deleteholiday(int hdId){
		 holidayMapper.deleteholiday(hdId);
	}
	
	//编辑假期信息
	public boolean editHoliday(Holiday holiday){
		holidayMapper.editHoliday(holiday);
		return true;
	}
	//根据id查询法定假期信息
	public Holiday searchHolidayInfoById(int hdId){
		return holidayMapper.searchHolidayInfoById(hdId);
	}
	//新增法定假期
	public void insertHoliday(List<Holiday> holiday){
		holidayMapper.insertHoliday(holiday);
	}
}
