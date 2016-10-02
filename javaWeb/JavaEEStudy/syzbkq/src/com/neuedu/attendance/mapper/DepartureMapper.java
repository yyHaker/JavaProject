package com.neuedu.attendance.mapper;

import java.util.List;
import com.neuedu.attendance.entity.Departure;

public interface DepartureMapper {
	//离岗申请主页显示的数据
	public List<Departure> listPageSearchDeparture(Departure departure);
	//申请离岗
	public void insertDeparture(Departure departure);
	//离岗审批
	public void upstatus(List<Departure> departure);

}
