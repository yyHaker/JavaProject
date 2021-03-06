package com.neuedu.overtime.entity;

import java.util.List;
import cn.thinking.common.page.Page;

public class Overtime {
	private String overtime_id;//加班申请ID(主键)
	private String applicant;//申请人
	private String apply_time;//申请日期
	private String begin_time;//申请起始时间
	private String end_time;//申请结束时间
	private String overtime_reason;//申请原由
	private String submit_time;//提交时间
	private String state;//审批状态
	private String approver;//审批人
	private String reject_reason;//审批驳回原因
	
	private String personnelcode;//人员编码(这个属性是什么意思)
	private String username;//姓名	
	
	private String nameofdepartment;//所在部门名称
	private String DID;//部门编号
	private String dname;//部门名称
	
	private Page page=new Page();
	private List<Overtime> list;//因为在执行更新语句的时候前台传过来的是list，所以在这块要声明并且给出get,set方法来接收这个list
	
	
	public String getOvertime_id() {
		return overtime_id;
	}
	public void setOvertime_id(String overtime_id) {
		this.overtime_id = overtime_id;
	}
	public String getApplicant() {
		return applicant;
	}
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	public String getApply_time() {
		return apply_time;
	}
	public void setApply_time(String apply_time) {
		this.apply_time = apply_time;
	}
	public String getBegin_time() {
		return begin_time;
	}
	public void setBegin_time(String begin_time) {
		this.begin_time = begin_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getOvertime_reason() {
		return overtime_reason;
	}
	public void setOvertime_reason(String overtime_reason) {
		this.overtime_reason = overtime_reason;
	}
	public String getSubmit_time() {
		return submit_time;
	}
	public void setSubmit_time(String submit_time) {
		this.submit_time = submit_time;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
	public String getReject_reason() {
		return reject_reason;
	}
	public void setReject_reason(String reject_reason) {
		this.reject_reason = reject_reason;
	}
	public String getPersonnelcode() {
		return personnelcode;
	}
	public void setPersonnelcode(String personnelcode) {
		this.personnelcode = personnelcode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}	
	public String getNameofdepartment() {
		return nameofdepartment;
	}
	public void setNameofdepartment(String nameofdepartment) {
		this.nameofdepartment = nameofdepartment;
	}		
	public String getDID() {
		return DID;
	}
	public void setDID(String DID) {
		this.DID = DID;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public List<Overtime> getList() {
		return list;
	}
	public void setList(List<Overtime> list) {
		this.list = list;
	}	
}
