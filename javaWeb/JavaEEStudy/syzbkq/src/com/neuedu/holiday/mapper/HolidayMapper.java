package com.neuedu.holiday.mapper;

import java.util.List;

import com.neuedu.holiday.entity.Holiday;

/**
 * 法定假期维护Mapper
 * @author liudaming
 */

public interface HolidayMapper {

	//法定假期维护列表查询
	List<Holiday> searchHolidayList(Holiday holiday);
	//删除法定假期维护数据
	void deleteholiday(int hdId);
	//根据法定假期id查询法定假期信息
	Holiday searchHolidayInfoById(int hdId);
	//编辑法定假期维护数据
	void  editHoliday(Holiday holiday);
	//新增法定假期维护数据
	void  insertHoliday(List<Holiday> holiday);
}
