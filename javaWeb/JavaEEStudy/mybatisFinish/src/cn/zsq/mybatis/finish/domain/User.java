package cn.zsq.mybatis.finish.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private int id;
	private String username;
	private Date birthday;
	private String sex;
	private String address;
	
	private String test = null;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User(int id, String username, Date birthday, String sex,
			String address) {
		this.id = id;
		this.username = username;
		this.birthday = birthday;
		this.sex = sex;
		this.address = address;
	}
	public User() {
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", birthday="
				+ birthday + ", sex=" + sex + ", address=" + address + ", test=" + test + "]";
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
}
