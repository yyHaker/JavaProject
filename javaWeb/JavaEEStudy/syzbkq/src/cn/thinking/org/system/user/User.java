package cn.thinking.org.system.user;

import java.util.Date;

import cn.thinking.common.page.Page;
import cn.thinking.org.system.role.Role;

/**
 * 
 * Description:用户模型映射类 
 * 
 * Department: 沈阳开发二部 
 * @author liu.jia_neu
 * @update [修改人] [修改时间]
 * @version 1.0
 *
 */
public class User {
	private Integer userId;
	private String loginname;
	private String username;
	private String password;
	private String rights;
	private Integer status;
	private Integer roleId;
	private Integer userlevel;
	private String userorgid;
	private String userdeptid;
	private Date lastLogin;
	
	private Role role;
	private Page page;
	private Date lastLoginStart;
	private Date lastLoginEnd;
	
	/**
	 * 用户所属机构名称
	 */
	private String orgname;
	
	/**
	 * 用户所属部门名称
	 */
	private String deptname;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getRights() {
		return rights;
	}
	public void setRights(String rights) {
		this.rights = rights;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Integer getUserlevel() {
		return userlevel;
	}
	public void setUserlevel(Integer userlevel) {
		this.userlevel = userlevel;
	}
	public String getUserorgid() {
		return userorgid;
	}
	public void setUserorgid(String userorgid) {
		this.userorgid = userorgid;
	}
	public String getUserdeptid() {
		return userdeptid;
	}
	public void setUserdeptid(String userdeptid) {
		this.userdeptid = userdeptid;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public Date getLastLoginStart() {
		return lastLoginStart;
	}
	public void setLastLoginStart(Date lastLoginStart) {
		this.lastLoginStart = lastLoginStart;
	}
	public Date getLastLoginEnd() {
		return lastLoginEnd;
	}
	public void setLastLoginEnd(Date lastLoginEnd) {
		this.lastLoginEnd = lastLoginEnd;
	}
	public Page getPage() {
		if(page==null)
			page = new Page();
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public String getOrgname() {
		return orgname;
	}
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
}
