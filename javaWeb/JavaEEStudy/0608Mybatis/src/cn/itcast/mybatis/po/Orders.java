package cn.itcast.mybatis.po;

import java.util.Date;
import java.util.List;

public class Orders {
     private Integer id;
     private Integer user_id;
     private String number;
     private Date createtime;
     private String note;
     //用户信息
     private User user;
     //订单明细
     private List<OrderDetail> orderDetails;
     
     public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
     
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", user_id=" + user_id + ", number="
				+ number + ", createtime=" + createtime + ", note=" + note
				+ ", user=" + user + ", orderDetails=" + orderDetails + "]";
	}
	
	
	
	}
	
	
	
	
	
     
     

