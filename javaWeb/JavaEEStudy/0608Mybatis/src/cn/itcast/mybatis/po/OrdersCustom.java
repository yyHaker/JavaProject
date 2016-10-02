package cn.itcast.mybatis.po;

/**
 * 订单类Order的扩展类
 * @author 57217
 *
 */
public class OrdersCustom extends Orders {
      public OrdersCustom() {
		super();
	  }
	
	
   

	//添加user属性
	//user.username,user.sex,user.address
	private String username;
	private String sex;
	private String address;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	
	@Override
	public String toString() {
		return "OrderCustom [username=" + username + ", sex=" + sex
				+ ", address=" + address + "]";
	}
	
	
}
