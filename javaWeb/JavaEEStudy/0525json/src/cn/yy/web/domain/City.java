package cn.yy.web.domain;

public class City {
 private int cid;
 private String name;
  private Province province; //多方关联一方
  
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Province getProvince() {
	return province;
}
public void setProvince(Province province) {
	this.province = province;
}
@Override
public String toString() {
	return "City [cid=" + cid + ", name=" + name + ", province=" + province
			+ ", getCid()=" + getCid() + ", getName()=" + getName()
			+ ", getProvince()=" + getProvince() + ", getClass()=" + getClass()
			+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
			+ "]";
}
  
  
}
