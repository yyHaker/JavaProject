package cn.thinking.org.system.trainer;

import java.util.Date;

import cn.thinking.common.page.Page;

public class Trainer {
	
	private String employeenum;//员工编号
	private String name;//姓名
	private Integer userid;//人员信息表id
	private String sex;//性别
	private Integer age;//年龄
	private Date birthday;//出生年月
	private Integer seniority;//工龄
	private String education;//学历
	private String major;//专业
	private String department;//部门
	private String post;//岗位
	private String politicalstatus;//政治面貌
	private String remark1;//备注1
	
	private Page page;
	
	
	public String getEmployeenum() {
		return employeenum;
	}
	public void setEmployeenum(String employeenum) {
		this.employeenum = employeenum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getSeniority() {
		return seniority;
	}
	public void setSeniority(Integer seniority) {
		this.seniority = seniority;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getPoliticalstatus() {
		return politicalstatus;
	}
	public void setPoliticalstatus(String 

politicalstatus) {
		this.politicalstatus = politicalstatus;
	}
	public String getRemark1() {
		return remark1;
	}
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
	
			
	public Page getPage() {
		if(page==null)
			page = new Page();
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}
