package com.neuedu.entity.baseinfo;

import cn.thinking.common.page.Page;

/**
 * 班组实体类,和班制很像,但没用班制的字段
 * @author Administrator
 */
public class BanTeam {
	private String banTeam_id;//班组主键id
	private String ban_department;//部门名称
	private String ban_name;//班组名称
	private String ban_group;//班组人员
	private Page page = new Page();
	public String getBanTeam_id() {
		return banTeam_id;
	}
	public void setBanTeam_id(String banTeam_id) {
		this.banTeam_id = banTeam_id;
	}
	public String getBan_department() {
		return ban_department;
	}
	public void setBan_department(String ban_department) {
		this.ban_department = ban_department;
	}
	public String getBan_name() {
		return ban_name;
	}
	public void setBan_name(String ban_name) {
		this.ban_name = ban_name;
	}
	public String getBan_group() {
		return ban_group;
	}
	public void setBan_group(String ban_group) {
		this.ban_group = ban_group;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	

}
