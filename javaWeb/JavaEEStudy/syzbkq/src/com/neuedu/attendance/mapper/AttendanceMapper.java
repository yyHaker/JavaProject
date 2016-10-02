package com.neuedu.attendance.mapper;

import java.util.List;
import com.neuedu.attendance.entity.Attendance;

/**
 * 考勤管理Mapper
 * @author qidan
 */

public interface AttendanceMapper {
	//考勤管理列表查询
	 List<Attendance> listPageSearchAttendanceList(Attendance attendance);
	 
	 //显示考勤管理表详细信息
	 Attendance SearchAttendanceByUserid(int userid);
	 
	 //根据用户id修改考勤信息
	 void updateAttendanceById(Attendance attendance);
}
