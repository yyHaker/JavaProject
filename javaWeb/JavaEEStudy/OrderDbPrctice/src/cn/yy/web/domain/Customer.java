package cn.yy.web.domain;

public class Customer {
      private String customerNo;
      private String customerName;
      private String telephone;
      private String address;
      private String zip;
      
	public Customer(String customerNo, String customerName, String telephone,
			String address, String zip) {
		super();
		this.customerNo = customerNo;
		this.customerName = customerName;
		this.telephone = telephone;
		this.address = address;
		this.zip = zip;
	}
	
	public Customer() {
		super();
	}

	public String getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "Customer [customerNo=" + customerNo + ", customerName="
				+ customerName + ", telephone=" + telephone + ", address="
				+ address + "]";
	}
      
      
}
