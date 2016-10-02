package com.neuedu.xiaorui.mq.course;

import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.neuedu.xiaorui.entity.CourseEntity;
import com.neuedu.xiaorui.service.course.CourseService;
 /**
  * 消息消费者
  * @author 57217
  *
  */
public class CourseListMessageListener implements MessageListener{
	
	@Autowired
	@Qualifier("courseService")
	private CourseService courseService;
	
    @Override
    public void onMessage(Message message) {
        TextMessage tm = (TextMessage) message;
        
        try {
        	String msg = tm.getText();
        	
        	JSONObject json = JSONObject.parseObject(msg);
        	
        	String beginTime = json.getString("begintime");
        	String classId = json.getString("bjbh");
        	String className = json.getString("bjmc");
        	JSONArray courseArray = json.getJSONArray("data");
        	
        	List<CourseEntity> courseList = parseData(classId, className, courseArray);

        	courseService.syncCourse(beginTime, courseList);
        	
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    
    private List<CourseEntity> parseData(String classId, String className, JSONArray courseArray) {
    	List<CourseEntity> courseList = new ArrayList<CourseEntity>();
    	for(int i = 0; i < courseArray.size(); i++) {
    		JSONObject courseObj = courseArray.getJSONObject(i);
    		courseList.add(parseJSONCourse(classId, className, courseObj));
    	}
    	
    	return courseList;
    }
    
       /**
        * 将Course实体转换成JSON类型
        * @param classId
        * @param className
        * @param courseJSON
        * @return
        */
    private CourseEntity parseJSONCourse(String classId, String className, JSONObject courseJSON) {
    	CourseEntity course = new CourseEntity();
    	
    	course.setRid(courseJSON.getString("rid"));
    	course.setCourseDate(courseJSON.getString("skrq"));
    	course.setStartTime(courseJSON.getString("qssj"));
    	course.setEndTime(courseJSON.getString("jssj"));
    	course.setSectionName(courseJSON.getString("kjmc"));
    	course.setClassroomId(courseJSON.getString("szjs"));
    	course.setClassroomName(courseJSON.getString("classroommc"));
    	course.setCourseId(courseJSON.getString("kc"));
    	course.setCourseName(courseJSON.getString("kcmc"));
    	course.setTeacherId(courseJSON.getString("js"));
    	course.setTeacherName(courseJSON.getString("jsmc"));
    	course.setClassId(classId);
    	course.setClassName(className);
    	
    	return course;
    }
}
