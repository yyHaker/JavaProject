package com.neuedu.xiaorui.service.course;

import java.util.List;

import com.neuedu.xiaorui.entity.CourseEntity;
import com.neuedu.xiaorui.entity.DailyCourse;

public interface CourseService {

	/**
	 * 获取指定时间段内的课程列表
	 * @param classId 班级编号
	 * @param start 开始时间 yyyy-MM-dd
	 * @param end 结束时间 yyyy-MM-dd
	 * @return 课程列表
	 */
	public List<DailyCourse> getDailyCourseList(String classId, String start, String end);

	/**
	 * 获取指定日期的课程列表
	 * @param classId 班级编号
	 * @param day 日期  yyyy-MM-dd
	 * @return 课程列表
	 */
	public DailyCourse getDailyCourse(String classId, String day);
	
	/**
	 * 同步指定时间之后的所有课程列表
	 * @param beginTime 同步起始时间
	 * @param courseList 课程列表
	 */
	public void syncCourse(String beginTime, List<CourseEntity> courseList);
	
	/**
	 * 翻页查询课程列表
	 * @param classId 班级编号
	 * @param day 开始日期
	 * @param pageOn 第几页
	 * @param pageSize 每页记录条数
	 * @return
	 */
	public List<DailyCourse> getCourseListByPage(String classId, String day,String courseName, String pageOn,String pageSize);
	
	/**
	 * 翻页查询所有课程列表
	 * @param pageOn  第几页
	 * @param PageSize  每页记录条数
	 * @return
	 */
	public List<DailyCourse> getAllCourseListByPage(String pageOn,String PageSize);
		

}
