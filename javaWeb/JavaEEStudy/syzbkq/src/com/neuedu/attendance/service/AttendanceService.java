package com.neuedu.attendance.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.neuedu.attendance.entity.Attendance;
import com.neuedu.attendance.mapper.AttendanceMapper;
  
/**
 * 考勤管理Service
 * @author qidan
 */

@Component
public class AttendanceService {

	@Resource
	private AttendanceMapper attendanceMapper;
	
	//考勤管理列表查询
	public List<Attendance> listPageSearchAttendanceList(Attendance attendance){		
		return attendanceMapper.listPageSearchAttendanceList(attendance);
	}
	
	//显示考勤管理表详细信息
	public Attendance SearchAttendanceByUserid(int userid){
		return attendanceMapper.SearchAttendanceByUserid(userid);		
	}	
	//根据用户id修改考勤信息
	public void updateAttendanceById(Attendance attendance){
		attendanceMapper.updateAttendanceById(attendance);	
	}

}
