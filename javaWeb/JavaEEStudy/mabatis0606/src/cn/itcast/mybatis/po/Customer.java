package cn.itcast.mybatis.po;

public class Customer {
    String cid;
    String cname;
    String city;
    float  discnt;
    
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public float getDiscnt() {
		return discnt;
	}
	public void setDiscnt(float discnt) {
		this.discnt = discnt;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", city=" + city
				+ ", discnt=" + discnt + "]";
	}
	public Customer(String cid, String cname, String city, float discnt) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.city = city;
		this.discnt = discnt;
	}
	public Customer() {
		super();
	}
    
    
    
    
}
