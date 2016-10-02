package com.neuedu.xiaorui.controller.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neuedu.xiaorui.entity.CourseEntity;
import com.neuedu.xiaorui.entity.DailyCourse;
import com.neuedu.xiaorui.service.course.CourseService;

/**
 * 课程Controller
 * @author shilei
 *
 */
@Controller
public class CourseController {
	
	/**
	 * 查询某一时间段内某一班级课程
	 * @param classId 班级编号
	 * @param start 开始日期YYYY-MM-DD
	 * @param end 结束日期YYYY-MM-DD
	 * @return 课程列表
	 */
	@Autowired
	@Qualifier("courseService")
	private CourseService courseService;
	
	@RequestMapping(value = "/course/{classId}/{start}/{end}", method = RequestMethod.GET)
	public List<DailyCourse> getCourseList(@PathVariable String classId, @PathVariable String start, @PathVariable String end) {
		
		return courseService.getDailyCourseList(classId, start, end);
	}
	
	/**
	 * 查询指定日期内某一班级课程
	 * @param classId 班级编号
	 * @param day 指定日期YYYY-MM-DD
	 * @return 课程列表
	 */
	@RequestMapping(value = "/course/{classId}/{day}", method = RequestMethod.GET)
	public DailyCourse getDailyCourseList(@PathVariable String classId, @PathVariable String day) {
        /* System.out.println(courseService.getDailyCourse(classId, day));*/
		return courseService.getDailyCourse(classId, day);
	}
//	/**
//	 * 批量增加课程
//	 * @param day
//	 * @return
//	 */
//	@RequestMapping(value = "/course/{beginTime}", method = RequestMethod.GET)
//	@ResponseBody
//	public String addCourse(@PathVariable String beginTime){
//		
//		List<CourseEntity> cList=new ArrayList<CourseEntity>();
//		for(int i=0;i<10;i++){
//			CourseEntity c=new CourseEntity();
//			c.setClassroommc("classroommc"+i);
//			c.setJs("js"+i);
//			c.setJsmc("jsmc"+i);
//			c.setJssj("jssj"+i);
//			c.setKc("kc"+i);
//			c.setKcmc("kcmc"+i);
//			c.setKjmc("kjmc"+i);
//			c.setQssj("qssj"+i);
//			c.setRid("rid"+i);
//			c.setSkrq("2016-06-1a"+i);
//			c.setSzjs("szjs"+i);
//			c.setBjbh("bjbh"+i);
//			c.setBjmc("bjmc"+i);
//			cList.add(c);
//		}
//		courseService.syncCourse(beginTime, cList);
//		return "success";
//	}
	/**
	 * 查询某一日期后的课程列表 分页
	 * @param classId
	 * @param day
	 * @param pageOn
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/course/{classId}/{day}/{courseName}/{pageOn}/{pageSize}", method = RequestMethod.GET)
	public List<DailyCourse> getCourseListByPage(@PathVariable String classId, @PathVariable String day,@PathVariable String courseName, @PathVariable String pageOn, @PathVariable String pageSize){
		 //改路径下没有courseName参数给null,有的话给相应的值
		 /*System.out.println(courseService.getCourseListByPage(classId, day,courseName,pageOn, pageSize));*/
		return courseService.getCourseListByPage(classId, day,courseName,pageOn,pageSize);
	}
	
	/**
	 * 翻页查询所有课程列表
	 * @param pageOn
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="/course/all/{pageOn}/{pageSize}",method=RequestMethod.GET)
	public List<DailyCourse> getAllCourseListByPage(@PathVariable String pageOn,@PathVariable String pageSize){
		
		return courseService.getAllCourseListByPage(pageOn, pageSize);
	}
	
	/**
	 * 测试路径是否连通
	 */
	/* @RequestMapping(value="/course/test",method=RequestMethod.GET)
	 public String getLoadTest(){
		 for(int i=0;i<5;i++){
			 System.out.println(i);
		 }
		 return "hello";
	 }*/
	
}
