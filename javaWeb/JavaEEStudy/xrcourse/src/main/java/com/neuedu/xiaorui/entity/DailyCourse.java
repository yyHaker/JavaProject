package com.neuedu.xiaorui.entity;

import java.util.List;

public class DailyCourse{

	private String date;
	private List<CourseEntity> courseList;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<CourseEntity> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<CourseEntity> courseList) {
		this.courseList = courseList;
	}
	
}
