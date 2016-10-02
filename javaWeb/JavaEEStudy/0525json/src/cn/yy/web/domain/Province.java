package cn.yy.web.domain;

import java.util.List;

public class Province {
   private int pid;
   private String name;
   private List<City> CityList;//一方关联多方
   
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<City> getCityList() {
	return CityList;
}
public void setCityList(List<City> cityList) {
	CityList = cityList;
}
@Override
public String toString() {
	return "Province [pid=" + pid + ", name=" + name + ", CityList=" + CityList
			+ ", getPid()=" + getPid() + ", getName()=" + getName()
			+ ", getCityList()=" + getCityList() + ", getClass()=" + getClass()
			+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
			+ "]";
}
   
   
}
