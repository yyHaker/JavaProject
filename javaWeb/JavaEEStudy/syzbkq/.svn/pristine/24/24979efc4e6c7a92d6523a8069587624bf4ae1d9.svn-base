package com.neuedu.attendance.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.neuedu.attendance.entity.Departure;
import com.neuedu.attendance.mapper.DepartureMapper;

@Component
public class DepartureService {
   @Resource
   private DepartureMapper departureMapper;
   
   //离岗申请主页显示的数据
   public List<Departure> listPageSearchDeparture(Departure departure){
	   return departureMapper.listPageSearchDeparture(departure);
   }
   //离岗申请
   public void insertDeparture(Departure departure){
	   departureMapper.insertDeparture(departure);
   }
   //离岗审批,可以多条
   public void upstatus(List<Departure> departure){
	   departureMapper.upstatus(departure);
   }
}
