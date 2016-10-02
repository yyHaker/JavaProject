package cn.zsq.mybatis.finish.domain;

import java.util.Date;
import java.util.List;

public class Orders {
	private Integer id;
	private Integer userId;
	private String number;
	private Date createTime;
	private String note;
	
	private User user;
	private List<OrderDetails> orderDetailList;
	
 	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	public Orders(Integer id, Integer userId, String number, Date createTime,
			String note) {
		super();
		this.id = id;
		this.userId = userId;
		this.number = number;
		this.createTime = createTime;
		this.note = note;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", userId=" + userId + ", number=" + number
				+ ", createTime=" + createTime + ", note=" + note + 
				user.toString() + "]";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<OrderDetails> getOrderDetailList() {
		return orderDetailList;
	}
	public void setOrderDetailList(List<OrderDetails> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}
	
}
