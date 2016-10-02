package com.neuedu.xiaorui.service.course.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.neuedu.xiaorui.entity.CourseEntity;
import com.neuedu.xiaorui.entity.DailyCourse;
import com.neuedu.xiaorui.mapper.course.CourseMapper;
import com.neuedu.xiaorui.service.course.CourseService;

@Service("courseService")
public class CourseServiceImpl implements CourseService {
	@Resource
	private CourseMapper courseMapper;

	@Override
	public List<DailyCourse> getDailyCourseList(String classId, String start, String end) {

		HashMap<String, String> map=new HashMap<String, String>();
		map.put("classId", classId);
		map.put("start", start);
		map.put("end", end);
		return courseMapper.getDailyCourseList(map);
	}

	@Override
	public DailyCourse getDailyCourse(String classId, String day) {

		HashMap<String, String> map=new HashMap<String, String>();
		map.put("classId", classId);
		map.put("day", day);
		return courseMapper.getDailyCourse(map);
	}

	@Override
	@Transactional
	public void syncCourse(String beginTime, List<CourseEntity> courseList) {

		HashMap<String, String> map=new HashMap<String, String>();
		map.put("beginTime", beginTime);
		courseMapper.deleteCourseList(map);
		
		courseMapper.addCourseBatch(courseList);
	}
	
	public List<DailyCourse> getCourseListByPage(String classId, String day,String courseName,String pageOn,String pageSize){
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("classId", classId);
		map.put("day", day);
		if(courseName!=null&&!"null".equalsIgnoreCase(courseName))
		{
			map.put("courseName",courseName);
		}
		
		map.put("recordStart",(Integer.parseInt(pageOn)-1)*Integer.parseInt(pageSize));
		map.put("recordNum", Integer.parseInt(pageSize));
		return courseMapper.getCourseListByPage(map) ;
	}

	@Override
	public List<DailyCourse> getAllCourseListByPage(String pageOn,String PageSize) {
			HashMap<String,Object> map=new HashMap<String,Object>();
			map.put("recordStart",(Integer.parseInt(pageOn)-1)*Integer.parseInt(PageSize));
			map.put("recordNum", Integer.parseInt(PageSize));
			return courseMapper.getAllCourseListByPage(map);
		
		
	}
	
	
}
