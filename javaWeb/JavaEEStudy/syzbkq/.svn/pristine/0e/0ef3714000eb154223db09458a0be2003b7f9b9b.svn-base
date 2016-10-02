package com.neuedu.service.kq;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.neuedu.entity.baseinfo.ClassManage;
import com.neuedu.mapper.ClassManageMapper;

@Component
public class ClassManageService {
   @Resource
   private ClassManageMapper classManageMapper;
   //班制主页上显示的数据
   public List<ClassManage> listPageSearchClassManage(ClassManage classManage){
	   return classManageMapper.listPageSearchClassManage(classManage);
   }
   //班组新增
   public void insertClassManage(ClassManage classManage){
	   classManageMapper.insertClassManage(classManage);
   }
   //查看详细信息
   public ClassManage findClassManage (String class_system_id){
	   return classManageMapper.findClassManage(class_system_id);
   }
   //删除数据
   public void deleteClassManage(String class_system_id){
	   classManageMapper.deleteClassManage(class_system_id);
   }
   //修改信息
   public void updateClassManage(ClassManage classManage){
	   classManageMapper.updateClassManage(classManage);
   }
}
