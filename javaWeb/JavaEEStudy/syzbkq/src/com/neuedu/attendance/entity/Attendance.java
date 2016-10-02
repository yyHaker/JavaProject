package com.neuedu.attendance.entity;

import cn.thinking.common.page.Page;

public class Attendance {

	private int userid;//卡持有者ID
	private String personno;//人员号
	private String username;//用户名称
	private String telephone;//电话
	private String mobiletelephone;//移动电话
	private int activity;//卡状态（0：挂失卡；1：正常使用;2=冻结卡,3=报废卡）
	private String createtime;//卡登记日期
	
	private Page page;
		
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getPersonno() {
		return personno;
	}
	public void setPersonno(String personno) {
		this.personno = personno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMobiletelephone() {
		return mobiletelephone;
	}
	public void setMobiletelephone(String mobiletelephone) {
		this.mobiletelephone = mobiletelephone;
	}
	public int getActivity() {
		return activity;
	}
	public void setActivity(int activity) {
		this.activity = activity;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}	
}
